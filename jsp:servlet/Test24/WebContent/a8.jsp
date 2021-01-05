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

	<h1>Expression Language(EL)</h1>
	${"이렇게 사용합니다."}<br>
	${1}<br>
	${false}<br>
	${1+1}<br>
	${2-1}<br>
	${7%3}<br> <!-- %는 나머지!!!!! -->
	${3*4}<br>
	${1/2}
	
	<h1>EL의 비교연산자</h1>
	${3 > 5}<br>
	${3 gt 5}<br><!-- 3 greater than 5 -->
	${3 >= 5}<br>
	${3 ge 5}<br><!-- 3 greater than or equal 5 -->
	${3 < 5}<br>
	${3 lt 5}<br><!-- 3 less than 5 -->
	${3 <= 5}<br>
	${3 le 5}<br><!-- 3 less than or equal 5 -->
	${3 == 5}<br>
	${3 eq 5}<br><!-- 3 equals 5 -->
	${3 != 5}<br>
	${3 ne 5}<br><!-- ne = not equals, 사용은 가능하지만 에러메세지가 뜬다 -->
	
	<h1>EL의 논리연산</h1>
	
	${true && true}<br>
	${true && false}<br>
	${false && true}<br>
	${false && false}<br>
	
	${true || true}<br>
	${true || false}<br>
	${false || true}<br>
	${false || false}<br>
	
	${!true}<br>
	${!false}
	
	<h1>EL 삼항(조건)연산자</h1>
	
	<!--  ${"조건식?참 일때 값:거짓일 떄 값"} -->
	
	3이 4보다 크면 45, 아니면 100이 브라우저에 출력되도록 하세요.<br>
	
	${3 > 4 ? 45 : 100}<br>
	
</body>
</html>