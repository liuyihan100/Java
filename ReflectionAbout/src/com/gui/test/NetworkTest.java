package com.gui.test;

import java.lang.reflect.Proxy;

public class NetworkTest {
	
	public static void main(String[] args) {
		Serve serve = new Serve();
		ServeProxy proxy = new ServeProxy(serve);
		proxy.browse();
	}
}

interface Network{
	public void browse() ;
}

class Serve implements Network{

	@Override
	public void browse() {
		System.out.println("hello,world");
	}
}

class ServeProxy implements Network{
	
	private Network work;
	
	public ServeProxy(Network work) {
		this.work = work;
	}
	
	private void check() {
		System.out.println("ÒÑ¼ì²é");
	}
	
	@Override
	public void browse() {
		check();
		work.browse();
	}
	
}