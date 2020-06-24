<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- action을 생략하면 이전과 동일한 요청 -->
	<h3>데이터 수정</h3>
	<form method="post">
		코드<input type="text" value="${blkin.member_num}"
		name="member_num" id="member_num" readonly="readonly" /><br>
		이메일<input type="text" value="${blkin.member_email}"
		name="member_email" id="member_email" readonly="readonly" /><br>
		이름<input type="text" value="${blkin.member_name}"name="member_name" id="member_name"/><br>
		설명<textarea name="member_content" id="member_content" rows="10" cols="30">${blkin.member_content}</textarea><br>
		<input type="submit" value="수정" />
		<input type="button" value="메인" id="mainbtn"/>
		<input type="button" value="목록" id="listbtn"/>
	</form>
</body>
<script type="text/javascript">
document.getElementById("mainbtn").addEventListener("click",function(event){
	location.href="${pageContext.request.contextPath}/";
});
document.getElementById("listbtn").addEventListener("click",function(event){
	location.href="${pageContext.request.contextPath}/blkin/list";
});
</script>
</html>