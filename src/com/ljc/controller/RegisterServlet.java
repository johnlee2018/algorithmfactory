package com.ljc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljc.dao.UserMDao;
import com.ljc.dao.impl.UserMDaoImpl;
import com.ljc.pojo.User;
import com.ljc.util.MD5Util;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName= request.getParameter("userName");
		
		String oripassword = request.getParameter("password");
		String md5password =userName+oripassword;
		String password =MD5Util.MD5Encode(md5password);
		UserMDao userMDao=new UserMDaoImpl();
		int flag=userMDao.inserByUserNamePass(userName, password);
		request.setAttribute("userName",userName);
		request.setAttribute("password", oripassword);
		
		if (flag==1)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/succ.jsp");
			HttpSession httpSession = request.getSession();
			// 将用户名放入session
			httpSession.setAttribute("currentUser", userName);
			requestDispatcher.forward(request, response);
		}
		else if (flag==0)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.jsp");
			requestDispatcher.forward(request, response);
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
