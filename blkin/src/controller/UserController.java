package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;


@WebServlet({"/index.html","/user/*","/main/*"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	
    public UserController() {
        super();
       userService = UserServiceImpl.sharedInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(contextPath.length());
		
		String method = request.getMethod();
		//요청을 맞게 작성했는지 확인
		//완성되면 주석처리
		System.out.println("요청주소 : "+command);
		//시작할 때 Controller를 거치게 하는 이유는 사람들이 들어오고 어디서 그만 뒀는지 파악을 할 수 있기 때문에 Controller를 사용해야 한다. 
		if(command.equals("/index.html")) {
			response.sendRedirect("./");
		}else if(command.equals("/main/main")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("../member/main.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/user/register")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("../member/register.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/user/emailcheck")) {
			//콘솔에 이 메세지가 보이면 요청에는 아무 문제가 없다.
			//만약 메세지가 보이지 않는다면 url을 확인해야 한다.
			//System.out.println("요청 도달");
			userService.emailCheck(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../member/emailcheck.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/user/namecheck")) {
			userService.nameCheck(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../member/namecheck.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
