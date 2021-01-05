<%@page import="kr.co.command.LoginDTO"%>
<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>

	<c:choose>
		<c:when test="${ empty login}">
			<a href="loginui.do">로그인</a>
		</c:when>
		
		<c:otherwise>
			${lonin.name} 님, 환영합니다!
			<a href="logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>
	

	<!-- ${ not empty login ? login.name : "" } -->
	<!-- 로그인에 데이터가 있냐? 그럼 로그인이 가진 name데이터를 가져오고, 없으면 빈칸으로 둬라 -->

	<!--  ${ not empty login ?
	 		"환영합니다!. <a href='logout.do'>로그아웃</a>"
				 : "<a href='loginui.do'>로그인</a>" } -->
	<!-- 로그인에 데이터가 있냐? 그럼 로그아웃 화면으로 가는 링크를 보여주고 아니면 로그인 링크를 보여줘라 -->
	<!-- EL 태그의 삼항조건식으로 구현할 수 있다. 단, EL태그 안에는 중복으로 EL를 사용할 수 없다 -->

	<h1>회원 목록</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
		</thead>
		
		<!--</% %>와 for문을 이용해 데이터를 출력했던 식을 forEach문으로 간단히 작업했다 -->

		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href="read.do?id=${dto.id}">${dto.id}</a></td>
					<td>${dto.name}</td>
				</tr>	
			</c:forEach>
			
		</tbody>

	</table>

</body>
</html>