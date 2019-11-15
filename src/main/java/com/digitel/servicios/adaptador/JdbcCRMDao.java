package com.digitel.servicios.adaptador;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository("JdbcCRMDao")
@PropertySource("classpath:application.properties")
public class JdbcCRMDao {


	
	 private static JdbcTemplate jdbcTemplate;

	 @Value( "${spring.datasource.url}" )
	 private String url;
	 @Value( "${spring.datasource.username}" )
	 private String username;
	 @Value( "${spring.datasource.password}" )
	 private String password;
	// @Value( "${spring.datasource.driver-class-name}" )
	// private String driver;	
	 @Value( "${spring.datasource.hikari.connection-timeout}" )
	 private int timeout;
	 @Value( "${spring.datasource.hikari.maximum-pool-size}" )
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
		 JdbcCRMDao.jdbcTemplate = new JdbcTemplate(dataSource);
		// dataSource.setEnableAutoCommitOnReturn(false);
		// dataSource.setDefaultAutoCommit(false);
	}

	
	public static JdbcTemplate getJdbcTemplate() { // instancia en memoria
		return jdbcTemplate;
	}

	 
}

