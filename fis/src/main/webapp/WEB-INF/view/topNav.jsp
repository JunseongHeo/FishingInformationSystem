<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
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
</div>
