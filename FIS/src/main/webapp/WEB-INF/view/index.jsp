<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="URL" value="${pageContext.request.requestURL}" />
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/style.css">
    <script src="https://kit.fontawesome.com/30bc34d870.js" crossorigin="anonymous"></script>
    <title>낚시 정보 시스템</title>
</head>
<body>
    <!-- div는 division 콘텐츠 영역 나누기 class는 스타일 적용을 위한 참조라벨 -->
    <div class ="wrap"> <!--전체-->
        <div class="intro_bg"> <!--배경-->
            <nav class="navbar"> <!--네비게이션바-->
                <div class="nav_logo"> <!--로고블럭-->
                    <a href="<c:url value='/'/>" title="메인화면으로 이동">
                    <i class="fa-solid fa-fish"></i>
                    낚시 정보 시스템
                    </a>
                </div>
                <ul class="nav_menu"> <!--메뉴블럭-->
                    <li><a href="http://www.kff.or.kr/fishing/zoneList.php" target='_blank'>낚시터 찾기</a></li>
                    <li><a href="#">날씨 정보</a></li>
                    <li><a href="https://www.yanolja.com/" target='_blank'>숙박</a></li>
                    <li><a href="http://www.dinakmall.co.kr/" target='_blank'>도구대여/거래</a></li>
                    <li><a href="<c:url value='/board'/>">커뮤니티</a></li>
                </ul>
                <div class="nav_login">
                    <a href="./_login/login_main.html" title="로그인">
                        <i class="fa-solid fa-right-to-bracket"></i>
                        로그인
                    </a>
                </div>
            </nav> <!--네비게이션바 끝--> 
            <div class="intro_text">
                <h1 id="main_text">당신을 위한 낚시 정보 시스템</h1>
                <h4 id="main_text" class="contents">필요한 정보들을 한 눈에! '낚시 정보 시스템'과 함께하세요</h4>
            </div>
        </div>
    </div>
</body>
</html>