<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="m" class="kr.co.ezen.MemberBean"/>
    <!-- useBean 액션 태그는 보통 page directive tag와 <!DOCTYPE html> 사이에 추가한다 -->
    <!-- id="클래스명" class="참조해서 사용할 클래스의 풀 패키지명" -->
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	
	<%
		m.setId("m001");
		m.setName("kim");
		m.setAge(11);
	
	%>
	
	${m.id} : ${m.name} : ${m.age}
	<!-- EL 태그는 useBean action 태그를 이용하면 자동으로 코드를 인식한다. -->
	<!-- 스크립틀릿 태그 내부에서 바인딩 해 줄 필요가 없다 : EL은 useBean action을 지원한다 -->

</body>
</html>