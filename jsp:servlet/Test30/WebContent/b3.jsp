<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<c:set var="myColor" value="blue"/>
	
	<c:if test="${myColor eq 'red'}">
		빨간색입니다.
	</c:if>
	
	<c:if test="${myColor ne 'red'}">
		 빨간색이 아닙니다.
	</c:if>
	
	
	<hr>
	
	<%
	
		request.setAttribute("score", 100);
	
	%>
	
	<c:if test="${score ge 90}">
		수
	</c:if>
	
	<c:if test="${score ge 80 && score lt 90 }">
		우
	</c:if>
	
	<c:if test="${score ge 70 && scroe lt 80}">
		미
	</c:if>
	
	<c:if test="${score ge 60 && score lt 70}">
		양
	</c:if>
	
	<c:if test="${score lt 60}">
		가
	</c:if>
	
	<hr>
	
	<c:choose>
	
		<c:when test="${score >= 90}">
			A
		</c:when>
		<c:when test="${score >= 80}">
			B
		</c:when>
		<c:when test="${score >= 70}">
			C
		</c:when>
		<c:when test="${score >= 60}">
			D
		</c:when>
		<c:otherwise>
			F
		</c:otherwise>
		
	</c:choose>



</body>
</html>