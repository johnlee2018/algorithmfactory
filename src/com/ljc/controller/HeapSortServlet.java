
package com.ljc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljc.service.SortService;
import com.ljc.service.impl.SortServiceImpl;

/**
 * Servlet implementation class DoBubbleSortServlet
 */
@WebServlet("/Algorithm/HeapSortServlet")
public class HeapSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		SortService sortService=new SortServiceImpl();
		
		String nums=request.getParameter("numstr");
		String numstr=sortService.bubbleSort(nums);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		request.setAttribute("numstr",numstr);
		request.setAttribute("algorithm","HeapSort");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/algorithm/display.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
