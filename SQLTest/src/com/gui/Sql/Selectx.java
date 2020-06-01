package com.gui.Sql;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gui.bean.Employee;
import com.gui.util.JDBCUtil;

public class Selectx {
	
	public List<Employee> query(String sql,Object...args){
		Connection conn = null;
		ArrayList<Employee> arrayList = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
			//1���������ӣ����������б�
			conn = JDBCUtil.getConnection();
			arrayList = new ArrayList<Employee>();
			//2��Ԥ����sql��䣬����prepareStatementʵ��
			state = conn.prepareStatement(sql);
			//3�����ռλ��
			for(int i = 0;i < args.length;i++) {
				state.setObject(i + 1, args[i]);
			}
			//4��ִ�����
			rs = state.executeQuery();
			//5����ȡԪ���ݼ��������
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			//6����������
			while(rs.next()) {
				Employee employee = new Employee();
				for(int i = 0;i < columnCount;i++) {
					String columnName = rsmd.getColumnName(i + 1);
					Object columnValue = rs.getObject(i + 1);
					Field declaredField = Employee.class.getDeclaredField(columnName);
					declaredField.setAccessible(true);
					declaredField.set(employee, columnValue);
				}
				arrayList.add(employee);
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			JDBCUtil.closeSource(conn, state, rs);
		}
		return arrayList;
	}
	
	@Test
	public void test1() {
		String sql = "select last_name,salary from employees where employee_id > ? and employee_id < ?";
		List<Employee> query = query(sql, 100,105);
		query.forEach(System.out::println);
	}
	
	public <T> List<T> query(Class<T> clazz,String sql,Object...args){
		Connection conn = null;
		ArrayList<T> arrayList = new ArrayList<T>();
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
			//1���������ӣ����������б�
			conn = JDBCUtil.getConnection();
			//2��Ԥ����sql��䣬����preparedStatementʵ��
			state = conn.prepareStatement(sql);
			//3�����ռλ��
			for(int i = 0;i < args.length;i++) {
				state.setObject(i + 1, args[i]);
			}
			//4��ִ�����
			rs = state.executeQuery();
			//5����ȡԪ���ݼ��������
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			//6����������
			while(rs.next()) {
				T t = clazz.getConstructor().newInstance();
				for(int i = 0;i < columnCount;i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = rs.getObject(i + 1);
					Field declaredField = clazz.getDeclaredField(columnLabel);
					declaredField.setAccessible(true);
					declaredField.set(t, columnValue);
				}
				arrayList.add(t);
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			JDBCUtil.closeSource(conn, state, rs);
		}
		return arrayList;
	}
	
	@Test
	public void test2() {
		String sql = "select last_name,salary from employees where employee_id > ? and employee_id < ?";
		List<Employee> query = query(Employee.class,sql, 100,105);
		query.forEach(System.out::println);
	}
}
