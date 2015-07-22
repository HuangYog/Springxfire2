package com.fsnip.platform.global;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	Logger logger = Logger.getLogger(DbUtil.class);
	public Connection getConnection(String url, String username, String password) {
		Connection yConnection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			yConnection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			logger.debug("-----------> 数据库链接失败！");
		} 
		return yConnection;
	}

}
