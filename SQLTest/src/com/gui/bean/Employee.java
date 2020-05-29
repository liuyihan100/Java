package com.gui.bean;

import java.sql.Date;

public class Employee {
	private String last_name;
	private String phone_number;
	private int salary;
	private Date hiredate;
	public Employee() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Employee(String last_name, String phone_number, int salary, Date hiredate) {
		super();
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "Employee [last_name=" + last_name + ", phone_number=" + phone_number + ", salary=" + salary
				+ ", hiredate=" + hiredate + "]";
	}
}
