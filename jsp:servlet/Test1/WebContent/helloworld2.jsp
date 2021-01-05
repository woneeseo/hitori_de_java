<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="updateui" method="post">

	<input type="submit" value="데이터가 없어도 상관없죠. 어짜피 데이터 보내봤자 쓸 수도 없습니다.">

</form>


<h1>현재 시각: 2020년 12월 16일 오전 11시 31분 34초</h1>

<%

	Date d = new Date();
	out.print(d.toLocaleString());
	/* 동적 프로그래밍을 가능하게 해줌 */

%>



</body>
</html>