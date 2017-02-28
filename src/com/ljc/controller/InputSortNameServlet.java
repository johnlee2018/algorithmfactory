package com.ljc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljc.dao.AlgorithmMDao;
import com.ljc.dao.UserMDao;
import com.ljc.dao.impl.AlgorithmMDaoImpl;
import com.ljc.dao.impl.UserMDaoImpl;
import com.ljc.pojo.Algorithm;
import com.ljc.util.MD5Util;

/**
 * Servlet implementation class InputSortName
 */
@WebServlet("/Algorithm/InputSortNameServlet")
public class InputSortNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");////解决前端传过来的参数乱码 方案二：新增一个过滤器，每次自动修改编码
		String function = request.getParameter("function");
		//String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");//解决前端传过来的参数乱码 方案一：每个参数编码来改变参数的编码
		//String function = new String(request.getParameter("function").getBytes("iso-8859-1"), "utf-8");
		//String str = new String(request.getParameter("参数名").getBytes("iso-8859-1"), "utf-8");  
		//System.out.println("传过来的参数");
		//System.out.println(name);
		//System.out.println(function);
		AlgorithmMDao algorithmMDao=new AlgorithmMDaoImpl();
		int flag=algorithmMDao.insertAlgorithmNameFunction(name, function);
		if (flag==1)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/algorithm/insertAlgorithmSuccess.jsp");
			requestDispatcher.forward(request, response);
		}
		else if (flag==0)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
			requestDispatcher.forward(request, response);
		}

		}
		//requestDispatcher.forward(request, response);
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/***
	 * 检查是否有参数为空
	 * 
	 * @author li jianchun
	 * @param params
	 * @return
	 */
	private boolean checkParams(String[] params) {
		for (String param : params) {
			if (param == "" || param == null || param.isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
