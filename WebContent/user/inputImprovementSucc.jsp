<%@page language="Java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
   <title>iuput text page</title>  
</head> 
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery.metadata.js"></script>

<body>
	<h1> 恭喜 添加优化需求成功 下次努力完成奥  ^*^ </h1>
	
	
    <form action="GoImprovementServlet" method="post"> 
		<input name="submit" type="submit" value="查看所有需求" />
	</form>
	<form action="LoginServlet" method="post"> 
		<input name="submit" type="submit" value="返回首页" />
	</form> 
	 
</body>
</html>