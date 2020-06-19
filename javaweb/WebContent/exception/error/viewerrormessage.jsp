<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- exception 객체를 사용할 수 있도록 설정 -->
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 발생</title>
</head>
<body>
	에러 메시지:<%=exception.getMessage() %><br/>
</body>
</html>