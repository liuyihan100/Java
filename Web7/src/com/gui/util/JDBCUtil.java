package com.gui.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	
	public static Connection getConnect() throws Exception{
		InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("source.properties");
		Properties pros = new Properties();
		pros.load(is);
		
		String driverClass = pros.getProperty("class");
		String url = pros.getProperty("url");
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	public static void closeSource(Connection conn,Statement state,ResultSet rs) {
		try {
			if(conn != null) conn.close();
			if(state != null) state.close();
			if(rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
