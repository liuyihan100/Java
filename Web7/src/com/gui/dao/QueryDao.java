package com.gui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gui.bean.Employee;
import com.gui.util.JDBCUtil;

public class QueryDao {
	
	public static Employee query(int id){
		Employee employee = null;
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnect();
			String sql = "select employee_id employeeId,first_name firstName,last_name lastName,salary from employees where employee_id = ?";
			state = conn.prepareStatement(sql);
			state.setObject(1, id);
			rs = state.executeQuery();
			if(rs.next()) {
				int employeeId = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int salary = rs.getInt(4);
				employee = new Employee(employeeId,firstName,lastName,salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(conn, state, rs);
		}
		return employee;
	}
}
