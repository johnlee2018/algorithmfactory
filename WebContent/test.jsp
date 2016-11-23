<%@page language="Java" pageEncoding="UTF-8"%>

<%
ServletContext servletcontext=getServletContext();
servletcontext.setAttribute("projectname","花钱看算算");
out.print("we jump here !");
%>
