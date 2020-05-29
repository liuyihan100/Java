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
			// 1����������
			conn = JDBCUtil.getConnection();
			// 2��Ԥ����sql��䣬����preparedStatementʵ��
			String sql = "select last_name,phone_number,salary,hiredate from employees where employee_id = ?";
			state = conn.prepareStatement(sql);
			// 3�����ռλ��
			state.setObject(1, "190");
			// 4��ִ�����
			re = state.executeQuery();
			// 5����������
			while (re.next()) {
				String last_name = re.getString(1);
				String phone_number = re.getString(2);
				int salary = re.getInt(3);
				Date hiredate = re.getDate(4);

				Employee employee = new Employee(last_name, phone_number, salary, hiredate);
				System.out.println(employee);
			}
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			// 6���ر���Դ
			JDBCUtil.closeSource(conn, state, re);
		}
	}
}
