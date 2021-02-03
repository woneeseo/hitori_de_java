<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<a href="insert">회원 등록</a>
<h1>회원 목록</h1>

	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>가입일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="read/${dto.userid}">${dto.userid}</a></td>
				<td>${dto.username}</td>
				<td><fmt:formatDate value="${dto.regdate}" type="date" pattern="yyyy-MM-dd"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>