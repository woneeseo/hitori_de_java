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

	<h1>영역객체에 바인딩 된 데이터 출력하기</h1>
	<%
		pageContext.setAttribute("p", "pageContext");
		request.setAttribute("r", "request");
		session.setAttribute("s", "session");
		application.setAttribute("a", "application");
	%>
	
	${p}<br>
	${r}<br>
	${s}<br>
	${a}<br>
	
	<hr>
	
	${pageScope.p}
	${requestScope.r}
	<!-- 여러가지 내장 객체가 있지만 잘 사용하지는 않는다. -->
	
	

</body>
</html>