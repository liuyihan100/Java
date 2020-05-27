package com.gui.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.jupiter.api.Test;

public class Success {
	@Test
	public void play() throws SQLException {
		Driver driver = new com.mysql.cj.jdbc.Driver();
		
		String url = "jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC";
		
		String user = "root";
		String password = "liuyihan";
		Properties info = new Properties();
		info.setProperty("user", user);
		info.setProperty("password", password);
		
		Connection conn = driver.connect(url, info);
		
		System.out.print(conn);
	}
}
