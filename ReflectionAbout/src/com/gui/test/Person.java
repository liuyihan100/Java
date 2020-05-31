package com.gui.test;

import java.io.Serializable;

public class Person {
	private String name;
	public int age;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public Person() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String play(int num) {
		if(num == 0)
			return "zero";
		else
			return "hello";
	}
	
	public static void print() {
		System.out.println("hello,world");
	}

	public Person(String name) {
		super();
		this.name = name;
	}
}
