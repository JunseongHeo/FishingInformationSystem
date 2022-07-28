<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="URL" value="${pageContext.request.requestURL}" />
<c:set var="Path" value="${pageContext.request.contextPath}" />
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <!-- 나눔스퀘어 폰트 연결 링크 -->
    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
    <!-- 부트스트랩 연동 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- 구글 폰트 (로고에 사용 : font-family: 'Albert Sans', sans-serif;) 연결 링크 -->
    <link href="https://fonts.googleapis.com/css2?family=Albert+Sans:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <!-- css 연결 링크 -->
    <link rel="stylesheet" type="text/css" href="/css/design.css">
    <title>낚시 정보 시스템</title>
</head>
<body>
    <div class="header">
        <!-- 1. 메인 이미지 -->
        <div class="bg_img">
        <!-- 2. 네비게이션 -->
            <div class="navbar navbar-expand">
                <div class="container">
                    <!-- 2-1. 로고 (왼쪽) -->
                    <div class="nav_logo">
                        <img src="../images/fishing_hook_blue.png" alt="">
                        <a class="navbar-brand" href="<c:url value='/'/>">FISHING LIFE</a>
                    </div>
                    <!-- 2-2. 메뉴 (중간) -->
                    <div class="nav_menu">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item"><a href="<c:url value='/location'/>">낚시터 찾기</a></li>
                            <li class="nav-line">ㅣ</li>
                            <li class="nav-item"><a href="">날씨 정보</a></li>
                            <li class="nav-line">ㅣ</li>
                            <li class="nav-item"><a href="<c:url value='/board'/>">커뮤니티</a></li>
                            <li class="nav-line">ㅣ</li>
                            <li class="nav-item"><a href="<c:url value='/market'/>">중고거래</a></li>
                            <li class="nav-line">ㅣ</li>
                            <li class="nav-item"><a href="<c:url value='/login/myPage'/>">마이페이지</a></li>
                        </ul>
                    </div>
                    <!-- 2-3. 로그인 (오른쪽) -->
                    <c:if test = "${member == null}">
                        <div class="nav_login">
                            <a class="login" href="<c:url value='/login'/>"><img src="../images/login.png">로그인</a>
                        </div>
                    </c:if>
                    <c:if test = "${member != null}">
                        <div class="nav_login">
                            <a href="<c:url value='/login/logout'/>" title="로그아웃"><img src="../images/logout.png">로그아웃</a>
                        </div>
                    </c:if>
                </div>
            </div>
            <!-- 3. 메인 페이지 소개글 -->
            <div class="intro_text">
                <div class="container">
                    <!-- 3-1. 상단 -->
                    <span>당신의 낚시 파트너</span>
                    <!-- 3-2. 중간 (웹사이트 이름) -->
                    <h1>FISHING LIFE<img src="./_images/fishing_hook_white.png" alt=""></h1>
                    <!-- 라인 -->
                    <div class="line"></div><br>
                    <!-- 3-3. 하단 (웹사이트 설명) -->
                    <p>낚시터와 날씨, 숙박 등 낚시에 대한 모든 정보를 확인하고,<br>
                    커뮤니티와 중고거래 페이지를 통해 낚시인들과 소통하세요 !
                    </p>
                </div>
            </div>

        </div>
    </div>

    <!-- 4. 푸터 -->
    <div class="footer">
        <div class="container">
            <h1>
                ⓒ 2022.08.01. &nbsp;Legend Of JAVA(EZEN). &nbsp;All rights reserved.
                &nbsp; &nbsp;ㅣ &nbsp; &nbsp;
                <span>이 웹사이트는 비영리 목적으로 제작되었습니다.</span>
            </h1>

        </div>
    </div>
</body>
</html>