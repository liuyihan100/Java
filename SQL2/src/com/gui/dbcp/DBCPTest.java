package com.gui.dbcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

public class DBCPTest {

	@Test
	public void Test() throws Exception{
		FileInputStream is = new FileInputStream(new File("src/JDBC.properties"));
		Properties pros = new Properties();
		pros.load(is);
		BasicDataSource source = BasicDataSourceFactory.createDataSource(pros);
		
		Connection conn = source.getConnection();
		System.out.println(conn);
	}
}
