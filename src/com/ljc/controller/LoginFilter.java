package com.ljc.controller;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginFilter")
public class LoginFilter implements Filter  {
	public void  init(FilterConfig config) throws ServletException {
		// ��ȡ��ʼ������
		//String site = config.getInitParameter("Site"); 
		// �����ʼ������
		//System.out.println("��վ����: " + site);
		//ʹ�ü�����
		//ServletContext sc=config.getServletContext();
		//sc.setAttribute("counter",0);

	}
	public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
		// ���վ������
		//String username=null;
		HttpServletRequest httprequest=(HttpServletRequest) request;
		HttpServletResponse httpresponse=(HttpServletResponse) response;
		HttpSession session=httprequest.getSession();
		System.out.println("***&&&&&&&&&");
		System.out.println(httprequest.getContextPath());
		System.out.println(session.getAttribute("currentUser"));
		

		if (session.getAttribute("currentUser")!=null)
		{
			chain.doFilter(request,response);
		}
		else
		{
			httpresponse.sendRedirect(httprequest.getContextPath()+"/login.jsp");
		}
	}
	public void destroy(){
		/* �� Filter ʵ���� Web �����ӷ����Ƴ�֮ǰ���� */
	}
}