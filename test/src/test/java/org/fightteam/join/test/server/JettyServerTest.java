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

    private Server server;


    @Test
    public void runServer()throws Exception{
        server = JettyServer.createServerInSource("join-test", 8080 , "/");
    }


}
