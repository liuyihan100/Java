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
	<form>
		工号：<input type="text" name="employeeId" value="<%=employee.getEmployeeId() %>">
	</form>
</body>
</html>