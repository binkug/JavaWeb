<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${email == null}">
		이 페이지는 로그인 한 유저만 사용할 수 있습니다.
	</c:if>
	<c:if test="${email != null}">
		메롱
	</c:if>

</body>
</html>