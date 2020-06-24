<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>아이디</td>
			<td>${blkin.member_email}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${blkin.member_name}</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${blkin.member_gender}</td>
		</tr>
		<tr>
			<td>생일</td>
			<td>${blkin.member_birthday}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${blkin.member_content}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<!-- 수정과 삭제는 기본키를 넘겨받아야 합니다. -->
				<!-- 절대 경로로 링크를 생성 -->
				<a href="${pageContext.request.contextPath}/blkin/update/${blkin.member_num}">수정</a>&nbsp;
				<a href="${pageContext.request.contextPath}/blkin/delete/${blkin.member_num}">삭제</a>&nbsp;
				<a href="${pageContext.request.contextPath}/blkin/list">목록보기</a>
			</td>
		</tr>
	</table>
</body>
</html>