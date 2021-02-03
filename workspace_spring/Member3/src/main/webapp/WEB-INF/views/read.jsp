<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 자세히 보기</title>
</head>
<body>

<h1>회원정보 자세히 보기</h1>

	ID : ${vo.userid}<br>
	Name : ${vo.username}<br>
	E-mail : ${vo.email}<br>
	가입일 : <fmt:formatDate value="${vo.regdate}" type="date" pattern="yyyy-MM-dd"/><br>
	최종 변경일 : <fmt:formatDate value="${vo.updatedate}" type="date" pattern="yyyy-MM-dd"/><br>
	
	<hr>
	
	<a href="/update/${vo.userid}">수정</a> | <a href="/deleteConfrim/${vo.userid}">삭제</a>
	
	<form action="delete" method="post">
		<input type="hidden" name="userid" value="${userid}">
		<input type="hidden" name="userpw">
	</form>

</body>
</html>