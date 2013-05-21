package org.excalibur.join.framework.web.dispatcher;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author: excalibur
 * Date: 13-4-28
 * Time: 下午1:39
 * 基础servlet
 * 采用继承spring的dispatcherservlet实现
 * 为了获得spring的功能 与 扩展自己的功能
 */
public class BaseDispatcherServlet extends DispatcherServlet {
    protected void doService(final HttpServletRequest request,
                             final HttpServletResponse response) throws Exception {
        super.doService(request, response);
    }

    protected void doDispatch(final HttpServletRequest request,
                              final HttpServletResponse response) throws Exception {

        super.doDispatch(request, response);
    }

    protected void service(final HttpServletRequest request,
                           final HttpServletResponse response) throws ServletException,
            IOException {
        super.service(request, response);
    }
}
