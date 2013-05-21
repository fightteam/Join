package org.excalibur.join.framework.aop;

import org.excalibur.join.framework.core.response.Response;
import org.springframework.aop.ThrowsAdvice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * author: excalibur
 * Date: 13-5-4
 * Time: 上午11:09
 * aop 继承spring ThrowsAdvice 增加后续或者 初始操作
 */
public class ExceptionHandlerAdvice implements ThrowsAdvice {
    private Logger log = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    private Response response;

    public void setResponse(final Response response) {
        this.response = response;
    }


    /**
     * Gets called after the Exception is thrown at the code level
     *
     * @param m      Method where the exception was thrown
     * @param args   Arguments sent to that method
     * @param target The enclosing class of the method
     * @param ex     The exception that was thrown
     */
    public void afterThrowing(Method m, Object[] args, Object target, Throwable ex) {
        log.error("Exception in method: " + m.getName() + " Exception is: " + ex.getMessage());

        if (response != null)
            response.setError(500, ex.getMessage());

        log.error("Response: " + response.toString());
    }


    /**
     * Gets called after the Exception is thrown at the code level
     *
     * @param m      Method where the exception was thrown
     * @param args   Arguments sent to that method
     * @param target The enclosing class of the method
     * @param ex     The exception that was thrown
     */
    public void afterThrowing(Method m, Object[] args, Object target, Exception ex) {
        log.error("Exception in method: " + m.getName() + " Exception is: " + ex.getMessage());

        if (response != null)
            response.setError(500, ex.getMessage());

        log.error("Response: " + response);
    }
}
