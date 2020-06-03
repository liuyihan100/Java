package com.gui.first;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Serv1 extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("hello,world");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get");
		String a = super.getInitParameter("hello");
		System.out.println(a);
		String b = this.getServletContext().getInitParameter("ÄãºÃ");
		System.out.println(b);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post");
	}
}
