package com.ljc.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		response.setContentType("application/json; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		PrintWriter out=null;
		//PrintReader in=null;
		String path=request.getServletContext().getRealPath("");
		String utfmessage= new String(message.getBytes("iso-8859-1"), "utf-8");
		String[] pathString=path.split("\\\\");
		String filePath=pathString[0]+"\\"+pathString[1];
		filePath=filePath+"\\algorithmfactory\\WebContent\\texts\\improvement.txt";
		try
		{
			FileOutputStream fileOutputStream=new FileOutputStream(filePath,true);
			out=new PrintWriter(fileOutputStream);
			out.println(new java.util.Date()+" :: Need improve : "+utfmessage);
     		out.close();
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/inputImprovement.jsp");
    		requestDispatcher.forward(request, response);
     		

		}
		catch(Exception e)
		{
			out.close();
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
