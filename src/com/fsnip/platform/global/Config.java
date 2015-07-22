package com.fsnip.platform.global;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {
	public static String debug;
	public static String page_size;
	public static String page_list;
	
	public static String db_url;
	public static String db_username;
	public static String db_password;
	
	public static String ftp_host;
	public static String ftp_port;
	public static String ftp_isPassiveMode;
	public static String ftp_username;
	public static String ftp_password;
	
	public static String is_http;
	public static String image_path;
	public static String web_image_path;
	
	static {   
        Properties prop = new Properties();   
        InputStream in = Config.class.getResourceAsStream("/app.properties");   
        try {   
            prop.load(in);   
            debug = prop.getProperty("debug").trim();  
            page_size = prop.getProperty("page_size").trim(); 
          //  page_list = prop.getProperty("page_list").trim(); 
            
            db_url = prop.getProperty("db_url").trim(); 
            db_username = prop.getProperty("db_username").trim(); 
            db_password = prop.getProperty("db_password").trim(); 
            
            ftp_host = prop.getProperty("ftp_host").trim(); 
            ftp_port = prop.getProperty("ftp_port").trim(); 
            ftp_isPassiveMode = prop.getProperty("ftp_isPassiveMode").trim(); 
            ftp_username = prop.getProperty("ftp_username").trim(); 
            ftp_password = prop.getProperty("ftp_password").trim(); 
            
            is_http = prop.getProperty("is_http").trim();
            image_path = prop.getProperty("image_path").trim();
            web_image_path = prop.getProperty("web_image_path").trim(); 
            
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
}
