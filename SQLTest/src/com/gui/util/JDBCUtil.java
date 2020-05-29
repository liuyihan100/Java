package com.gui.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Connection conn = null;
		
		InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("sourse.properties");
		
		Properties pros = new Properties();
		pros.load(is);
		
		String driverClass = pros.getProperty("class");
		String url = pros.getProperty("url");
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		
		Class.forName(driverClass);
		conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	public static void closeSource(Connection conn,Statement state) {
		try {
			if(state != null)
				state.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeSource(Connection conn,Statement state,ResultSet re) {
		try {
			if(state != null)
				state.close();
			if(conn != null)
				conn.close();
			if(re != null)
				re.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
