<%@page import="kr.co.ezen.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 자세히 보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>회원정보 자세히 보기</h1>
	
	<%
		MemberDTO dto = (MemberDTO)request.getAttribute("dto");
		pageContext.setAttribute("dto", dto);
	
	%>
	
	ID : ${dto.id}<br>
	NAME : ${dto.name}<br>
	AGE : ${dto.age}<br>
	
	<a href="update.do?id=${dto.id}">수정</a>
	<a href="delete.do?id=${dto.id}">삭제</a>

</body>
</html>