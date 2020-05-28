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
		String context = application.getContextPath();
		String real = application.getRealPath(context);
	%>
	<%=
		"虚拟路径:" + context + "<br/>" + "绝对路径" + real
	%>
</body>
</html>