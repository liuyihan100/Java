package com.gui.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gui.bean.Employee;
import com.gui.service.EmployeeService;

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		Employee employee = EmployeeService.queryById(id);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
