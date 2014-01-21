package org.fightteam.join.test.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.Test;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class JettyServerTest {

    @Test
    public void test()throws Exception{
        Server server = new Server(8080);

       // Connector connector = new SelectChannelConnector();
        //connector.setPort(8080);

        //server.addConnector(connector);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/mywebapp");

        webAppContext.setWar("src/main/webapp");
        // webAppContext.setWar(ServerRunner.class.getClassLoader().getResource("com/earldouglas/embeddedjetty/mywebapp").toExternalForm())

        server.setHandler(webAppContext);

        server.start();
        server.join();
    }
}
