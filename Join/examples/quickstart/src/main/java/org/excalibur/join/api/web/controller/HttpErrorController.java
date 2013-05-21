package org.excalibur.join.api.web.controller;

import org.excalibur.join.api.web.common.ApiRouter;
import org.excalibur.join.api.web.common.HttpError;
import org.excalibur.join.framework.core.common.Const;
import org.excalibur.join.framework.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * author: excalibur
 * Date: 13-4-30
 * Time: 上午11:37
 * http请求错误controller
 * 不提供视图  只是提供 json xml 等（使用ContentNegotiatingViewResolver实现）的数据
 *
 */
@Controller
@RequestMapping(ApiRouter.errorController)
public class HttpErrorController extends ApiBaseController{
    @Autowired
    private HttpError httpError;

    @RequestMapping(value = "/400")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ModelAndView badRequest() {
       System.out.println("********************");
       System.out.println("400");
        Response response = this.serverResponse();
        response.setError(httpError.brCode, httpError.brMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ModelAndView unauthorised() {
        System.out.println("********************");
        System.out.println("401");
        Response response = this.serverResponse();
        response.setError(httpError.uaCode, httpError.uaMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ModelAndView notFound(Model model) {
        System.out.println("********************");
        System.out.println("404");

        Response response = this.serverResponse();
        response.setError(httpError.nfCode, httpError.nfMsg);
        System.out.println(response);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/405")
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ModelAndView methodNotAllowed() {
        System.out.println("********************");
        System.out.println("405");
        Response response = this.serverResponse();
        response.setError(httpError.mnaCode, httpError.mnaMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/408")
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ResponseBody
    public ModelAndView requestTimeout() {
        System.out.println("********************");
        System.out.println("408");
        Response response = this.serverResponse();
        response.setError(httpError.rtCode, httpError.rtMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/415")
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public ModelAndView unsupportedMediaType() {
        System.out.println("********************");
        System.out.println("415");
        Response response = this.serverResponse();
        response.setError(httpError.umtCode, httpError.umtMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/500")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ModelAndView internalServerError() {
        System.out.println("********************");
        System.out.println("500");
        Response response = this.serverResponse();
        response.setError(httpError.iseCode, httpError.iseMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/501")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ResponseBody
    public ModelAndView notImplemented() {
        System.out.println("********************");
        System.out.println("501");
        Response response = this.serverResponse();
        response.setError(httpError.niCode, httpError.niMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/503")
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ResponseBody
    public ModelAndView serviceUnavailable() {
        System.out.println("********************");
        System.out.println("503");
        Response response = this.serverResponse();
        response.setError(httpError.suCode, httpError.suMsg);
        return mav().addObject(Const.responseKey, response);
    }



}
