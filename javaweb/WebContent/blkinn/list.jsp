<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 제어문 사용을 위한 태그 라이버리를 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">데이터 목록 보기</h3>
	<table align="center" border="1">
		<tr>
			<td>글번호</td>
			<td>이메일</td>
			<td>이름</td>
		</tr>
		<c:forEach var="blkin" items="${list}">
			<tr>
				<td>${blkin.member_num }</td>
				<!-- 기본키의 값을 파라미터로 전송 -->
				<%-- <td><a href="detail?member_num=${blkin.member_num}">${blkin.member_email }</a></td> --%>
				<td>&nbsp;<a href="detail/${blkin.member_num}">${blkin.member_email }</a></td>
				<td>${blkin.member_name}</td>
			</tr>

		</c:forEach>
	</table>
	<div align = "center">
		<c:if test="${prev == true}">
			<a href="list?no=${startPage-1}">이전</a>
		</c:if>
		
		<c:forEach var="idx" begin="${startPage}" end="${endPage}">
			<c:if test="${pageno == idx}">
				${pageno}&nbsp;
			</c:if>
			<c:if test="${pageno != idx}">
				<a href="list?no=${idx}">${idx}</a>&nbsp;
			</c:if>
		</c:forEach>
		
		<c:if test="${next == true}">
			<a href="list?no=${endPage+1}">다음</a>
		</c:if>
	</div>
</body>
</html>