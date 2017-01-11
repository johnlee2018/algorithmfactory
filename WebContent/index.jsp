
<%@page language="Java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2><%=session.getAttribute("currentUser") %> 您，已登陆</h2>
	
	<br />
	<br />
	欢迎 欢迎 热烈欢迎..a
	<br />
	<a href="Algorithm/HiServlet">say hi</a>
	<br />
	<a href="Algorithm/SortServlet">排序</a>
	<br />
	<a href="Algorithm/GoImprovementServlet">改善需求意见</a>
	<br />
	<a href="LogOutServlet">注销账户</a>
	
</body>
</html>