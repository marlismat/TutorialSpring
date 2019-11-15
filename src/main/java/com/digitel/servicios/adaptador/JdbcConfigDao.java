package com.digitel.servicios.adaptador;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository("JdbcConfigDao")
@PropertySource("classpath:application.properties")
public class JdbcConfigDao {


	
	 private static JdbcTemplate jdbcConfigTemplate;

	 @Value( "${legacy.datasource.url}" )
	 private String url;
	 @Value( "${legacy.datasource.username}" )
	 private String username;
	 @Value( "${legacy.datasource.password}" )
	 private String password;
	// @Value( "${spring.datasource.driver-class-name}" )
	// private String driver;	
	 @Value( "${legacy.datasource.hikari.connection-timeout}" )
	 private int timeout;
	 @Value( "${legacy.datasource.hikari.maximum-pool-size}" )
	 private int max;
	
	@Autowired
	public void setJdbcTemplate() {
		System.out.println("Prueba de valores de conexion set y get");
		System.out.println(url);				
		System.out.println(username);
		System.out.println(password);
	//	System.out.println(driver);	
		
		 BasicDataSource dataSource  = new BasicDataSource();	
		 dataSource.setUrl(url);
		 dataSource.setUsername(username);
		 dataSource.setPassword(password);
	//	 dataSource.setDriverClassName(driver);
		 dataSource.setDefaultQueryTimeout(timeout);
		 dataSource.setMaxTotal(max);
		 JdbcConfigDao.jdbcConfigTemplate = new JdbcTemplate(dataSource);
		// dataSource.setEnableAutoCommitOnReturn(false);
		// dataSource.setDefaultAutoCommit(false);
	}

	
	public static JdbcTemplate getJdbcTemplate() { // instancia en memoria
		return jdbcConfigTemplate;
	}

	 
}

