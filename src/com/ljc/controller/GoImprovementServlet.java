package com.ljc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoImprovmentServlet
 */
@WebServlet("/Algorithm/GoImprovementServlet")
public class GoImprovementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoImprovementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletContext().getRealPath("");
		
		String[] pathString=path.split("\\\\");
		String filePath=pathString[0]+"\\"+pathString[1];
		filePath=filePath+"\\algorithmfactory\\WebContent\\texts\\improvement.txt";

		
		try 
		{
            //String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists())
            { //�ж��ļ��Ƿ����FileOutputStream
            	//InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//���ǵ������ʽ
            	System.out.println("ָ�����ļ�����");
		    }
            else
            {
		        System.out.println("�Ҳ���ָ�����ļ�");
		        try
		        {
		        	file.createNewFile();
		        	System.out.println("�����ļ��ɹ���"); 
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        	System.out.println("�����ļ�ʧ�ܣ�");
		        }
	            
            }  
        	InputStreamReader read = new InputStreamReader(new FileInputStream(file));
        	BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            String stringTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null)
            {
            	//System.out.println("^^^^^^^^^");
                //System.out.println(lineTxt);
                stringTxt+=lineTxt+"<br>";
            }
            read.close();
            request.setAttribute("text", stringTxt);
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/displayImprovement.jsp");
    		requestDispatcher.forward(request, response);
            
		} 
		catch (Exception e) 
		{
        System.out.println("��ȡ�ļ����ݳ���");
        e.printStackTrace();
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
