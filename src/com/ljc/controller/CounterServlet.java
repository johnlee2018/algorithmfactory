package com.ljc.controller;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletContext;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
    public class CounterServlet extends HttpServlet {  
     public void doGet(HttpServletRequest req, HttpServletResponse resp)  
             throws ServletException, IOException  
     {  
        ServletContext context = req.getSession().getServletContext();  
        Integer count = null;  
        synchronized(context)  
         {  
            count = (Integer) context.getAttribute("counter");  
            if (null == count)  
            {  
                count = new Integer(1);  
            }  
            else  
            {  
                count = new Integer(count.intValue() + 1);  
            }  
           context.setAttribute("counter", count);  
        }  
          
         resp.setContentType("text/html;charset=gb2312");  
         PrintWriter out = resp.getWriter();  
  
         out.println("<html><head>");  
         out.println("<title>页面访问统计</title>");  
         out.println("</head><body>");  
         out.println("该页面已被访问了" + "<b>" + count + "</b>" + "次");  
         out.println("</body></html>");  
         out.close();  
    }  
     public void count()
     {
    	 //ServletContext context = req.getSession().getServletContext();
    	 ServletContext sc = getServletContext();
    	 Integer count =(Integer)  sc.getAttribute("counter");
         synchronized(sc)  
         {  

	    	 try
	    	 {
	    		 count+=1;
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 count=0;
	    		 e.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 sc.setAttribute("counter",count);
	    	 }
	     }
     }
} 
