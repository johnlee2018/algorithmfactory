<%@page language="Java" pageEncoding="UTF-8" import="com.ljc.pojo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table width="338" border="0" cellpadding="0" cellspacing="0">
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