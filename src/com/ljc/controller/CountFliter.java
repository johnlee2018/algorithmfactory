package com.ljc.controller;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


/**
 * 
 */
@WebServlet("/CountFliter")
public class CountFliter implements Filter  {
	public void  init(FilterConfig config) throws ServletException {
		// 获取初始化参数
		String site = config.getInitParameter("Site"); 
		// 输出初始化参数
		//System.out.println("网站名称: " + site);
		//使用计数器
		ServletContext sc=config.getServletContext();
		sc.setAttribute("counter",0);

	}
	public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
		// 输出站点名称
		 ServletContext sc = request.getServletContext();
	   	 Integer count =0;
	     synchronized(sc)  
	     {  
	
	    	 try
	    	 { 	 
	    		 count=(Integer) sc.getAttribute("counter");
	    		 
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 count=0;
	    		 e.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 count+=1;
	    		 sc.setAttribute("counter",count);
	    	 }
	     }
		
		
		
		//System.out.println("站点网址：http://www.weijifen.com1");
		//System.out.println(count);
		//System.out.println("站点网址：http://www.weijifen.com2");
		// 把请求传回过滤链
		chain.doFilter(request,response);
	}
	public void destroy(){
		/* 在 Filter 实例被 Web 容器从服务移除之前调用 */
	}
}