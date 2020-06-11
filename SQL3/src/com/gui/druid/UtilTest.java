package com.gui.druid;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.alibaba.druid.util.JdbcUtils;
import com.gui.bean.Employee;

public class UtilTest {
	
	@Test
	public void Test1() {
		
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			DruidTest test = new DruidTest();
			conn = test.getConnect();
			String sql = "insert into employees(first_name,last_name,salary) values(?,?,?)";
			runner.update(conn,sql,"liu","yihan",15000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}
	
	@Test
	public void Test2() {
		Connection conn = null;
		try {
			DruidTest test = new DruidTest();
			conn = test.getConnect();
			QueryRunner runner = new QueryRunner();
			String sql = "select employee_id,first_name,last_name,salary from employees where employee_id = ?";
			BeanHandler<Employee> handler = new BeanHandler<Employee>(Employee.class);
			Employee query = runner.query(conn,sql, handler, 102);
			System.out.println(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
	}
	
	@Test
	public void Test3() {
		Connection conn = null;
		try {
			DruidTest test = new DruidTest();
			conn = test.getConnect();
			QueryRunner runner = new QueryRunner();
			String sql = "select count(*) from employees where employee_id < ?";
			//MapHandler handler = new MapHandler();
			ScalarHandler handler = new ScalarHandler();
			Long count= (Long) runner.query(conn,sql, handler, 110);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbUtils.closeQuietly(conn);
		}
	}
	
}
