package com.ljc.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImprovmentServelt
 */
@WebServlet("/ImprovementServlet")
public class ImprovementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImprovementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message=request.getParameter("message");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		FileOutputStream fos=null;
		OutputStreamWriter osw=null;
		
		String path=request.getServletContext().getRealPath("");
		//System.out.println("&&&&&&&&");
		//System.out.println(path);
		//System.out.println(path.split("\\\\")[0]);
		//System.out.println(path.split("\\\\")[1]);
		String[] pathString=path.split("\\\\");
//		try{
//			String rootPath1=pathString[-1];
//			System.out.print(rootPath1);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		
		String rootPath=pathString[0]+"\\"+pathString[1];//\\texts+"\\"+pathString[-1]
		rootPath=rootPath+"\\algorithmfactory\\WebContent\\texts\\";
		//System.out.println("&&&&&&&&");
		//System.out.println(path);
		
		//System.out.println(out);
		try
		{
			fos = new FileOutputStream(rootPath+"improvement.txt",true);   
		    osw = new OutputStreamWriter(fos, "UTF-8");   
		    osw.write(new java.util.Date()+":: Need improve : "+message);   
		    osw.flush();  
			
			//out=new PrintWriter(new FileOutputStream(rootPath+"improvement.txt",true));
			//out.println(new java.util.Date()+":: Need improve : "+message);
			//out.close();
		}
		catch(Exception e)
		{
			osw.close();
			fos.close();
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
