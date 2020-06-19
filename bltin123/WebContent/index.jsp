<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>blkin</title>
</head>
<body>
	<a href="create.com">삽입</a>
	<a href="raed.com">조회</a>
	<a href="update.com">갱신</a>
	<a href="delete.com">삭제</a>
	
	<c:if test="${email == null}">
		<a href="login.com">로그인</a><br>
	</c:if>
	<c:if test="${email != null}">
		<a href="logout.com">로그아웃</a><br>
	</c:if>
	<a href="write.com">글쓰기</a>
</body>
</html>