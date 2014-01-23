package org.fightteam.join.test.server;

import org.eclipse.jetty.deploy.DeploymentManager;
import org.eclipse.jetty.deploy.providers.WebAppProvider;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
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
    private static final String DEFAULT_WEBDEFAULT_PATH = "webdefault.xml";
    private static final List<String> classPaths = new ArrayList<String>();

    static {
        classPaths.add("build/classes/main");
        classPaths.add("build/classes/test");
    }

    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录。
     * @param port 监听端口
     * @param contextPath
     * @return
     */
    public static Server createServerInSource(int port, String contextPath) {
        return createServerInSource(DEFAULT_WEBAPP_PATH, port, contextPath, DEFAULT_WEBDEFAULT_PATH);
    }

    /**
     * 创建用于开发运行调试的Jetty Server
     * @param projectPath
     * @param port
     * @param contextPath
     * @return
     */
    public static Server createServerInSource(String projectPath, int port, String contextPath) {
        return createServerInSource(projectPath+"/"+DEFAULT_WEBAPP_PATH, port, contextPath, DEFAULT_WEBDEFAULT_PATH);
    }

    /**
     * 创建用于开发运行调试的Jetty Server。
     * @param webappPath
     * @param port 监听端口
     * @param contextPath
     * @param webDeaultPath
     * @return
     */
    public static Server createServerInSource(String webappPath, int port, String contextPath, String webDeaultPath) {
        Server server = new Server();
        //设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        //解决Windows下重复启动Jetty居然不报告端口冲突的问题.
        connector.setReuseAddress(false);
        server.setConnectors(new Connector[] { connector });
        // 解决热部署问题
        DeploymentManager deploymentManager = new DeploymentManager();
        WebAppProvider webAppProvider = new WebAppProvider();
//        webAppProvider.setScanInterval(1);
        webAppProvider.setMonitoredDirName(webappPath);
        ContextHandlerCollection contextHandlerCollection = new ContextHandlerCollection();

        deploymentManager.setContexts(contextHandlerCollection);
        deploymentManager.setContextAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/servlet-api-[^/]*\\.jar$");
        deploymentManager.addAppProvider(webAppProvider);
        server.addBean(deploymentManager);

        HandlerCollection handlerCollection = new HandlerCollection();
        DefaultHandler defaultHandler = new DefaultHandler();
        handlerCollection.addHandler(contextHandlerCollection);
        handlerCollection.addHandler(defaultHandler);
        server.setHandler(handlerCollection);


        WebAppContext webContext = new WebAppContext(webappPath, contextPath);
        //修改webdefault.xml，解决Windows下Jetty Lock住静态文件的问题.
        webContext.setDefaultsDescriptor(webDeaultPath);

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
        for(String path : classPaths){
            classLoader.addClassPath(path);
        }
        context.setClassLoader(classLoader);

        context.start();

        System.out.println("Application reloaded");
    }
}
