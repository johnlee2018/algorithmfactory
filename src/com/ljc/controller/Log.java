package com.ljc.controller;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
//@WebServlet("/Log")
public class Log{
	    public static Log log=new Log();
		public void logout(String message){
		PrintWriter out=null;
		try
		{
			out=new PrintWriter(new FileOutputStream("e://log.txt",true));
			out.println(new java.util.Date()+"::Form ContextListener:"+message);
			out.close();
		}
		catch(Exception e)
		{
			out.close();
			e.printStackTrace();
		}
	}

}