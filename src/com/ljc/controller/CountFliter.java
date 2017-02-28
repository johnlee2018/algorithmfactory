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
		// ��ȡ��ʼ������
		String site = config.getInitParameter("Site"); 
		// �����ʼ������
		//System.out.println("��վ����: " + site);
		//ʹ�ü�����
		ServletContext sc=config.getServletContext();
		sc.setAttribute("counter",0);

	}
	public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
		// ���վ������
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
		
		
		
		//System.out.println("վ����ַ��http://www.weijifen.com1");
		//System.out.println(count);
		//System.out.println("վ����ַ��http://www.weijifen.com2");
		// �����󴫻ع�����
		chain.doFilter(request,response);
	}
	public void destroy(){
		/* �� Filter ʵ���� Web �����ӷ����Ƴ�֮ǰ���� */
	}
}