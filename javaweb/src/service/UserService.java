package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//user에 대한 처리를 하기 위한 메소드 선언을 위한 메소드
//메뉴판과 유사한 역할을 수행합니다.
public interface UserService {
	//이메일 체크를 위한 메소드
	public void emailCheck(HttpServletRequest request,HttpServletResponse response);
	//name 체크를 위한 메소드
	public void nameCheck(HttpServletRequest request,HttpServletResponse response);
	//회원가입을 위한 메소드
	public void register(HttpServletRequest request,HttpServletResponse response);
	//로그인을 위한 메소드
	public void login(HttpServletRequest request,HttpServletResponse response);
	//proxy 서비스를 위한 메소드
	public void proxy(HttpServletRequest request,HttpServletResponse response);
}
