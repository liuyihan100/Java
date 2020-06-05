<%@page import="com.gui.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Employee employee = (Employee) request.getAttribute("employee");
	%>
	<form action="UpdateServlet">
		工号：<input type="text" name="employeeId" value="<%=employee.getEmployeeId() %>"></br>
		姓：<input type="text" name="firstName" value="<%=employee.getFirstName() %>"></br>
		名：<input type="text" name="lastName" value="<%=employee.getLastName() %>"></br>
		工资：<input type="text" name="salary" value="<%=employee.getSalary() %>"></br>
		<input type="submit" value="提交">
		<a href="QueryAllServlet">返回</a>
	</form>
</body>
</html>