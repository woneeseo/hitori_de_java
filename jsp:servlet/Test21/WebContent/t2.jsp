<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp의 기본 태그</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	
	comment tag(주석 태그) : 
	
	<!-- <h1>comment tag 학습 : HTML의 주석태그</h1> -->
	<% 
		/* String str = "hello"; */ 
		// /* */ : java의 주석태그 - 한줄에서 일부만 주석처리 하고 싶을 때
		// html주석은 브라우저에서 소스보기 하면 주석처리 된 내용을 확인 가능하지만
		// java주석을 사용하면 브라우저에서 주석처리 한 내용을 볼 수 없다 (변환클래스에서는 확인할 수 있음)
	%>
	
	<%--
		String msg = "hello";
		<%-- : jsp의 주석태그 - 서블릿이나 클래스로 변경될 때, 코드 자체가 누락됨
				jsp에서는 jsp 주석태그를 사용하는 것이 좋다
	--%>
	
	<br>
	
	
	directive tag(지시어 태그) : </%@ %><br>
	
		- page directive tag : 거의 손 댈 필요성이 없다. 4가지 경우를 제외하고. </%@ page %><br>
		- include directive tag : 어떤 파일을 현재 페이지에 포함시키고 싶을 때. </%@ include %><br>
		- taglib directive tag : 사용자가 정의한 태그를 사용하고 싶을 때. </%@ taglib %><br>
		
		
		
		
	declaration tag : <br>
	scriptlet tag : </% %> <br>
	expression tag : <br>
	
</body>
</html>