package com.gui.service;

import java.util.List;

import com.gui.bean.Employee;
import com.gui.dao.EmployeeDao;

public class EmployeeService{
	
	public static Employee queryById(int id) {
		return EmployeeDao.query(id);
	}
	
	public static List<Employee> queryAll(){
		return EmployeeDao.queryAll();
	}
	
	public static boolean isExist(int id) {
		Employee employee = EmployeeDao.query(id);
		if(employee != null) {
			return true;
		}
		return false;
	}
	
	public static boolean add(Employee employee) {
		if(!isExist(employee.getEmployeeId())) {
			int result = EmployeeDao.add(employee);
			if(result > 0) {
				return true;
			}
		}
		return false;
	}
	
	public static int delete(int id) {
		int result = -1;
		if(isExist(id)) {
			result = EmployeeDao.delete(id);
		}
		return result;
	}
	
	public static boolean update(int id,Employee employee) {
		if(isExist(id)) {
			EmployeeDao.update(id, employee);
			return true;
		}
		return false;
	}
	
	public static List<Employee> queryByPage(int currentPage,int pageSize){
		return EmployeeDao.queryByPage(currentPage, pageSize);
	}
	
	public static int getTotalNum() {
		return EmployeeDao.getTotalNum();
	}
}
