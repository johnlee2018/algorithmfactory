<%@page language="Java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 

<title>display排序结果</title>
</head>
<body>
	<h2>使用算法</h2>
	algorithm:${algorithm}
	<h2>已排序</h2>
	numstr:${numstr}
	<h2><a href="SortServlet">排序</a></h2>
</body>
</html>