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
		String name = request.getParameter("name");////���ǰ�˴������Ĳ������� ������������һ����������ÿ���Զ��޸ı���
		String function = request.getParameter("function");
		//String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");//���ǰ�˴������Ĳ������� ����һ��ÿ�������������ı�����ı���
		//String function = new String(request.getParameter("function").getBytes("iso-8859-1"), "utf-8");
		//String str = new String(request.getParameter("������").getBytes("iso-8859-1"), "utf-8");  
		//System.out.println("�������Ĳ���");
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
	 * ����Ƿ��в���Ϊ��
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
