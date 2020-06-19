<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼의 데이터 읽기</title>
</head>
<body>
	<%
		//파라미터 인코딩 설정
		request.setCharacterEncoding("utf-8");
	
		//name,gender,hobby 의 값 읽어오기
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
 		//hobby는 여러 개를 선택할 수 있기 때문에 배열로 읽어야 합니다.
		/* String hobby = request.getParameter("hobby"); */
		String [] hobby = request.getParameterValues("hobby");
		
		//선택하지 않았을 때와 선택한 경우를 나누어서 처리
		String disp = "";
 		if(hobby == null){
 			disp = "선택하지 않았습니다";
 		}else{
 			for(String temp : hobby){
 				disp = disp +temp + "\t";
 			}
 		}
		
	%>
	<p>이름 : <%=name %></p>
	<p>성별 : <%=gender %></p>
	<p>취미 : <%=disp %></p>
	
</body>
</html>