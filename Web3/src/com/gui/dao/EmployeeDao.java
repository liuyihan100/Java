package com.gui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gui.bean.Employee;
import com.gui.util.JDBCUtil;

public class EmployeeDao {
	
	public static Employee query(int id){
		
		String sql = "select employee_id employeeId,first_name firstName,last_name lastName,salary from employees where employee_id = ?";
		List<Employee> employees = JDBCUtil.query(sql, id);
		return employees.get(0);
	}
	
	public static List<Employee> queryAll(){
		
		String sql = "select employee_id employeeId,first_name firstName,last_name lastName,salary from employees";
		return JDBCUtil.query(sql);
	}
	
	public static int add(Employee employee){
		String sql = "insert into employees(employee_id,first_name,last_name,salary) values(?,?,?,?)";
		return JDBCUtil.update(sql, employee.getEmployeeId(),employee.getFirstName(),employee.getLastName(),employee.getSalary());
	}
	
	public static int delete(int id){
		String sql = "delete from employees where employee_id = ?";
		return JDBCUtil.update(sql, id);
	}
	
	public static int update(int id,Employee employee){
		String sql = "update employees set employee_id = ? , first_name = ? ,last_name = ? , salary = ? where employee_id = ?";
		return JDBCUtil.update(sql,employee.getEmployeeId(), employee.getFirstName(),employee.getLastName(),employee.getSalary(),id);
	}
	
	public static List<Employee> queryByPage(int currentPage,int pageSize){
		String sql = "select employee_id employeeId,first_name firstName,last_name lastName,salary from employees limit ?,?";
		return JDBCUtil.query(sql, (currentPage - 1) * pageSize, pageSize);
	}
	
	public static int getTotalNum() {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		int result = -1;
		try {
			conn = JDBCUtil.getConnect();
			String sql = "select count(*) from employees";
			state = conn.prepareStatement(sql);
			rs = state.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(conn, state, rs);
		}
		return result;
	}
}
