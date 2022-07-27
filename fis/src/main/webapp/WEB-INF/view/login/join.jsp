<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <script src="https://kit.fontawesome.com/30bc34d870.js" crossorigin="anonymous"></script>
    <title>낚시 정보 시스템 - 회원가입</title>
</head>
<body>
    <!-- div는 division 콘텐츠 영역 나누기 class는 스타일 적용을 위한 참조라벨 -->
    <div class ="wrap"> <!--전체-->
        <jsp:include page="../topNav.jsp" /> <!-- 네비바 -->
        <section>
        <form id="join_form" method="post" action="/login/join" class="main_section"> <!--가운데 세션-->
            <main class="main_center_screen">
                <h1 class="box_header">회원가입</h1>
                <input type="text" placeholder="아이디를 입력해주세요" name="id" class="account" required>
                <input type="password" placeholder="비밀번호를 입력해주세요" name="pw" class="account" required>
                <input type="text" placeholder="이름" name="userName" class="account" required>
                <input type="text" placeholder="성별" name="gender" class="account" >
                <input type="text" placeholder="핸드폰번호" name="phone" class="account" >
                <input type="text" placeholder="이메일" name="email" class="account" >
                <input type="text" placeholder="주소" name="address" class="account">
                <input id="button_membership_join_completion" class="account" type="submit" value="회원가입 완료">
            </main>
        </form>
        </section>
    </div>
</body>
</html>