<%@page language="Java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
   <title>login page</title>  
</head> 


<body>
<table width="338" border="2" cellpadding="0" cellspacing="0">
	<tr>
		<td>算法名</td>
		<td>算法功能</td>
		
	</tr>
	<c:forEach var="algorithm" items="${algorithms}">
		<tr>
			<td><c:out value="${algorithm.name}" /></td>
			<td><c:out value="${algorithm.function}" /></td>
		</tr>
	</c:forEach>
	
</table>
<br/>
	<form action="InputSortNameServlet" method="post" id='sortform'> 
		
			名 称:<input type="text" id="name" name="name" size="10"
			value=${name}>
			功 能:<input type="text" id="function" name="function" size="20"
			value=${function}>
			<br />
			<input name="submit" type="submit" value="新增排序算法名称" />
		
</form> 
</body>
</html>