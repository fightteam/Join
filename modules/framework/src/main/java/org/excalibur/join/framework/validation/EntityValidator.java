package org.excalibur.join.framework.validation;

import org.apache.commons.lang3.text.WordUtils;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author: excalibur
 * Date: 13-5-4
 * Time: 上午11:40
 * To change this template use File | Settings | File Templates.
 */
public class EntityValidator<T> {
    private Logger log = LoggerFactory.getLogger(EntityValidator.class);

    /**
     * 验证  T 对象
     *
     * @param bean
     * @return
     */
    public Validity validate(T bean, Class<T> beanClass) {
        HashSet<String> err = new HashSet<String>();
        ValidatorFactory validatorFactory = Validation
                .buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(bean);
        for (ConstraintViolation<T> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString()
                    .toLowerCase();
            String message = violation.getMessage();
            String errMsg = WordUtils.capitalize(propertyPath) + " " + message;

            log.error("Invalid Value: '" + errMsg);
            err.add(errMsg);
        }

        // Checking for hibernate validations
        err.addAll(hValidate(bean, beanClass));

        List result = new ArrayList(err);
        return new Validity(result.isEmpty(), result);
    }

    /**
     * 验证通过bean使用hibernate应用程序级验证
     *
     * @param bean
     * @param beanClass
     * @return
     */
    public HashSet<String> hValidate(T bean, Class<T> beanClass) {
        HashSet<String> err = new HashSet<String>();
        HibernateValidatorConfiguration config = Validation.byProvider(
                HibernateValidator.class).configure();
        Validator validator = config.buildValidatorFactory().getValidator();

        Set<ConstraintViolation<T>> hErrs = validator.validate(bean);
        log.info("Hibernate Validity Errors: " + hErrs.size());

        for (ConstraintViolation<T> violation : hErrs) {
            String propertyPath = violation.getPropertyPath().toString()
                    .toLowerCase();
            String message = violation.getMessage();
            String errMsg = WordUtils.capitalize(propertyPath) + " " + message;

            log.info("Invalid Value: '" + errMsg);
            err.add(errMsg);
        }

        return err;
    }
}
