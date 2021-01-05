<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<!-- expressions language : EL , 어딘가에 출력할 목적으로 사용하는 것은 expression tag와 같으나,확장성이 더 좋다. -->
<!-- 하지만, 반드시 바인딩 작업을 선행해야 한다 -->

<%= "hello" %><br>
<%= "world" %>

<!-- expression tag : 어딘가에 출력할 목적으로 쓰는 태그 -->

${"hello"}<br>
				
<hr>

<%
	String msg = "hello world";
	pageContext.setAttribute("msg", msg);
%>

<p title="${msg}">12121231231235167231</p>

</body>
</html>