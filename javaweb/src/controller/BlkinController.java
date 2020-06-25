package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BlkinService;
import service.BlkinServiceImpl;


@WebServlet("/blkin/*")
public class BlkinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 인스턴스 참조 변수
	private BlkinService blkinService;
	
    public BlkinController() {
        super();
        // TODO Auto-generated constructor stub
        blkinService = BlkinServiceImpl.sharedInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통된 부분을 제거한 주소를 만듭니다.
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(contextPath.length());
		//요청이 여기까지 도달하는지 확인
		//여기에 도달하지 않으면 Controller 처리 패턴이 잘못되었거나
		//링크 설정을 잘못한 것입니다.
		//command를 아래 제어문에서 처리하는지 확인
		//command 와 아래 처리하지 않는 URL이 일치하지 않으면 처리가 안됨
		//일치하지 않으면 요청 페이지의 URL을 변경하던지
		//처리구문의 URL을 변경하던지 해야 합니다.
		System.out.println("1 : "+command);
		//전송 방식을 저장
		String method = request.getMethod();
		
		//시작 요청이 온 경우 index.jsp 페이지로 포워딩
		if(command.equals("/")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/blkin/list")) {
			blkinService.list(request, response);
			//결과 페이지로 이동
			//현재 요청이 /blkin/list 이므로 
			// ../view/list.jsp이면
			//WebContent/view/list.jsp가 됩니다.
			System.out.println("controller");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../blkinn/list.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/blkin/blkinlist")) {
			//결과 페이지로 이동
			//현재 요청이 /blkin/list 이므로 
			// ../view/list.jsp이면
			//WebContent/view/list.jsp가 됩니다.
			RequestDispatcher dispatcher = request.getRequestDispatcher("../blkinn/list2.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/blkin/insert")&& method.equals("GET")) {
			//입력 페이지로 이동
			RequestDispatcher dispatcher = request.getRequestDispatcher("../blkinn/insert.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/blkin/insert")&& method.equals("POST")) {
			blkinService.insert(request, response);
			//삽입하고 결과 페이지로 이동
			//작업을 수행했으므로 목록 보기로 리다이렉트
			response.sendRedirect("blkinlist");
		}else if(command.indexOf("/blkin/detail")>=0) {
			//여기까지 오는지 확인 - 1번은 출력되고 이것은 출력 안되면 요청 페이지의 요청 URL 과 비교하는 URL 수정
			System.out.println("2.detail :  "+command);
			//상세보기 처리
			blkinService.detail(request, response);
			//결과페이지로 이동
			//결과 페이지에 jsp  파일이 제대로 생성 되어있는지 확인
			RequestDispatcher dispatcher = request.getRequestDispatcher("../../blkinn/detail.jsp");
			dispatcher.forward(request, response);
		}else if(command.indexOf("/blkin/update")>=0 && method.equals("GET")) {
			//여기까지 오는지 확인 - 1번은 출력되고 이것은 출력 안되면 요청 페이지의 요청 URL 과 비교하는 URL 수정
			System.out.println("2.detail :  "+command);
			//상세보기 처리
			blkinService.detail(request, response);
			//결과페이지로 이동
			//결과 페이지에 jsp  파일이 제대로 생성 되어있는지 확인
			RequestDispatcher dispatcher = request.getRequestDispatcher("../../blkinn/update.jsp");
			dispatcher.forward(request, response);
		}else if(command.indexOf("/blkin/update")>=0 && method.equals("POST")) {
			//여기까지 오는지 확인 - 1번은 출력되고 이것은 출력 안되면 요청 페이지의 요청 URL 과 비교하는 URL 수정
			System.out.println("2.update :  "+command);
			//상세보기 처리
			blkinService.update(request, response);

			response.sendRedirect("../blkinlist");
		}else if(command.indexOf("/blkin/delete")>=0) {
			
			//데이터 삭제를 처리
			blkinService.delete(request, response);
			//페이지 이동
			response.sendRedirect("../blkinlist");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
