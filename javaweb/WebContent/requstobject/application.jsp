<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 객체</title>
</head>
<body>
	<%
		//초기화 파라미터 읽기
		String url = application.getInitParameter("url");
	%>
	
	<h3>url:<%=url%></h3>
</body>
</html>




