package com.gui.Sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.gui.bean.Employee;
import com.gui.util.JDBCUtil;

public class Select {

	@Test
	public void play() {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet re = null;
		try {
			// 1、建立连接
			conn = JDBCUtil.getConnection();
			// 2、预编译sql语句，返回preparedStatement实例
			String sql = "select last_name,phone_number,salary,hiredate from employees where employee_id = ?";
			state = conn.prepareStatement(sql);
			// 3、填充占位符
			state.setObject(1, "190");
			// 4、执行语句
			re = state.executeQuery();
			// 5、处理结果集
			while (re.next()) {
				String last_name = re.getString(1);
				String phone_number = re.getString(2);
				int salary = re.getInt(3);
				Date hiredate = re.getDate(4);

				Employee employee = new Employee(last_name, phone_number, salary, hiredate);
				System.out.println(employee);
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			// 6、关闭资源
			JDBCUtil.closeSource(conn, state, re);
		}
	}
}
