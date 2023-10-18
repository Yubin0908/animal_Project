package com.lec.animal.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.service.*;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
	    String conPath = request.getContextPath();
	    String command = uri.substring(conPath.length());
	    String viewPage = null;
	    Service service = null;
		
	    if(command.equals("/main.do")) { // main page
	    	viewPage = "main/main.jsp";
	    } else if(command.equals("/loginView.do")) { // login View
	    	viewPage = "user/login.jsp";
	    } else if(command.equals("/login.do")) { // login Process
	    	service = new LoginService();
	    	service.execute(request, response);
	    	viewPage = "main/main.jsp";
	    } else if(command.equals("/logout.do")) { // logout Process
	    	service = new LogoutService();
	    	service.execute(request, response);
	    	viewPage = "main/main.jsp";
	    } else if(command.equals("/joinView.do")) { // Join View
	    	viewPage = "user/joinagree.jsp";
	    }
	    
	    
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	    dispatcher.forward(request, response);
	}

}
