<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	//쿠키를 전부 가져오기
	Cookie [] cookies = request.getCookies();
//member_email 과 member_password autologin
	String member_email = "";
	String member_password = "";
	String autologin = "";
	//쿠키가 존재하는 경우에만
	if(cookies != null){
		//모든 쿠키를 순회
		for(Cookie cookie : cookies){
			//쿠키확인 - member_email
			if(cookie.getName().equals("member_email")){
				member_email = cookie.getValue();
			}
			if(cookie.getName().equals("member_password")){
				member_password = cookie.getValue();
				autologin = "checked";
				break;
			}
		}
	}
%>
<%
	//세션에 nickname 값을 가져와서 변수에 저장
	//세션에 저장된 상태가 아니면 null
	String member_name = (String)session.getAttribute("member_name");
%>
</head>
<body>
	<%if(member_name ==null){ %>
	<form id="login" action="login.jsp" class="input-group" method="post">
		<input type="text" class="input-field" name="member_email" value='<%=member_email%>' placeholder="User name or Email" required = "required" > 
		<input type="password" class="input-field" name="member_password" value='<%=member_password%>' placeholder="Enter Password" required = "required"> 
		<input type="checkbox" class="checkbox" name = "autologin" value = "save" <%=autologin %>> <span>Remember Password</span>
		<button class="submit">Login</button>
	</form>
	<%}else{ %>
		<%=member_name %><h2>환영합니다.</h2>
		<a href="logout.jsp">로그아웃</a>
	<%} %>
</body>
</html>