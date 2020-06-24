package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BlkinService {
	//blkin 테이블의 모든 데이터를 읽어오는 메소드
	public void list(HttpServletRequest request,HttpServletResponse response);
	//blkin 테이블에 데이터를 저장하는 메소드
	public void insert(HttpServletRequest request,HttpServletResponse response);
	//blkin 테이블에 한개의 데이터를 읽어오는 메소드
	public void detail(HttpServletRequest request,HttpServletResponse response);
	//blkin 테이블에 데이터를 업데이트
	public void update(HttpServletRequest request,HttpServletResponse response);
	//blkin 테이블에 데이터 삭제
	public void delete(HttpServletRequest request,HttpServletResponse response);
		
}
