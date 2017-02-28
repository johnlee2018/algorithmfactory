package com.ljc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.ljc.pojo.Algorithm;
import com.ljc.service.AlgorithmService;
import com.ljc.service.impl.AlgorithmServiceImpl;

/**
 * Servlet implementation class GetAlgorithmServlet
 */
@WebServlet(
		description = "/Algorithm/GetAlgorithmServlet", 
		urlPatterns = { 
				"/GetAlgorithmServlet", 
				"/Algorithm/GetAlgorithmServlet"
		})
public class GetAlgorithmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAlgorithmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int page=0;
		  int pageCount=10;
		  String pageString = request.getParameter("page");
		  String pageCountString = request.getParameter("pageCount");
		  if (pageString==null)
		  {
			  page=0;
		  }
		  else
		  {
			  page = Integer.parseInt(pageString);
		  }
		  if (pageCountString==null)
		  {
			  pageCount=20;
		  }
		  else
		  {
			  pageCount = Integer.parseInt(pageCountString);
		  }
		  
		  //page = Integer.parseInt(pageString);
		  //pageCount = Integer.parseInt(pageCountString);
		  AlgorithmService algorithmService=new AlgorithmServiceImpl();
		  List <Algorithm> algorithms=	algorithmService.getAlgorithmByPage(page, pageCount);
		  request.setAttribute("algorithms", algorithms);
		  RequestDispatcher requestDispatcher = request.getRequestDispatcher("/algorithm/algorithmDisplay.jsp");
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
