package com.ljc.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ljc.controller.Log;
/**
 * Servlet implementation class MyServletContextListener
 */
@WebServlet("/MyServletContextListener")
public class MyServletContextListener implements ServletContextListener,ServletContextAttributeListener {

	private ServletContext context=null;
	//public static Log log=new Log();
	Log logger=Log.log;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //由事件得到ServletContext
        //监听者对象向ServletContextEvent对象请求应用ServletContext对象的一个引用
        this.context = sce.getServletContext();
        logger.logout("contextInitailized()-->ServletContext初始化了");
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        logger.logout("contextInitailized()-->ServletContext被销毁了");
        this.context=null;
    }

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		logger.logout("增加了一个servletContext属性：attributeAdded("+scae.getName()+","+scae.getValue()+")");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		logger.logout("删除了一个servletContext属性：attributeAdded("+scae.getName()+","+scae.getValue()+")");		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		logger.logout("改变了一个servletContext属性：attributeAdded("+scae.getName()+","+scae.getValue()+")");
	}

}