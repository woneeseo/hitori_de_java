<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<%
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("good");
		list.add("morning");
		
		request.setAttribute("list", list);
	%>
	
	<%
		for(int i=0; i<list.size(); i++){
			pageContext.setAttribute("m", list.get(i));
	%>
	
		<a href="http://www.naver.com?m=${m}">${m}</a>
	
	<% 
		} 
	%>

</body>
</html>