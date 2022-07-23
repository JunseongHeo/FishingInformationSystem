<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="joinOk.jsp">
	이름 : <input type="text" name="username" placeholder="이름" required="required"/><br><br>
	아이디 : <input type="text" name="id" placeholder="아이디" required="required"/>&nbsp;&nbsp;<input type="button" value="중복확인"><br><br>
	비밀번호 : <input type="password" name="pw" placeholder="비밀번호" required="required"/><br><br>
	전화번호 : <input type="number" name="phone1"/>-<input type="number" name="phone2"/>-<input type="number" name="phone3"/><br><br>
	성별 : <input type="radio" name="gender" value="남자"/>남
		 <input type="radio" name="gender" value="여자"/>여<br><br>
	이메일 : <input type="text" name="email">@
			<select>
			<option value="naver.com">naver.com</option>
			<option value="gmail.com">gmail.com</option>
			<option value="daum.net">daum.net</option>
			</select><br><br>
	주소 : <input type="text" name="address" placeholder="주소"/><br><br>
		<input type="submit" value="회원가입 완료"/>&nbsp;&nbsp;
		<input type="reset" value="다시입력하기"/>
	</form>
</body>
</html>