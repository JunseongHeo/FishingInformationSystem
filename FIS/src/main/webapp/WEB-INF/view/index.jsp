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
    <div class ="wrap"> <!--전체-->
        <div class="intro_bg"> <!--배경-->
            <jsp:include page="topNav.jsp" />
            <div class="intro_text">
                <h1 id="main_text">당신을 위한 낚시 정보 시스템</h1>
                <h4 id="main_text" class="contents">필요한 정보들을 한 눈에! '낚시 정보 시스템'과 함께하세요</h4>
            </div>
        </div>
    </div>

</body>
</html>