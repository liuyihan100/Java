package com.gui.Sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Test5 {
	
	public void play() {
		Connection conn = null;
		
		InputStream is = Test5.class.getClassLoader().getResourceAsStream("sourse.properties");
		
		Properties pros = new Properties();
		try {
			pros.load(is);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		String driverClass = pros.getProperty("class");
		String url = pros.getProperty("url");
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		System.out.print(conn);
	}
}
