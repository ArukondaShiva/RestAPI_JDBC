package com.example.JdbcExample.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

	@Bean
	public Connection getConnection() {
	
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl43","root","Shiva_123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}

