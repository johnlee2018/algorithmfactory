package com.ljc.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
@WebServlet("/LogFilter1")
public class LogFilter1 implements Filter  {
	public void  init(FilterConfig config) throws ServletException {
		// 获取初始化参数
		String site = config.getInitParameter("Site"); 
		// 输出初始化参数
		System.out.println("网站名称: " + site);

	}
	public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
		// 输出站点名称
		 ServletContext sc = request.getServletContext();
//	   	 Integer count =0;
////	     synchronized(sc)  
////	     {  
//	
//	    	 try
//	    	 { 	 
		 Integer	 count=(Integer) sc.getAttribute("counter");
//	    		 
//	    	 }
//	    	 catch(Exception e)
//	    	 {
//	    		 count=0;
//	    		 e.printStackTrace();
//	    	 }
//	    	 finally
//	    	 {
//	    		 count+=1;
//	    		 sc.setAttribute("counter",count);
//	    	 }
////	     }
//		
//		
//		
//		System.out.println("站点网址：http://www.weijifen.com12");
		System.out.println(count);
//		System.out.println("站点网址：http://www.weijifen.com22");
//		// 把请求传回过滤链
		chain.doFilter(request,response);
	}
	public void destroy(){
		/* 在 Filter 实例被 Web 容器从服务移除之前调用 */
	}
}