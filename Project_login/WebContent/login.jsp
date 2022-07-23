<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="loginOk.jsp" method="post">
		<b>아이디 : <input type="text" name="id" required="required"> </b><br><br>
		<b>비밀번호 : <input type="password" name="pw" required="required"></b><br><br>
		<input type="submit" value="로그인">&nbsp;&nbsp; 
		<input type="button" value="회원가입" onclick="location.href = 'member.jsp';"><br><br>
	</form>
	<a href="findid.jsp">아이디 찾기</a> <a href="findpw.jsp">비빌번호 찾기</a>
</body>
</html>