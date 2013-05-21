package it.pkg.web.dispatcher;

import it.pkg.framework.web.dispatcher.BaseDispatcherServlet;
import it.pkg.web.common.Router;
import it.pkg.web.common.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author: excalibur
 * Date: 13-4-29
 * Time: 下午9:56
 * app dispatcher
 */
public class AppBaseDispatcherServlet extends BaseDispatcherServlet {
    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doService(request, response);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doDispatch(request, response);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---------------------");
        System.out.println(request.getRequestURI());

        super.service(request, response);
    }
}
