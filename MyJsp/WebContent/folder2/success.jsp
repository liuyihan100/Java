<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	登陆成功！<br/>
	您好：
	<%
		String name = (String)session.getAttribute("name");
		if(name != null){
			out.print(name);
		}else{
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>