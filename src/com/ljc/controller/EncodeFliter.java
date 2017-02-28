package com.ljc.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class EncodeServlet
 */
@WebFilter("/EncodeFliter")
public class EncodeFliter implements Filter {
	private String charset = "utf-8"; 
    /**
     * Default constructor. 
     */
    public EncodeFliter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain
		//request =request.setCharacterEncoding(charset);
		//request = new GetHttpServletRequestWrapper(request,charset);
		String path=request.getServletContext().getRealPath("");
		//String[] pathString=path.split("\\\\");
		//String filePath=pathString[0]+"\\"+pathString[1];
		//filePath=filePath+"\\algorithmfactory\\WebContent\\texts\\improvement.txt";
		HttpServletRequest httprequest=(HttpServletRequest) request;
		HttpServletResponse httpresponse=(HttpServletResponse) response;
		HttpSession session=httprequest.getSession();
		//System.out.println("***&&&&&&&&&");
		String request_uri = httprequest.getRequestURI(); 
		//String ctx_path = httprequest.getContextPath();
		//System.out.println(path);
		//System.out.println(request_uri);
		//System.out.println(ctx_path);
		//System.out.println((request_uri=="/algorithmfactory/Algorithm/ImprovementServlet"));
		if (!("/algorithmfactory/Algorithm/ImprovementServlet".equals(request_uri)))
		{
			request.setCharacterEncoding(charset);
		}
		System.out.println(request.getCharacterEncoding());
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
