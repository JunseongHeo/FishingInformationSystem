<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	
	String username = request.getParameter("username");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String gender = request.getParameter("gender");
	
	MemberDTO dto = new MemberDTO();
	MemberDAO dao = new MemberDAO();
	
	//클라이언트(사용자)가 입력한 회원 정보를 DTO객체에 저장하는 코드
	dto.setUsername(username);
	dto.setId(id);
	dto.setPw(pw);
	dto.setPhone1(phone1);
	dto.setPhone2(phone2);
	dto.setPhone3(phone3);
	dto.setEmail(email);
	dto.setAddress(address);
	dto.setGender(gender);
	
	//ArrayList에 새로운 멤버를 추가하고 있다.
	dao.addMember(dto);

	response.sendRedirect("gogogo.jsp");
	
%>