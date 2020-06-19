<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//파라미터 읽기
	request.setCharacterEncoding("utf-8");
	String member_email = request.getParameter("member_email");
	String member_password = request.getParameter("member_password");
	String autologin = request.getParameter("autologin");
	
	//autologin 의 값을 확인
	//value에 설정된 save가 나와면 체크를 한 것이고
	//null이면 체크를 안한 것임
	System.out.println(autologin);
	
	//자동 로그인에 체크하지 않은 경우
	if(autologin ==null){
		//id,pw를 저장한 쿠키가 있으면 삭제
		
		//모든 쿠키를 전부 가져오기
		Cookie [] cookies = request.getCookies();

		//쿠키가 존재한다면
		if(cookies != null){
			//쿠키를 전부 순회
			for(Cookie cookie : cookies){
				//id,pw라는 이름의 쿠키가 존재한다면
				if(cookie.getName().equals("member_email")){
					//쿠키삭제
					//쿠키는 삭제하는 메소드가 없고 수명을 0으로 만들어서 삭제
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
				if(cookie.getName().equals("member_password")){
					//쿠키삭제
					//쿠키는 삭제하는 메소드가 없고 수명을 0으로 만들어서 삭제
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
		}
	}else{
		//자동 로그인에 체크한 경우
		//id를 저장한 쿠키를 생성하고 저장
		
		//쿠키를 생성
		Cookie cookieid = new Cookie("member_email",member_email);
		Cookie cookiepw = new Cookie("member_password",member_password);
		//쿠키를 저장
		response.addCookie(cookieid);
		response.addCookie(cookiepw);
	}
	
	//로그인이 되었을 때 필요한 정보를 Session에 저장
	session.setAttribute("member_email", member_email);
	session.setAttribute("member_name", "백승훈");
	
	
	//결과 페이지로 리다이렉트
	response.sendRedirect("cookiesession.jsp");
%>
</body>
</html>