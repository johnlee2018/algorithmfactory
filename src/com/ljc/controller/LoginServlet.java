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
		// ��֤���ݹ����Ĳ����Ƿ���ȷ�����򷵻ص���½ҳ�档
		System.out.println("����doGet��");
		if (this.checkParams(new String[] { userName, password })) {
			// ��½
			int result = userService.login(userName, password);
			// �ɹ���½
			if (result == 0) {
				// ָ��Ҫ���ص�ҳ��Ϊsucc.jsp
				requestDispatcher = request.getRequestDispatcher("/user/succ.jsp");
				// ���������ظ�ҳ��
				request.setAttribute("userName", userName);
				request.setAttribute("password", password);
				HttpSession httpSession = request.getSession();
				// ���û�������session
				httpSession.setAttribute("currentUser", userName);
			} else {
				// ָ��Ҫ���ص�ҳ��Ϊlogin.jsp
				// ���������ظ�ҳ��
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
