package org.fightteam.join.test.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.Jetty;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.junit.Test;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class JettyServerTest {

    @Test
    public void test01()throws Exception{
        Server server = new Server(8080);

        server.start();
//        server.join();
    }

    @Test
    public void test02()throws Exception{
        Server server = new Server(8080);
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/mywebapp");
        webAppContext.setResourceBase("src/main/webapp");
        server.setHandler(webAppContext);
        server.start();
//        server.join();
    }

    @Test
    public void test03()throws Exception{
        Server server = JettyServer.createServerInSource(8080,"/");
        server.start();
//        server.join();

    }
}
