package com.clustertrial;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Contexto iniciado.");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Contexto finalizado.");
	}

}
