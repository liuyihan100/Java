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
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		
		if(name.equals("zs") && pwd.equals("abc")){
			session.setAttribute("name", name);
			session.setAttribute("pwd", pwd);
			session.setMaxInactiveInterval(5);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>