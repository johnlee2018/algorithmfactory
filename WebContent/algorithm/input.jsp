<%@page language="Java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
   <title>login page</title>  
</head> 
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery.metadata.js"></script>
<body>
    <form action="DoBubbleSortServlet" method="post" > 
	
		numstr:<input type="text" id="numstr" name="numstr" size="20"
		 value=${numstr}></input>
		<input name="submit" type="submit" value="Bubble" />
		
</form> 
</body>
</html>