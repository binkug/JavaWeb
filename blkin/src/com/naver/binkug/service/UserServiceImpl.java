package com.naver.binkug.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.naver.binkug.dao.UserDao;

public class UserServiceImpl implements UserService {
	
	//Service에서 사용할 UserDao 변수
	private UserDao userDao;

	
	private UserServiceImpl() {
		userDao = UserDao.sharedInstance();
	}

	private static UserService userService;

	public static UserService sharedInstance() {
		if (userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}

	@Override
	public void emailCheck(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("서비스까지 요청 도달");
		//1. 파라미터 읽기
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("service : "+e.getMessage());
			e.printStackTrace();
		}
		String userEmail = request.getParameter("useremail");
		//2.별도의 작업을 수행해야 하면 처리
		//암호화 , 파일 업로드 , 파라미터를 다른 자료형으로 변환
		//업무처리에 필요한 알고리즘
		
		//3.dao 작업이 필요하면 호출할 DAO 메소드의 매개변수를 생성
		
		//4.DAO의 메소드를 호출해서 결과를 변수에 저장
		boolean result = userDao.emailCheck(userEmail);
		//5.단순 웹페이지를 위한 서버의 경우는 결과들을 REQUEST 나 session에 저장
		//rest API 서버의 경우는 JSONObject 클래스의 객체를 만들어서 저장한 후  request에 저장한다.
		//웹페이지를 위한 로그인의 경우에만 session에 저장하던지 데이터베이스에 로그인 여부를 저장해 놓습니다.
		JSONObject object = new JSONObject();
		object.put("result", result);
		
		//request에 저장
		request.setAttribute("result", object);
		
		//기억해야 할 것은 파라미터 이름 (userEmail)
		//결과를 저장할 때 사용한 속성이름과 데이터
		//request 나 session에 저장한 이름
		
	}

	@Override
	public void nameCheck(HttpServletRequest request, HttpServletResponse response) {
		//1. 파라미터 읽기
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("service : "+e.getMessage());
			e.printStackTrace();
		}
		String userName = request.getParameter("username");
		//2.별도의 작업을 수행해야 하면 처리
		//암호화 , 파일 업로드 , 파라미터를 다른 자료형으로 변환
		//업무처리에 필요한 알고리즘
		
		//3.dao 작업이 필요하면 호출할 DAO 메소드의 매개변수를 생성
		
		//4.DAO의 메소드를 호출해서 결과를 변수에 저장
		boolean result = userDao.emailCheck(userName);
		//5.단순 웹페이지를 위한 서버의 경우는 결과들을 REQUEST 나 session에 저장
		//rest API 서버의 경우는 JSONObject 클래스의 객체를 만들어서 저장한 후  request에 저장한다.
		//웹페이지를 위한 로그인의 경우에만 session에 저장하던지 데이터베이스에 로그인 여부를 저장해 놓습니다.
		JSONObject object = new JSONObject();
		object.put("result", result);
		
		//request에 저장
		request.setAttribute("result", object);
		
		//기억해야 할 것은 파라미터 이름 (userEmail)
		//결과를 저장할 때 사용한 속성이름과 데이터
		//request 나 session에 저장한 이름
		
	}

}
