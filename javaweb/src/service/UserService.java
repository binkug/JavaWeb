package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//user에 대한 처리를 하기 위한 메소드 선언을 위한 메소드
//메뉴판과 유사한 역할을 수행합니다.
public interface UserService {
	
	public void emailCheck(HttpServletRequest request,HttpServletResponse response);
	
	public void nameCheck(HttpServletRequest request,HttpServletResponse response);
	
	public void register(HttpServletRequest request,HttpServletResponse response);
}
