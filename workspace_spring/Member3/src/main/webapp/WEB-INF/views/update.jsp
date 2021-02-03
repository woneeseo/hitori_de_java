<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<h1>회원정보 수정</h1>

	<form action="update" method="post">
		ID : <input name="userid" value="${vo.userid}"><br>
		PW : <input name="userpw" type="password"><br>
		Name : <input name="username" value="${vo.username}"><br>
		E-mail : <input name="email" type="email" value="${vo.email}"><br>
		<input type="submit" value="수정하기">
	</form>
	
	

</body>
</html>