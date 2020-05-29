package com.gui.Sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.junit.Test;

public class Test5 {
	
	@Test
	public void play() {
		Connection conn = null;
		PreparedStatement state = null;
		
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
		}catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		try {
			String sql = "insert into employees(last_name,first_name,hiredate) values (?,?,?)";
			state = conn.prepareStatement(sql);
			
			state.setString(1, "刘");
			state.setString(2, "毅晗");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse("2000-11-20");
			state.setDate(3, new java.sql.Date(date.getTime()));
			
			state.execute();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				if(state != null)
					state.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
