package com.naver.binkug.dao;

import com.naver.binkug.domain.User;

public class UserDao extends AbstaractDao {
	//Singleton 패턴을 적용하기 위한 코드
	//인스턴스를 하나만 생성하는 디자인 패턴
	//모든 곳에서 공유할 데이터를 갖는 클래스나 Entry point(출입구)에 해당하는 클래스 또는
	//서버에서 클라이언트의 요청을 처리하는 클래스는 인스턴스가 1개이면 된다.
	private UserDao() {}
	
	private static UserDao userDao;
	
	public static UserDao sharedInstance() {
		if(userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}
	
	public boolean emailCheck(String useremail) {
		System.out.println(useremail);
		boolean result = false;
		connect();
		try {
			//sql 생성
			pstmt = con.prepareStatement("select user_email from user where upper(user_email) = ?");
			//데이터 바인딩
			pstmt.setString(1, useremail.toUpperCase());
			//sql 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = false;
			}else {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("Dao emailCheck : "+e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public boolean nameCheck(String username) {
		boolean result = false;
		connect();
		try {
			//sql 생성
			pstmt = con.prepareStatement("select user_name from user where upper(user_name) = ?");
			//데이터 바인딩
			pstmt.setString(1, username.toUpperCase());
			//sql 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = false;
			}else {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("Dao username : "+e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	public int insert(User user) {
		int result = -1;
		connect();		
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		close();
		return result;
	}
}
