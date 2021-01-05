<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <jsp:useBean id="m" class="kr.co.ezen.MemberBean"/>
    <jsp:setProperty property="id" name="m" value="m001"/>
    <jsp:setProperty property="name" name="m" value="kim"/>
    <jsp:setProperty property="age" name="m" value="11"/>
    
    <!-- m이라는 객체(클래스 객체)를 생성한 뒤, setProperty 액션 태그를 이용해 값을 넣어줄 수 있다 -->
    <!-- property=멤버변수명 name=클래스명 value=변수에 넣어줄 값 -->
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	${m.id}<br>
	${m.name}<br>
	${m.age}<br>

</body>
</html>