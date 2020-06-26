<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming</title>
<style type="text/css">
div {
	float: left;
}

ul {
	text-align: center; /* 텍스트를 가운데로 정렬 */
	list-style-type: none;
	padding-bottom: 0.5em;
	margin-right: 0.5em;
}

li {
	padding-bottom: 0.5em;
}
</style>
</head>
<body>
	<div>
		<h3 align="center">1일차 jsp 학습 0615</h3>
		<ul type="square">
			<li><a href="jsppractice/first.jsp"> jsp의 시작 시작 </a></li>
			<li><a href="jsppractice/random.jsp">랜덤 함수 사용하기</a></li>
			<li><a href="jsppractice/declare.jsp">Quick sort</a></li>
			<li><a href="jsppractice/datadisplay.jsp">list에 데이터를 저장 및 출력하기</a></li>
		</ul>
	</div>
	<div>
		<h3 align="center">2일차 jsp 학습 0616</h3>
		<ul type="square">
			<li><a href="requstobject/requestinfo.jsp"> 클라이언트 정보 </a></li>
			<li><a href="requstobject/inputparameter.jsp"> 파라미터 전송하기 </a></li>
			<li><a href="requstobject/application.jsp"> application 객체 </a></li>
			<li><a href="read/input.jsp"> 요청 페이지1 a태그 활용 </a></li>
			<li><a href="insert/input.jsp"> 요청 페이지2 form 태그 활용 </a></li>
		</ul>
	</div>
	<div>
		<h3 align="center">3일차 jsp 학습 0617</h3>
		<ul type="square">
			<li><a href="cookiesession/cookiesession.jsp"> Cookie를 활용해서 cookie에 기록 남기기</a></li>
			<li><a href="cookiesession/cookiesession.jsp"> Cookie를 활용하고 Session 활용하기</a></li>
		</ul>
	</div>
	<div>
		<h3 align="center">4일차 jsp 학습 0618</h3>
		<ul type="square">
			<li><a href="exception/test.jsp"> 예외처리</a></li>
			<li><a href="el/input.jsp"> EL(ExpressionLanguage)</a></li>
			<li><a href="attribute/attributecreate.jsp"> attribute</a></li>
			<li><a href="jstl/jstlcore.jsp">JSTL Core</a></li>
		</ul>
	</div>
	<div>
		<h3 align="center">5일차 jsp 학습 0619</h3>
		<ul type="square">
			<li><a href="${pageContext.request.contextPath }/authentication/main">메인</a></li>
		</ul>
	</div>
	<div>
		<h3 align="center">6,7일차 jsp 학습 0623,24</h3>
		<ul type="square">
			<li><a href="blkin/blkinlist">전체 데이터 조회</a></li>
			<li><a href="blkin/insert">삽입</a></li>
		</ul>
	</div>
		<div>
		<h3 align="center">7일차 jsp 학습 0625</h3>
		<ul type="square">
			<li><a href="main/main">회원가입 및 로그인</a></li>
		</ul>
	</div>
	
</body>
</html>