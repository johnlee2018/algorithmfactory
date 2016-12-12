package com.ljc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljc.service.UserService;
import com.ljc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/login.jsp");
		// 验证传递过来的参数是否正确，否则返回到登陆页面。
		System.out.println("进入doGet了");
		if (this.checkParams(new String[] { userName, password })) {
			// 登陆
			int result = userService.login(userName, password);
			// 成功登陆
			if (result == 0) {
				// 指定要返回的页面为succ.jsp
				requestDispatcher = request.getRequestDispatcher("/user/succ.jsp");
				// 将参数返回给页面
				request.setAttribute("userName", userName);
				request.setAttribute("password", password);
				HttpSession httpSession = request.getSession();
				// 将用户名放入session
				httpSession.setAttribute("currentUser", userName);
			} else {
				// 指定要返回的页面为login.jsp
				// 将参数返回给页面
				request.setAttribute("userName", userName);
				request.setAttribute("password", password);
			}
		}
		requestDispatcher.forward(request, response);
	}

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
