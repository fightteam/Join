package org.fightteam.join.test.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.ArrayList;
import java.util.List;

/**
 * jetty配置 为了方便开发快速测试
 *
 * @author faith
 * @since 0.0.1
 */
public class JettyServer {
    private static final String DEFAULT_WEBAPP_PATH = "src/main/webapp";
    private static final String WINDOWS_WEBDEFAULT_PATH = "webdefault.xml";
    private static final List<String> classPaths = new ArrayList<String>();

    static {
        classPaths.add("");
    }
    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server createServerInSource(int port, String contextPath) {
        Server server = new Server();
        //设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        //解决Windows下重复启动Jetty居然不报告端口冲突的问题.
        connector.setReuseAddress(false);
        server.setConnectors(new Connector[] { connector });

        WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, contextPath);
        //修改webdefault.xml，解决Windows下Jetty Lock住静态文件的问题.
        webContext.setDefaultsDescriptor(WINDOWS_WEBDEFAULT_PATH);
        server.setHandler(webContext);

        return server;
    }

    /**
     * 快速重新启动application，重载target/classes与target/test-classes.
     */
    public static void reloadContext(Server server) throws Exception {
        WebAppContext context = (WebAppContext) server.getHandler();

        System.out.println("Application reloading");
        context.stop();

        WebAppClassLoader classLoader = new WebAppClassLoader(context);
        classLoader.addClassPath("build/classes/main");
        classLoader.addClassPath("target/test-classes");
        context.setClassLoader(classLoader);

        context.start();

        System.out.println("Application reloaded");
    }
}
