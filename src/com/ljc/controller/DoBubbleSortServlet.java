package com.ljc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoBubbleSortServlet
 */
@WebServlet("/DoBubbleSortServlet")
public class DoBubbleSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoBubbleSortServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nums=request.getParameter("numstr");
		String numstr= bubbleSort(nums);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("numstr",numstr);
		request.setAttribute("algorithm","BubbleSort");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/algorithm/bubbleSort.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private String bubbleSort(String nums) 
		{
		// TODO Auto-generated method stub
		String[] arr=nums.split(",");
		int len =arr.length;
		int numarr[] = new int[len];
		int ex;
		nums="";
			
		for (int i = 0; i < len; i++) 
		{
			numarr[i]=Integer.parseInt(arr[i]);
		}
		
		for (int i=0; i<len;i++)
		{
			for (int j=i+1;j<len;j++)
			{
				if (numarr[j]>numarr[i])
				{
					ex=numarr[j];
					numarr[j]=numarr[i];
					numarr[i]=ex;
				}
						
			}
		}
		
		for (int i : numarr) 
		{
			nums += String.valueOf(i)+",";

		}
		return nums;
	}

}
