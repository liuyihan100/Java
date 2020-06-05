package com.gui.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gui.bean.Employee;
import com.gui.bean.Page;
import com.gui.service.EmployeeService;

@WebServlet("/QueryByPageServlet")
public class QueryByPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Page page1 = (Page)request.getAttribute("page1");
		if(page1 == null) {
			page1 = new Page();
			page1.setTotalNum(EmployeeService.getTotalNum());
			page1.setCurrentPage(1);
			page1.setPageSize(10);
		}
		if(request.getParameter("currentPage") != null){
			int count = Integer.parseInt(request.getParameter("currentPage"));
			if(count < 1) count = 1;
			if(count > page1.getPageNum()) count = page1.getPageNum();
			page1.setCurrentPage(count);
		}
		page1.setCurrentObj(EmployeeService.queryByPage(page1.getCurrentPage(), page1.getPageSize()));
		request.setAttribute("page1", page1);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
