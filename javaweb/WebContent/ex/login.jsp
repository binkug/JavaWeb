<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
							<label for="email" class="screen_out">이메일</label> <input
								type="email" id="email" name="email" placeholder="이메일을 입력하세요">
						</div>
						<div class="inp_text">
							<label for="userpw" class="screen_out">비밀번호</label> <input
								type="password" id="userpw" name="userpw"
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
						<a href="register.html"	class="link_find">회원가입</a> 
						
					</div>
					<!-- 네이버아이디로로그인 버튼 노출 영역 -->
					<div id="naverIdLogin" class="naverIdLogin"></div>
					
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>