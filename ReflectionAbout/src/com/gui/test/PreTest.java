package com.gui.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class PreTest {
	
	List<String> filter(List<String> list,Predicate<String> pre){
		ArrayList<String> filterList = new ArrayList<String>();
		for(String s : list) {
			if(pre.test(s)) {
				filterList.add(s);
			}
		}
		return filterList;
	}
	
	@Test
	public void test1(){
		List<String> asList = Arrays.asList("北京","天津","南京");
		List<String> filterList = filter(asList,new Predicate<String>() {

			@Override
			public boolean test(String t) {
				
				return t.contains("京");
			}
			
		});
		
		System.out.println(filterList);
	}
	
	@Test
	public void test2() {
		List<String> asList = Arrays.asList("北京","天津","南京");
		List<String> filterList = filter(asList,t -> t.contains("京"));
		System.out.println(filterList);
	}
}
