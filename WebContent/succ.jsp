<%@page language="Java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login page</title>
</head>
<body>
	<h2>恭喜您注册成功</h2>
	userName:${userName}
	<p>
		password:${password}
	</p>
	
	<a href="LoginServlet">返回首页</a>
	<a href="LogOutServlet">重新登录</a>
	
	
</body>
</html>