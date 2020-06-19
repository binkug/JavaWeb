<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 입력</title>
</head>
<body>

	<a href="process1.jsp?boardnum=120&nickname=binkug">파라미터 직접 작성</a>
	<br/>
	<!-- action이 처리할 서버의 url로 생략하면 현재 URL 
	method가 전송방식으로 생략 하면 get file이 있는 경우 enctype을 multipart/form-date로 설정
	클라이언트에서 유효성 검사를 하고자 하는 경우에는 id를 부여-->
	<form action="process2.jsp" method="post" >
		<span>이름</span>
		<span><input type="text" name="name"/></span> <br>
		
		<span>성별</span>
		<span>
			<input type="radio" name="gender" value="man" checked="checked"/>남자
			<input type="radio" name="gender" value="woman"/>여자 <br>
		</span>
		
		<span>취미</span>
		<span>
			<input type="checkbox" name="hobby" value="reading"/>독서
			<input type="checkbox" name="hobby" value="computer"/>컴퓨터
			<input type="checkbox" name="hobby" value="game"/>게임 
		</span>
		<br>
		<input type="submit" value="전송"/>
		
	</form>
</body>
</html>