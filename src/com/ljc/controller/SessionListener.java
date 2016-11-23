package com.ljc.controller;

import java.util.Hashtable;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.Session;
import com.ljc.controller.Log;
@WebServlet("/SessionListener")
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener {
	static Hashtable ht=new Hashtable();
	Log logger=Log.log;
	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		// TODO Auto-generated method stub
		//Session session1=(Session) hse.getSession();
		HttpSession session=(HttpSession) hse.getSession();
		String sessionId=session.getId();
		ht.put(sessionId, session);
		logger.logout("one session created"+sessionId+"初始化了");
		

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		// TODO Auto-generated method stub
		HttpSession session=(HttpSession) hse.getSession();
		String sessionId=session.getId();
		ht.remove(sessionId);
		((Session) ht).getSession().invalidate();
		//ht.put(sessionId, session);
		logger.logout("one session Destroyed"+sessionId+"销毁化了");
		
	}
	

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
