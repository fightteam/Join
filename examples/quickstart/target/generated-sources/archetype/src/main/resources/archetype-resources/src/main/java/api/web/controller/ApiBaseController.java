#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.web.controller;

import ${package}.common.Key;
import ${package}.framework.core.common.Const;
import ${package}.framework.core.model.entity.Entity;
import ${package}.framework.core.response.Response;
import ${package}.framework.service.BaseService;
import ${package}.framework.validation.Validity;
import ${package}.framework.web.controller.BaseController;
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

    /**
     * 验证业务类
     * @param entity 实体
     * @param service 业务类
     * @return
     */
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

    /**
     * 拦截异常处理
     * @param ex
     * @retur
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ModelAndView exceptionHandler(Exception ex) {
        Response response = new Response();
        response.setError(500, ex.getMessage());
        log.error("Response: " + response.toString());
        return mav().addObject(Const.responseKey, response);
    }
}
