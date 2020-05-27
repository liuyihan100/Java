package com.gui.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mainTest {
	public static void main(String[] args) {
		Connection conn = null;
		// ×¢²áÇý¶¯
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC", "root", "liuyihan");
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}