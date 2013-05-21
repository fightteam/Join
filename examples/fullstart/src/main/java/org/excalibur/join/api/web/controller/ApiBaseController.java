package org.excalibur.join.api.web.controller;

import org.excalibur.join.common.Key;
import org.excalibur.join.framework.core.common.Const;
import org.excalibur.join.framework.core.model.entity.Entity;
import org.excalibur.join.framework.core.response.Response;
import org.excalibur.join.framework.service.BaseService;
import org.excalibur.join.framework.validation.Validity;
import org.excalibur.join.framework.web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * author: excalibur
 * Date: 13-4-30
 * Time: 上午11:36
 * api 基础controller
 */
public class ApiBaseController extends BaseController {
    private Logger log = LoggerFactory.getLogger(ApiBaseController.class);
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Key key;

    protected Response serverResponse() {
        Response response = new Response();
      //  exceptionHandlerAdvice.setResponse(response);
        return response;
    }


    protected ModelAndView mav() {
        return new ModelAndView();
    }


    public Response validateAndSaveEntity(Entity entity, BaseService service) {
        Response response = serverResponse();
        try {
            Validity vsEntity = service.validate(entity);
            if (vsEntity.isValid()) {
                service.insert(entity);
                response.setResult(entity);
            } else {
                response.setError(key.vdnCode, vsEntity.errors());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setError(key.iseCode, e.getMessage());
        }

        return response;
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ModelAndView exceptionHandler(Exception ex) {
        Response response = new Response();
        response.setError(500, ex.getMessage());
        log.error("Response: " + response.toString());
        return mav().addObject(Const.responseKey, response);
    }
}
