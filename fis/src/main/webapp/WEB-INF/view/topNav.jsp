<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="URL" value="${pageContext.request.requestURL}" />

<nav class="navbar"> <!--네비게이션바-->
    <div class="nav_logo"> <!--좌측 로고블럭-->
        <a href="<c:url value='/'/>" title="메인화면으로 이동">
        <i class="fa-solid fa-fish"></i>
        낚시 정보 시스템
        </a>
    </div>
    <ul class="nav_menu"> <!--중앙 메뉴블럭-->
        <li><a href="<c:url value='/location'/>">낚시터 찾기</a></li>
        <li><a href="#">날씨 정보</a></li>
        <li><a href="<c:url value='/market'/>">마켓</a></li>
        <li><a href="<c:url value='/board'/>">커뮤니티</a></li>
    </ul>
    <div class="nav_login"> <!--우측 로그인블럭-->
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