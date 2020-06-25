<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE HTML>

<html>
<head>
<title>blkin</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />

</head>
<body>

<%-- <%
//Dao의 클래스를 제대로 확인 할 수 있는지 체크 할 수 있다.
	dao.UserDao userDao = dao.UserDao.sharedInstance(); //dao.UserDao의 dao는 패키지명이다 dao 패키지의 UserDao를 말하는 것이다.
	System.out.println(userDao.emailCheck("binkug1@naver.com"));
%> --%>

	<!-- 바로 user/main으로 포워딩 하도록 해주는 코드 전자 정보 프레임워크가 만들어주는 프로젝트에서 index.jsp에 보면
	이런 코드가 존재합니다.-->
	<jsp:forward page="main/main"></jsp:forward>
</body>
</html>