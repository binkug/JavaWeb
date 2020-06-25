<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- js/register.js 파일의 링크를 설정 -->
<script src="js/register.js"></script>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/member/css/register.css">
<script src="${pageContext.request.contextPath}/member/js/register.js"></script>

</head>
<body>

	<div class="wrap">
		<div class="form-wrap">
			<div class="button-wrap">
				<button type="button" class="togglebtn" onclick="register()">REGISTER</button>
			</div>
			<div class="social-icons">
				<img src="${pageContext.request.contextPath}/member/img/facebook.png" alt="facebook"> 
				<img src="${pageContext.request.contextPath}/member/img/apple.png" alt="apple"> 
				<img src="${pageContext.request.contextPath}/member/img/google.png" alt="google">
			</div>

			<form id="registerform" class="input-group" enctype="multipart/form-data" >
			<div id="msg">유효성 검사</div>
				<input type="email" class="input-field" name="useremail" id="useremail" placeholder="Enter Email" required>
				<div id="emailmsg"></div>  
				<input type="password"class="input-field" name="userpassword" placeholder="Enter Password" required>
				<div id="passwordmsg"></div>
				<input type="password"class="input-field" name="passwordchk" placeholder="Checked your Password" required>
				<input type="text" class="input-field" name="username" id="username" placeholder="User name" required>
				<div id="namemsg"></div>
				<select name="usergender" class="input-field">
				  <option value="남자">남자</option>
				  <option value="여자">여자</option>
				  <option value="기타" selected="selected">기타</option>
				</select>
				<input type="file" class="input-field" name="userimage" id="userimage">
				<button class="submit" name="registerbtn">REGISTER</button>
				<button class="submit" name="mainbtn" id="mainbtn" value="메인">main</button>
				
			</form>
		</div>
	</div>
<!-- 이거임 -->
</body>
</html>