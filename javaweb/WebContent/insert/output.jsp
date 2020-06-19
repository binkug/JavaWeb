<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 출력</title>
</head>
<body>
	<%	//포워딩 방식에서는 requset에 저장을해서 request로 불러오지만 
		//redirect는 session 혹은 application에 저장을 하기 때문에 sessio 혹은 application으로 불러온다.
		
		//Boolean result = (Boolean)request.getAttribute("result");
		Boolean result = (Boolean)session.getAttribute("result");
		if(result==true){
			out.println("회원가입 성공");
		}else{
			out.println("회원가입 실패");
		}
	%>
</body>
</html>