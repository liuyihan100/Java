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
	
	public static int add(int employeeId,String firstName,String lastName,int salary){
		Connection conn = null;
		PreparedStatement state = null;
		int result = -1;
		try {
			conn = JDBCUtil.getConnect();
			String sql = "insert into employees(employee_id,first_name,last_name,salary) values(?,?,?,?)";
			state = conn.prepareStatement(sql);
			state.setObject(1, employeeId);
			state.setObject(2, firstName);
			state.setObject(3, lastName);
			state.setObject(4, salary);
			result = state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(conn, state, null);
		}
		return result;
	}
	
	public static int delete(int id){
		Connection conn = null;
		PreparedStatement state = null;
		int result = -1;
		try {
			conn = JDBCUtil.getConnect();
			String sql = "delete from employees where employee_id = ?";
			state = conn.prepareStatement(sql);
			state.setObject(1, id);
			result = state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(conn, state, null);
		}
		return result;
	}
	
	public static int update(int id,int employeeId,String firstName,String lastName,int salary){
		Connection conn = null;
		PreparedStatement state = null;
		int result = -1;
		try {
			conn = JDBCUtil.getConnect();
			String sql = "update employees set employee_id = ? , first_name = ? ,last_name = ? , salary = ? where employee_id = ?";
			state = conn.prepareStatement(sql);
			state.setObject(5, id);
			state.setObject(1, employeeId);
			state.setObject(2, firstName);
			state.setObject(3, lastName);
			state.setObject(4, salary);
			result = state.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeSource(conn, state, null);
		}
		return result;
	}
	
}
