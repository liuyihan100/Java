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
		request.setAttribute("name", "liuyihan");
		//request.getRequestDispatcher("jump.jsp").forward(request, response);
		response.sendRedirect("jump.jsp");
		out.print(request.getAttribute("name"));
	%>
</body>
</html>