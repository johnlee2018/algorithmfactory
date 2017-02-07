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
 * Servlet implementation class ShellSortServlet
 */
@WebServlet("/Algorithm/ShellSortServlet")
public class ShellSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String algorithm="ShellSort";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShellSortServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SortService sortService=new SortServiceImpl();
		String nums=request.getParameter("numstr");
		String numstr=sortService.shellSort(nums);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		request.setAttribute("numstr",numstr);
		request.setAttribute("algorithm",algorithm);
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
