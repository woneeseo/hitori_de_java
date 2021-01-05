<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="m" class="kr.co.ezen.MemberBean" scope="application"/>
    <jsp:setProperty property="*" name="m"/>
    <!-- 각각의 property 의 이름과 parameter 이름이 동일하기 떄문에 -->
    <!-- property="*" 가 동일한 이름을 가진 것 끼리 짝을 지을 수 있도록 해줌  -->
    <!-- scope="" 로 스코프를 지정해주면 데이터의 범위를 지정해 줄 수 있다 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	${m.id} : ${m.name} <br>
	${m.age}
	
</body>
</html>