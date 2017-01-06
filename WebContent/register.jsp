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

<script type="text/javascript">
	$().ready(function() {
		
		jQuery.validator.addMethod("checkUserExist", function(value, element) { //用jquery ajax的方法验证用户名是不是已存在  
			var flag = 0;
			var successFlag=0;
			$.ajax({
				type : "POST",
				url : 'CheckUserServlet',
				async : false, //同步方法，如果用异步的话，flag永远为1  
				dataType : "json",
				data : {
					'userName' : value
				},
				success : function(messages) {
					successFlag=1;
					if (messages) {
						flag = 1;
					} else {
						flag = 0;
					}
				}
			});
			
			if(successFlag==0){
				//访问失败，不返回错误信息
				return false;
			}else{
				if (flag == 0) {
					//用户不存在
					return true;
				} else {
					//用户存在
					return false;
				}
			}
		}, "用户名已存在");

		$("#registerform").validate({
			rules : {
				"userName" : {
					required : true,
					minlength : 3,
					maxlength : 10,
					checkUserExist : true
				},
				"password" : {
					required : true,
					minlength : 3,
					maxlength : 10
				}
			},
			messages : {
				"userName" : {
					required : "用户名不能为空",
					minlength : "用户名长度不能小于3",
					maxlength : "用户名长度不能大于10"
				},
				"password" : {
					required : "密码不能为空",
					minlength : "密码长度不能小于3",
					maxlength : "密码长度不能大于10"
				}
			}
		});
	});
</script>

<body>
    <form action="RegisterServlet" method="post" id="registerform"> 
		
		<i class="W100SpanI">*</i>userName:<input type="text" id="userName" name="userName" size="20"
		 value=${userName}></input>
	<p>
		<i class="W100SpanI">*</i>password:<input type="password" id="password" name="password" size="20"
			 value=${password}></input>
	<p>
		<input name="submit" type="submit" value="注册" />
		
	</form> 
	<form action="LoginServlet" method="post" > 
	<p>
		<input name="submit" type="submit" value="回首页" />
	</form> 

</body>
</html>