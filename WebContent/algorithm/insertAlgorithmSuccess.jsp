<%@page language="Java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 

<title>login page</title>
</head>
<body>
	<h2> 恭喜 添加算法成功 下次努力完成奥  ^*^ </h2>
	
	
    <form action="GetAlgorithmServlet" method="post"> 
		<input name="submit" type="submit" value="查看所有算法" />
	</form>
	<form action="/algorithmfactory/LoginServlet" method="post"> 
		<input name="submit" type="submit" value="返回首页" />
	</form> 
	 
</body>
</html>