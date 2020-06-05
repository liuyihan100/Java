package com.gui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gui.bean.Employee;
import com.gui.util.JDBCUtil;

public class QueryAllDao {
	
	public static List<Employee> queryAll(){
		Employee employee = null;
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			conn = JDBCUtil.getConnect();
			String sql = "select employee_id employeeId,first_name firstName,last_name lastName,salary from employees";
			state = conn.prepareStatement(sql);
			rs = state.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int salary = rs.getInt(4);
				employee = new Employee(employeeId,firstName,lastName,salary);
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(conn, state, rs);
		}
		return list;
	}
}
