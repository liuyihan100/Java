<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpLoadServlet" method="post" enctype="multipart/form-data">
		姓名：<input type="text" name="uname"/><br/>
		学号：<input type="text" name="unum"/><br/>
		图片：<input type="file" name="upic"/><br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>