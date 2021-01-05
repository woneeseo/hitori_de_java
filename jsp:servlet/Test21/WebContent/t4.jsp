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

<h1>
	<%@ include file="part.jsp" %>
</h1>
<h1>
	 본문
</h1>
<h1>
	<jsp:include page="footer.jsp">
		<jsp:param value="hello" name="msg"/>
		<jsp:param value="kim" name="name"/>
	</jsp:include>
	<%-- 동적인 기능을 한다? 파라미터를 넘겨줄 수 있다는 의미 --%>
	<%-- <jsp:param value="hello" name="msg"/> 으로 지정한 데이터를 footer에 넘겨줄 수 있다는 의미이다 --%>
	<%-- include action 태그 --%>
	<%-- <jsp:include page=""/> 를 사용하게 되면, include directive태그와 같은 역할을 함 --%>
</h1>

</body>
</html>