<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라이언트 정보</title>
</head>
<body>
	<%
		//접속한 클라이언트의 IP 주소 가져오기
		String ip = request.getRemoteAddr();
		//컨텍스트 경로
		String contextPath = request.getContextPath();
		//전체 요청 경로
		String requestURI = request.getRequestURI();
		//라우팅 경로 requestURI에서 contextPath를 제외한 부분
		//contextPath의 길이만큼을 제외하고 잘라내기
		String route = requestURI.substring(contextPath.length());
	%>
	<h3>IP: <%=ip %></h3>
	<h3>서버 경로: <%=contextPath %></h3>
	<h3>요청 경로: <%=requestURI %></h3>
	<h3>라우팅 경로: <%=route %></h3>
	
</body>
</html>