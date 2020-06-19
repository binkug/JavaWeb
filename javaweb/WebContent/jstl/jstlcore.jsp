<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jstl core 기능 사용을 위한 라이브러리 설정 -->
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="score" value="86"></c:set>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core</title>
</head>
<body>
<!-- score라는 속성 출력 -->
	점수:${score}<br>
	
	<c:set var="id" value="asd"></c:set>
	<!-- id 가 있으면 로그아웃 없으면 로그인을 출력 -->
	<c:if test="${id==null }">
		로그인
	</c:if>
	<c:if test="${id !=null }">
		${id }로그아웃
	</c:if>
	<br>
	<!-- 위와 동일한 처리는 c:choose로 처리 -->
	<c:choose>
		<c:when test="${id == null }">
			로그인
		</c:when>
		<c:when test="${id != null }">
			${id }님 <button value="로그아웃">로그아웃</button> <br>
		</c:when>
	</c:choose>
	수량:<select name="count">
	<c:forEach begin="1" end="10" var="num" step="1">
		<option value="${num }">${num }</option>
	</c:forEach>
	</select>
	<br>
	<%
		String [] ar = {"Call By Value","Call By Reference"};
		request.setAttribute("ar",ar);
	%>
	<select name="name">
	<c:forEach var="item" items="${ar }">
		<option value="${item }"> ${item }<br></option>
	</c:forEach>
	</select>
	
	<%
		Map<String ,Object>map1 = new HashMap<>();
		map1.put("team","kia");
		map1.put("player","양현종");
		
		Map<String ,Object>map2 = new HashMap<>();
		map1.put("team","두산");
		map1.put("player","양의지");
		
		List<Map<String,Object>> list = new ArrayList<>();
		
		list.add(map1);
		list.add(map2);
		
		request.setAttribute("list", list);
	%>
	
	<table border="1">
		<tr>
			<th>팀 </th>
			<th>선수 </th>
		</tr>
		<c:forEach var="item" items="${list }">
		<tr>
			<td>${item.team } </td>
			<td>${item.player } </td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>