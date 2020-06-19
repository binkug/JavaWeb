<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OOP</title>
</head>
<body>
<%
	List<Map<String,Object>> list = (List<Map<String,Object>>)request.getAttribute("list");

	//데이터를 출력
	for(Map<String,Object> map: list){
		out.print("<div>"+map.get("name")+" : "+map.get("description")+"</div>");
	}
%>
</body>
</html>