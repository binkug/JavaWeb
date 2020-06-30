<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<meta name="viewport"content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/member/css/login.css">
<script type="text/javascript"src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"charset="utf-8"></script>
</head>
<body>
	<h1 >blkin</h1>
	<div class="inner_login">
		<div class="login_myweb">
			<div id="msg" class="msg"></div>
			<form method="post" id="loginform" action="login">
				<fieldset>
					<legend class="screen_out">로그인 정보 입력폼</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="email" class="screen_out">이메일</label> 
							<input type="email" id="member_password" name= "member_email" placeholder="이메일을 입력하세요">
						</div>
						<div class="inp_text">
							<label for="userpw" class="screen_out">비밀번호</label> 
							<input type="password" id="member_password" name="member_password"
								placeholder="비밀번호를 입력하세요">
						</div>
					</div>
					<button type="submit" class="btn_login">로그인</button>
					<div class="login_append">
						<div class="inp_chk">
							<input type="checkbox" id="keepLogin" class="inp_radio"
								name="keepLogin"> <label for="keepLogin" class="lab_g">
								<span class="img_top ico_check"></span> <span class="txt_lab">로그인
									상태 유지</span>
							</label>
						</div>
					</div>
					<div class="login_append" align="center">
						<a href="#" class="link_find">아이디 찾기</a> 
						<a href="#"class="link_find">비밀번호 찾기</a> 
						<a href="${pageContext.request.contextPath}/member/register" class="link_find">회원가입</a> 
						<a href="${pageContext.request.contextPath}/member/main" class="link_find">메인으로</a> 
					</div>
					<!-- 네이버아이디로로그인 버튼 노출 영역 -->
					<div id="naverIdLogin" class="naverIdLogin"></div>
					
				</fieldset>
			</form>
		</div>
	</div>
	
</body>
<script src="${pageContext.request.contextPath}/member/js/login.js"></script>
<script type="text/javascript">
	var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "개발자센터에 등록한 ClientID",
			callbackUrl: "개발자센터에 등록한 callback Url",
			isPopup: false, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
		}
	);
	
	/* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();
	
</script>
</html>