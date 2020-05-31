package com.gui.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void display() {
		Cat cat = new Cat("grass");
		Animal proxyInstance = (Animal) MyProxy.getProxyInstance(cat);
		proxyInstance.eat();
	}
}

interface Animal{

	public void eat();
	
	public void play();
	
}

class Cat implements Animal{
	
	private String food;
	
	public Cat(String food) {
		this.food = food;
	}
	
	public void eat() {
		System.out.println("I like to eat " + food);
	}
	
	@Override
	public void play() {
		System.out.println("I like playing");
	}
}

class MyProxy{
	
	public static Object getProxyInstance(Object object) {
		
		MyInvocationHandler handler = new MyInvocationHandler(object);
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), handler);
	}
	
}

class MyInvocationHandler implements InvocationHandler{
	Object obj;
	
	public MyInvocationHandler(Object obj) {
		this.obj = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return method.invoke(obj, args);
	}
	
}