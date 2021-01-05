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

	int a = 10;
	a = 55;
	
	/* public void me1(){ }
	스크립틀릿 태그의 service()는 메서드와 같은 역할을 하기 때문에 메서드를 생성할 수 없다 */
	/* 외부에서 선언된 (decleartion 태그 내부에 선언 된) 메서드 호출은 가능함 */
	
	int[] arr = {1, 3, 6, 2, 1, 9};
	
	for(int i=0; i<arr.length; i++){ 
	%>
		<%= arr[i] %><br>
	
	<% } %>

<%

	/* int a = 33; */
	/* 스크립틀릿 태그가 여러개여도 하나의 service()영역으로 인식하기 때문에 위에서 선언한 변수를 
		아래에서 새롭게 선언하려하면 duplication 오류가 생긴다 */
	
%>

</body>
</html>