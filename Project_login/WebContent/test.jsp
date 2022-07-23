<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.MemberDAO" %>
<%@ page import = "dto.MemberDTO" %>
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("a");
	String name = (String)session.getAttribute("b");
	
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		아아디 : <%= id %> 이름 : <%= name %>님 안녕하세요

</body>
</html>