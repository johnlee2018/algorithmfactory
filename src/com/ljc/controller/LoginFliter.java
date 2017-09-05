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



import com.mysql.jdbc.StringUtils;
import com.sun.org.apache.xpath.internal.operations.And;

@WebServlet("/LoginFliter")
public class LoginFliter implements Filter  {
	//private String excludedPages;       
	//private String[] excludedPageArray; 
	public void  init(FilterConfig fConfig) throws ServletException {
		//excludedPages = fConfig.getInitParameter("excludedPages");
		//System.out.println("+++++");
		//System.out.println(excludedPages);
		//if (excludedPages != null) 
		//{     
		//    excludedPageArray = excludedPages.split(",");     
		//}     
		}     
	
	public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
		// 输出站点名称
		//String username=null;
		((HttpServletResponse) response).setHeader("Cache-Control", "no-cache");
		((HttpServletResponse) response).setHeader("Pragma", "no-cache");

		HttpServletRequest httprequest=(HttpServletRequest) request;
		HttpServletResponse httpresponse=(HttpServletResponse) response;
		HttpSession session=httprequest.getSession();
		//System.out.println("***&&&&&&&&&");
		String request_uri = httprequest.getRequestURI(); 
		String ctx_path = httprequest.getContextPath();
		
		//System.out.println(excludedPageArray[0]);
		//System.out.println(request_uri);
		//System.out.println(ctx_path);
		//System.out.println(httprequest.getServletPath());
		//System.out.println("888888888");
		//System.out.println(request_uri.substring(ctx_path.length()));
		//System.out.println(session.getAttribute("currentUser"));
		
		//boolean isExcludedPage = false;
//		if (excludedPageArray != null)
//		{
//			for (String page : excludedPageArray)
//			{
//				System.out.println("--page---");
//				System.out.println(page);
//				System.out.println("-----");
//				System.out.println(httprequest.getServletPath());
//
//				if (httprequest.getServletPath().equals(page))
//				{
//
//					isExcludedPage = true;     
//					break;     
//
//				}
//			}
//	
//		}

		//if (request_uri.substring(ctx_path.length()).equals( "login.jsp ")) 
	//if (isExcludedPage) 
	//{//在过滤url之外
		
		//chain.doFilter(request, response);     
	//} 
	//else{
		System.out.println("#######"+httprequest.getContextPath()+"/login.jsp");
		if ((session.getAttribute("currentUser")!=null)  )
		{

			chain.doFilter(request,response);
		}
		else 
		{
			System.out.println("^^^^"+httprequest.getContextPath()+"/login.jsp");
			httpresponse.sendRedirect(httprequest.getContextPath());
			//chain.doFilter(request,response);
		}
		}
	//}
	public void destroy(){
		/* 在 Filter 实例被 Web 容器从服务移除之前调用 */
	}
}