package com.naver.binkug.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.binkug.service.BoardService;
import com.naver.binkug.service.BoardServiceImpl;


@WebServlet("/dashboard/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardService boardService;
	
	public BoardController() {
		super();
		boardService = BoardServiceImpl.sharedInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(contextPath.length());
		
		String method = request.getMethod();
		System.out.println("요청주소 : "+method);
		
		if(command.equals("/index.html")) {
			
			response.sendRedirect("./");
			
		}else if(command.equals("/dashboard/main")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("../board/dashboard.jsp");
			dispatcher.forward(request, response);
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
