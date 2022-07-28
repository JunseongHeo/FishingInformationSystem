<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="Path" value="${pageContext.request.contextPath}" />
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <script src="https://kit.fontawesome.com/30bc34d870.js" crossorigin="anonymous"></script>
    <title>아이디 찾기</title>
</head>
<body>
    <!-- div는 division 콘텐츠 영역 나누기 class는 스타일 적용을 위한 참조라벨 -->
    <div class ="wrap"> <!--전체-->
        <jsp:include page="../topNav.jsp" /> <!-- 네비바 -->
        <section class="main_section"> <!--가운데 세션-->
            <form id="join_form" method="post" action="/login/findId" class="main_center_screen">
                <c:if test="${check eq 1}">
                    <h3>ID : ${id}</h3>
                </c:if>
                <c:if test="${check eq 0}">
                    <h3>아이디 찾기에 실패했습니다.</h3>
                </c:if>
                <h1 class="box_header">아이디 찾기</h1>
                이름 : <input type="text" placeholder="등록한 이름" name="userName" class="account" required>
                전화번호 : <input type="text" placeholder="휴대폰 번호 '-' 없이 입력" name="phone" class="account" required>
                <input id="button_membership_join_completion" class="account" type="submit" value="아이디 찾기">
                <input id="button_membership_join_completion" class="account" type="button" value="돌아가기" onclick=" location.href='${Path}/login' ">
             </form>
        </section>
    </div>
</body>
</html>