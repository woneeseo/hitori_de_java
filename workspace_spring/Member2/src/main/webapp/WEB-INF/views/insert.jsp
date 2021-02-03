<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>

	<form action="insert" method="post">
		ID : <input name="userid"><br>
		PW : <input name="userpw" type="password"><br>
		Name : <input name="username"><br>
		E-mail : <input name="email" type="email"><br>
		<input type="submit" value="회원 등록">
	</form>

</body>
</html>