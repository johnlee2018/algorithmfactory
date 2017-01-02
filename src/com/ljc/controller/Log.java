package com.ljc.controller;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.annotation.WebServlet;
//@WebServlet("/Log")
public class Log{
	    public static Log log=new Log();
		public void logout(String message){
		PrintWriter out=null;
		try
		{
			//String s=System.getProperty("user.dir");
			//application.getRealPath();
			//System.out.println(s);
			
			FileOutputStream fileOutputStream=new FileOutputStream("log.txt",true);
			//Paths.get(fileOutputStream);
			out=new PrintWriter(fileOutputStream);
			//String absolutePath = fileOutputStream.();
			out.println(new java.util.Date()+" :: Form ContextListener : "+message);
			out.close();
		}
		catch(Exception e)
		{
			out.close();
			e.printStackTrace();
		}
	}

}