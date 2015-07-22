package com.fsnip.platform.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class JdbcConfig {
	public static String db;
	public static String url;
	public static String username;
	public static String password;
	
	static {   
        Properties prop = new Properties();   
        InputStream in = JdbcConfig.class.getResourceAsStream("/jdbc.properties");   
        try {   
            prop.load(in);   
            db = prop.getProperty("jdbc.db").trim();  
            url = prop.getProperty("jdbc.jdbcUrl").trim(); 
            username = prop.getProperty("jdbc.user").trim(); 
            password = prop.getProperty("jdbc.password").trim(); 
            
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
	
	
}
