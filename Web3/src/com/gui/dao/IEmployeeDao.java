package com.gui.dao;

import java.util.List;
import com.gui.bean.Employee;

public interface IEmployeeDao {
		
	public Employee query();
		
	public List queryAll();
		
	public int add();
		
	public int delete();
		
	public int update();
		
}
