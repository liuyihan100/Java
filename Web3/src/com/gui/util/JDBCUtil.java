package com.gui.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.gui.bean.Employee;

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
	
	public static int update(String sql,Object...args) {
		Connection conn = null;
		PreparedStatement state = null;
		int result = -1;
		try {
			conn = JDBCUtil.getConnect();
			state = conn.prepareStatement(sql);
			if(args != null) {
				for(int i = 0;i < args.length;i++) {
					state.setObject(i + 1, args[i]);
				}
				result = state.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(conn, state, null);
		}
		return result;
	}
	
	public static List<Employee> query(String sql,Object...args){
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try {
			conn = JDBCUtil.getConnect();
			state = conn.prepareStatement(sql);
			if(args.length > 0) {
				for(int j = 0;j < args.length;j++) {
					state.setObject(j + 1, args[j]);
				}
			}
			rs = state.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				employees.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(conn, state, rs);
		}
		return employees;
	}
}
