<%@page import="com.gui.listener.Bean"%>
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
		Bean bean = new Bean();
		session.setAttribute("bean", bean);
	%>
</body>
</html>