<%@page import="com.gui.bean.Page"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.gui.bean.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	tr:nth-of-type(even){
		background-color: skyblue;
	}
</style>
</head>
<body>
	<table border="1px">
		<tr>
			<th>id<th>
			<th>firstName<th>
			<th>lastName<th>
			<th>salary<th>
			<th>操作<th>
		</tr>
		<%	
			request.setCharacterEncoding("utf-8");
			Page page1 = (Page)request.getAttribute("page1");
			List<Employee> employees = page1.getCurrentObj();
			for(Employee employee : employees){
		%>
		<tr>
			<td><a href="QueryServlet?id=<%=employee.getEmployeeId() %> "><%=employee.getEmployeeId() %></a><td>
			<td><%=employee.getFirstName() %><td>
			<td><%=employee.getLastName() %><td>
			<td><%=employee.getSalary() %><td>
			<td><a href="DeleteServlet?id=<%=employee.getEmployeeId() %> ">删除</a><td>
		</tr>
		<%
			}
		%>
		
	</table>
	
		<%=page1.getCurrentPage() %>/<%=page1.getPageNum() %>
		<%=page1.getTotalNum() %>
		
		<a href="QueryByPageServlet?currentPage=1">首页</a>
		<a href="QueryByPageServlet?currentPage=<%=page1.getCurrentPage()-1 %>">上一页</a>
		<a href="QueryByPageServlet?currentPage=<%=page1.getCurrentPage()+1 %>">下一页</a>
		<a href="QueryByPageServlet?currentPage=<%=page1.getPageNum()-1 %>">尾页</a>
</body>
</html>