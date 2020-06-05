package com.gui.bean;

public class Employee {
	private int employeeId;
	private String firstName;
	private String last_name;
	private int salary;
	
	public Employee(int employeeId, String firstName, String last_name, int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.last_name = last_name;
		this.salary = salary;
	}
	
	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", last_name=" + last_name
				+ ", salary=" + salary + "]";
	}
}
