package com.aaron.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerDemo implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("创建Application");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁Application");
    }
}
