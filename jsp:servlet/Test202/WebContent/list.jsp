<%@page import="kr.co.ezen.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1>회원 목록</h1>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
		</thead>
		
		<tbody>
			
			<% List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("list"); 
				for(int i = 0; i<list.size(); i++){
			%>
			<tr>
				<td>
					<a href="read.do?id=<%= list.get(i).getId() %>">
						<%= list.get(i).getId() %>
					</a>
				</td>
				<td>
					<%= list.get(i).getName() %>
				</td>
			<%
				}
			%>
			
		</tbody>
	</table>
</body>
</html>