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
	<h1>EL의 null처리</h1>
	<%
		pageContext.setAttribute("m", null);
	%>
	
	${m}<br>
	<!-- EL은 null을 받으면 값이 아예 없었던 것 처럼 처리를 하기 때문에 브라우저에 아무것도 출력되지 않는다. -->
	${m.charAt(0)}<br>
	<!-- null point exception 또한 데이터 자체가 없는 것 처럼 처리해준다.: null에 대해 관대하다. -->
	
	<h1>EL에서 데이터가 null인지 여부 확인하기</h1>
	${m == null}<br>
	위의 코드처럼 쉽게 표현할 수 있다. 하지만 잘 사용하지 않음.<br>
	${ empty m }<br>
	-> 대부분 empty를 사용한다.<br>
	${m != null}<br> 대신 ${ not empty m}<br> 를 쓴다.

</body>
</html>