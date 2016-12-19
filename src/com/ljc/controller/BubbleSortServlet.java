package com.ljc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cache.ehcache.EhCacheCache;

/**
 * Servlet implementation class BubbleSortServlet
 */
@WebServlet("/BubbleSortServlet")
public class BubbleSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BubbleSortServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String nums=request.getParameter("nums");
		String numstr= bubbleSort(nums);
		request.setAttribute("numstr",numstr);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/algorithm/bubbleSort.jsp");
		requestDispatcher.forward(request, response);
	}

	
	private String bubbleSort(String nums) {
		// TODO Auto-generated method stub
		String[] arr=nums.split(",");
		int len =arr.length;
		int numarr[] = new int[len];
		int ex;
		nums="";
		for (int i = 0; i < len; i++) 
		{
			numarr[i]=Integer.parseInt(arr[1]);
		}
		
		for (int i=1; i<len;i++)
		{
			for (int j=0;j<i;j++)
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
			nums+=i;
		}
		return nums;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
