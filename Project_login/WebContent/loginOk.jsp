<%@page import="java.io.PrintWriter"%>
<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="memberDTO" class="dto.MemberDTO" scope="page" />
<jsp:setProperty property="id" name="memberDTO"/>
<jsp:setProperty property="pw" name="memberDTO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인</title>
</head>
<body>
	<%
		MemberDAO memberDAO = new MemberDAO();
		PrintWriter p = response.getWriter();
		int result = memberDAO.login(memberDTO.getId(), memberDTO.getPw());
		if(result == 1){
			session.setAttribute("a", memberDTO.getId());
			session.setAttribute("b", memberDTO.getUsername());
			response.sendRedirect("test.jsp");
		}
		else if(result == 0){
			p.println("<script>");
			p.println("alert('비밀번호가 틀립니다.')");
			p.println("history.back()");
			p.println("</script>");
		}	
		else if(result == -1){
			p.println("<script>");
			p.println("alert('존재하지 않은 아이디 입니다.')");
			p.println("history.back()");
			p.println("</script>");
		}
		 else if(result == -2){
		p.println("<script>");
		p.println("alert('데이터 베이스 오류가 발생하였습니다.')");
		p.println("history.back()");
		p.println("</script>");
		}	
		
	%>
</body>
</html>