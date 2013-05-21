package org.excalibur.join.framework.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author: excalibur
 * Date: 13-4-28
 * Time: 下午2:11
 * 基础控制类 框架框架级别
 * 定义了非常常用的一些方法
 */
public class BaseController extends AbstractController {
    //设置protected request对象 以方便子类使用该属性
    @Autowired
    protected HttpServletRequest request;

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {
        return null;
    }

}
