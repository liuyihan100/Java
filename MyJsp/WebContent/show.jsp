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
		int age = Integer.parseInt(request.getParameter("uage"));
		String[] hobbies = request.getParameterValues("uhobby");
	%>
	
	注册成功，信息如下<br/>
	姓名：<%=name %><br/>
	密码：<%=pwd %><br/>
	年龄：<%=age %><br/>
	爱好：<br/>
	<%
		
		if(hobbies != null){
			for(String hobby : hobbies){
				out.print(hobby + " ");
			}
		}
	%>
</body>
</html>