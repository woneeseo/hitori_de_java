<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제 비밀번호 입력 화면</title>
</head>
<body>

<h1>${userid}의 비밀번호를 입력하세요.</h1>

<form action="/delete" method="post">
	
	<input type="hidden" name="userid" value="${userid}" readonly><br>
	PW : <input name="userpw" type="password"><br>
	<input type="submit" value="삭제">
	
</form>

</body>
</html>