package com.gui.druid;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidTest {
	
	public Connection getConnect() throws Exception {
		
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Druid.properties");
		Properties pros = new Properties();
		pros.load(is);
		
		DataSource source = DruidDataSourceFactory.createDataSource(pros);
		Connection conn = source.getConnection();
		
		return conn;
	}

}
