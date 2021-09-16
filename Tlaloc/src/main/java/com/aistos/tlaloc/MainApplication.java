package com.aistos.tlaloc;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.aistos.tlaloc.data.DataSource;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class MainApplication {
	
	private static Log logger = LogFactory.getLog(MainApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
				
	}
	
	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {
			@Override
			public void contextInitialized(ServletContextEvent sce) {
				try {
					DataSource dbConnector = DataSource.getInstance();
					dbConnector.getConnection();
					logger.info("ServletContext initialized");	
				} catch (IOException | SQLException | PropertyVetoException e) {logger.error("erreur serveur : " + e.getMessage());}	
			}
			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				logger.info("ServletContext destroyed");
			}		
		};
	}
		
}
