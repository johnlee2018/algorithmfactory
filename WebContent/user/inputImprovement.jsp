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
<script type="text/javascript">
	$().ready(function() {
		$("#improvementform").validate({
			rules : {
				"message" : {
					required : true,
					//minlength : 3,
					//maxlength : 10,
					//checkUserExist : true
				},
			},
			messages : {
				"message" : {
					required : "   can not be empty!",
					//minlength : "用户名长度不能小于3",
					//maxlength : "用户名长度不能大于10"
				},
			}
		});

	});
	
</script>
<body>
    <form action="Algorithm/GoImprovementServlet" method="post" id='improvementform'> 
		numstr:<input type="text" id="message" name="message" size="20"
		value=${message}></input> <a> fill the nums by comma separated </a>
		<br />
		<input name="submit" type="submit" value="improvement" />
	</form> 
</body>
</html>