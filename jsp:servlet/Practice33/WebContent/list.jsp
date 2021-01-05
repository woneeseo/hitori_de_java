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

	<c:choose>
		<c:when test="${empty login}">
			<a href="loginui.do">로그인</a>
		</c:when>
		<c:otherwise>
			${login.name} 님, 안녕하세요!
			<a href="logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>

	<h1>회원 목록</h1>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>
						<a href="read.do?id=${dto.id}">${dto.id}</a>
					</td>
					<td>${dto.name}</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>

</body>
</html>