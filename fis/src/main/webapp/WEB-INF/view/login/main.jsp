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
    <title>낚시 정보 시스템 - 로그인</title>
</head>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<body>
    <div class ="wrap"> <!--전체-->
            <nav class="navbar"> <!--네비게이션바-->
                <div class="nav_logo"> <!--로고블럭-->
                    <a href="<c:url value='/'/>" title="메인화면으로 이동">
                    <i class="fa-solid fa-fish"></i>
                    낚시 정보 시스템
                    </a>
                </div>
                <ul class="nav_menu"> <!--메뉴블럭-->
                    <li><a href="<c:url value='/location'/>">낚시터 찾기</a></li>
                    <li><a href="#">날씨 정보</a></li>
                    <li><a href="https://www.yanolja.com/">숙박</a></li>
                    <li><a href="http://www.dinakmall.co.kr/">마켓</a></li>
                    <li><a href="<c:url value='/board'/>">커뮤니티</a></li>
                </ul>
                <div class="nav_login">
                    <c:if test = "${member == null}">
                    <a href="<c:url value='/login'/>" title="로그인">
                        <i class="fa-solid fa-right-to-bracket"></i>
                        로그인
                    </a>
                    </c:if>
                    <c:if test = "${member != null}">
                    <a href="<c:url value='/login/logout'/>" title="로그아웃">
                        <i class="fa-solid fa-arrow-right-from-bracket"></i>
                        로그아웃
                    </a>
                    </c:if>
                </div>
            </nav> <!--네비게이션바 끝--> 
            <section>
            <form id="login_form" method="post" class="main_section"> <!--가운데 세션-->
                <main class="main_center_screen">
                    <c:if test = "${result == 0}">
                        <div class = "warning_loginFalse"> ID 또는 Password를 잘못 입력하셨습니다.</div>
                    </c:if>
                    <!--비로그인 상태-->
                    <c:if test = "${member == null}">
                        <h1 class="box_header">로그인</h1>
                        <input type="text" placeholder="아이디를 입력해주세요" name="id" class="account">
                        <input type="password" placeholder="비밀번호를 입력해주세요" name="pw" class="account">
                        <button type="submit" id="button_login" class="account">로그인</button>
                        <button type="button" id="button_membership_join" class="account" onclick=' location.href="${path}/login/join" '>회원가입</button>
                        <button id="button_membership_id_recover" class="account" onclick=" location.href='./login_id_recover.html' ">아이디 찾기</button>
                        <button id="button_membership_password_recover" class="account" onclick=" location.href='./login_password_recover.html' ">비밀번호 찾기</button>
                    </c:if>
                    <!--로그인 상태-->
                    <c:if test = "${member != null}">
                        <h1 class="box_header">로그인 되셨습니다.</h1>
                        <h1 class="box_header">환영합니다 "${member.userName}"님!</h1>
                    </c:if>
                </main>
            </form>
            </section>
    </div>
<script>
    $("#button_login").click(function(){
        $("#login_form").attr("action", "/login/login");
        $("#login_form").submit();
    });
</script>
</body>
</html>