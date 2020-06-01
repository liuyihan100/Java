<%@page import="WebDao.WebCheck"%>
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
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		int result = WebCheck.check(name, pwd);
		if(result > 0){
			out.print("登陆成功");
		}else if(result == 0){
			out.print("密码错误");
		}else{
			out.print("系统异常");
		}
	%>
</body>
</html>