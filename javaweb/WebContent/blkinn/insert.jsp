<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/register.css">
<script src="js/jquery.js"></script>
<!-- <script src="js/register.js"></script> -->
</head>
<body>

	<div class="wrap">
		<div class="form-wrap">
			<div class="button-wrap">
				<button type="button" class="togglebtn" onclick="register()">REGISTER</button>
			</div>
			<div class="social-icons">
				<img src="img/facebook.png" alt="facebook"> 
				<img src="img/apple.png" alt="apple"> 
				<img src="img/google.png" alt="google">
			</div>

			<form id="register" class="input-group" method="post">
				<input type="email" class="input-field" name="member_email" placeholder="Enter Email" required> 
				<input type="text" class="input-field" name="member_name" placeholder="User name" required> 
				<input type="password"class="input-field" name="member_password" placeholder="Enter Password" required>
				<!-- <input type="password"class="input-field" name="member_passwordchk" placeholder="Checked your Password" required> -->
				<select name="member_gender" class="input-field">
				  <option value="남자">남자</option>
				  <option value="여자">여자</option>
				  <option value="기타" selected="selected">기타</option>
				</select>

				<button class="submit">REGISTER</button>
				
			</form>
		</div>
	</div>
</body>
</html>