<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<p>footer입니다</p>

<%	
	String msg = request.getParameter("msg");
	String name = request.getParameter("name");
%>

<%= msg %><br>
${param.msg}
${param.name}
<%-- t4에서 넘겨준 데이터 받아오기 --%>