<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="JQuery-1.12.4.js" type="text/javascript"></script>
<script type="text/javascript">	
	/* function submit() {
		var oTxt = document.getElementById("hello");
		xmlHttpRequest = new XMLHttpRequest();
		
		xmlHttpRequest.onreadystatechange = call;
		xmlHttpRequest.open("post","LoginServlet",true);
		xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlHttpRequest.send("num="+oTxt.value)
	};
	
	function call() {
	
		if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
			var data = xmlHttpRequest.responseText;
			if(data == "true"){
				alert("此号码已存在！");
			}else{
				alert("注册成功！");
			}
		}
	}; */
	function submit(){
		$.ajax({
			url:"LoginServlet",
			type:"post",
			data:"num="+$("#hello").val(),
			success:function(result,status){
				if(result=="true"){
					alert("此号码已存在");
				}else{
					alert("注册成功");
				}
			},
			error:function(){
				alert("系统异常");
			}
		})
	}
</script>

</head>
<body>
	<input type="text" id="hello" /><br/>
	<input type="button" value="注册" onclick="submit()"/>
</body>
</html>