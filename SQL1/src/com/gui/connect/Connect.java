package com.gui.connect;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Connect {
	
	@Test
	public void getConnect() {
		ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
		Connection conn = null;
		try {
			conn = cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(conn);
	}
	
}
