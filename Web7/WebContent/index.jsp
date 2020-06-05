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
</head>
<body>
	<table border="1px">
		<tr>
			<th>id<th>
			<th>firstName<th>
			<th>lastName<th>
			<th>salary<th>
			<th>操作<th>
		<tr>
		<%
			List<Employee> employees = (List<Employee>)request.getAttribute("employees");
			for(Employee employee : employees){
		%>
			<tr>
				<td><a href="QueryServlet?id=<%=employee.getEmployeeId() %> "><%=employee.getEmployeeId() %></a><td>
				<td><%=employee.getFirstName() %><td>
				<td><%=employee.getLast_name() %><td>
				<td><%=employee.getSalary() %><td>
				<td><a href="DeleteServlet?id=<%=employee.getEmployeeId() %> ">删除</a><td>
			<tr>
		<%
			}
		%>
	</table>
</body>
</html>