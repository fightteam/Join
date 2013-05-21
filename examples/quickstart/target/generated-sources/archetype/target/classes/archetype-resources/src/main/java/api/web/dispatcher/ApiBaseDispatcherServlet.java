#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.web.dispatcher;

import ${package}.framework.web.dispatcher.BaseDispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author: excalibur
 * Date: 13-4-29
 * Time: 下午9:52
 * 基础 api dispatcher
 */
public class ApiBaseDispatcherServlet  extends BaseDispatcherServlet {
    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doService(request, response);
    }

    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

        super.doDispatch(request, response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(request.getRequestURI());

        super.service(request, response);
    }
}
