package com.gui.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Reflection {
	
	@Test
	public void play() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<Person> clazz = Person.class;
		Person p1 = clazz.getConstructor().newInstance();
		Person p2 = clazz.getDeclaredConstructor(String.class,int.class).newInstance("liuyihan",15);
		Person p3 = clazz.getConstructor(String.class,int.class).newInstance("liuyihan",15);
		Person p4 = clazz.getConstructor().newInstance();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
	}
}
