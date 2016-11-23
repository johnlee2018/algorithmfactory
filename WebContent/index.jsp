<%@page language="Java" pageEncoding="UTF-8"%>
<html>
<body>
	<%
	String strName=null;
	try
	{
		
		strName=request.getParameter("name");
		if((strName==null)||(strName.length()==0))
		{
			throw new Exception("null strName");
		}
		
	}
	catch(Exception e)
	{
		//System.out.println(e.printStackTrace());
		out.print("we do not jump  ! ");
		response.sendRedirect("test.jsp");
	}
	finally
	{}
	
	%>
	欢迎 欢迎 热烈欢迎..a
</body>
</html>