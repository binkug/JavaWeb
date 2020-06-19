<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력</title>
</head>
<body>
	<form id="register" action="process.jsp" class="input-group" method="post">
		<input type="email" class="input-field" name="member_email" placeholder="Your Email" required="required"> 
		<input type="text" class="input-field" name="member_name" placeholder="User name" required="required"> 
		<input type="password"class="input-field" name="member_password" placeholder="Enter Password" required="required">
		<input type="checkbox" class="checkbox">
		<span>Terms and conditions</span>
		<button class="submit">REGISTER</button>
	</form>
</body>
</body>
</html>