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
		if(name.equals("zs") && pwd.equals("abc")){
			//response.sendRedirect("success.jsp");
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
		else{
			out.print("密码错误");
		}
	%>
</body>
</html>