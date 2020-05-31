package com.gui.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class Reflection {
	
	@Test
	public void play() {
//		Class<Person> clazz = Person.class;
//		Person p1 = clazz.getConstructor().newInstance();
//		Person p2 = clazz.getDeclaredConstructor(String.class,int.class).newInstance("liuyihan",15);
//		Person p3 = clazz.getConstructor(String.class,int.class).newInstance("liuyihan",15);
//		Person p4 = clazz.getConstructor().newInstance();
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
//		System.out.println(p4);
//		System.out.println("-------------------------");
//		Field[] fields = clazz.getDeclaredFields();
//		for (Field field : fields) {
//			int modifiers = field.getModifiers();
//			Class type = field.getType();
//			String name = field.getName();
//			System.out.println(modifiers + "\t" + type + "\t" + name);
//		}
//		
//		System.out.println("-------------------------------------");
//		
//		Method[] methods = clazz.getMethods();
//		for (Method method : methods) {
//			System.out.print(Modifier.toString(method.getModifiers()) + "\t");
//			System.out.print(method.getReturnType() + "\t");
//			System.out.print(method.getName());
//			System.out.print("(");
//			Parameter[] parameters = method.getParameters();
//			if(parameters.length > 0) {
//				for (int i = 0;i < parameters.length;i++) {
//					if(i == parameters.length - 1) {
//						System.out.print(parameters[i]);
//						break;
//					}
//					System.out.print(parameters[i] + ",");
//				}
//			}
//			System.out.println(")");
//		}
//		Constructor[] constructors = clazz.getConstructors();
//		Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
//		
//		Type genericSuperclass = clazz.getGenericSuperclass();
//		ParameterizedType type = (ParameterizedType) genericSuperclass;
//		Type[] actualTypeArguments = type.getActualTypeArguments();
//		System.out.println(actualTypeArguments[0].getTypeName());
		
		Class<Person> clazz = Person.class;
		try {
			Person p1 = clazz.getDeclaredConstructor().newInstance();
			Field name = clazz.getDeclaredField("name");
			name.setAccessible(true);
			name.set(p1, "liuyihan");
			System.out.println(name.get(p1));
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		Object result;
		try {
			Person p2 = clazz.getDeclaredConstructor().newInstance();
			Method play = clazz.getDeclaredMethod("play",int.class);
			play.setAccessible(true);
			result = play.invoke(p2, 0);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Method print = clazz.getMethod("print");
			print.invoke(Person.class);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
		
		try {
			Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(String.class);
			Person p3 = declaredConstructor.newInstance("刘毅晗");
			System.out.println(p3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
