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

	<%
		String test1 = config.getInitParameter("test1");
		String test2 = config.getInitParameter("test2");

	%>
	
	<%= test1 %> : <%= test2 %>

</body>
</html>