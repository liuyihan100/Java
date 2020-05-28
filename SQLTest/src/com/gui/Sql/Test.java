package com.gui.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	private static String url = "jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC";
	private static String user = "root";
	private static String password = "liuyihan";
	
	public static void play() {
		Connection conn = null;
		//Statement state = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
//			state = conn.createStatement();
//			String sent = "select * from employees";
//			int count = state.executeUpdate(sent);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Test.play();
	}
}
