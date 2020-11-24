package demo.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerDemo implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("1 - Listener init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁Application");
    }
}
