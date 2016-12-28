<%@page language="Java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
   <title>iuput nums page</title>  
</head> 
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery.metadata.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#bubbleSortform").validate({
			rules : {
				"numstr" : {
					required : true,
					//minlength : 3,
					//maxlength : 10,
					//checkUserExist : true
				},
			},
			messages : {
				"numstr" : {
					required : "   can not be empty!",
					//minlength : "用户名长度不能小于3",
					//maxlength : "用户名长度不能大于10"
				},
			}
		});
		$("#quickSortform").validate({
			rules : {
				"numstr" : {
					required : true,
				},
			},
			messages : {
				"numstr" : {
					required : "   can not be empty!",
				},
			}
		});

	});
	
</script>
<body>
    <form action="BubbleSortServlet" method="post" id='bubbleSortform'> 
		numstr:<input type="text" id="numstr" name="numstr" size="20"
		value=${numstr}></input> <a> fill the nums by comma separated </a>
		<br />
		<input name="submit" type="submit" value="Bubble" />
	</form> 
    <form action="QuickSortServlet" method="post" id='quickSortform'> 
		numstr:<input type="text" id="numstr" name="numstr" size="20"
		value=${numstr}></input> <a> fill the nums by comma separated </a>
		<br />
		<input name="submit" type="submit" value="Quick" />
	</form> 

</body>
</html>