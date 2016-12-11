package com.ljc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljc.service.UserService;
import com.ljc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		boolean result = userService.isUserNameExist(userName);
		response.setContentType("application/json; charset=UTF-8");
		// 以下两句为取消在本地的缓存
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		//sb.append("<result>");
		sb.append(result);
		//sb.append("</result>");
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
