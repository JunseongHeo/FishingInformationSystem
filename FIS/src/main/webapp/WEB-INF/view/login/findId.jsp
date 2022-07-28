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
    <!-- 나눔스퀘어 폰트 연결 링크 -->
    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
    <!-- 부트스트랩 연동 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- 구글 폰트 (로고에 사용 : font-family: 'Albert Sans', sans-serif;) 연결 링크 -->
    <link href="https://fonts.googleapis.com/css2?family=Albert+Sans:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <!-- css 연결 링크 -->
    <link rel="stylesheet" href="../css/design.css" />
    <link rel="stylesheet" href="../css/id_recover.css" />

    <title>아이디 찾기</title>
</head>
<body>
    <!-- div는 division 콘텐츠 영역 나누기 class는 스타일 적용을 위한 참조라벨 -->
    <div class ="wrap header"> <!--전체-->
        <jsp:include page="../topNav.jsp" /> <!-- 네비바 -->

        <!-- 페이지 배너 -->
        <div class="jumbotron">
            <div class="container">
                <h1>아이디 찾기</h1>
                <p>더 다양한 서비스를 이용하시려면 회원가입 또는 로그인을 진행해주세요</p>
            </div>
        </div>

        <section class="main_section"> <!--가운데 세션-->
            <div class="container">
                <main class="main_center_screen col-sm-8"  >
                    <form method="post" action="/login/findId" align="center">
                        <c:if test="${check eq 1}">
                            <h3 id="findResult">ID : ${id}</h3>
                        </c:if>
                        <c:if test="${check eq 0}">
                            <h3 id="findResult">아이디 찾기에 실패했습니다.</h3>
                        </c:if>
                        <h1 class="box_header">아이디 찾기</h1>
                        <input type="text" placeholder="이름" name="userName" id="name" class="account col-sm-6" required>
                        <input type="text" placeholder="휴대폰 번호 '-' 없이 입력" name="phone" id="birth" class="account col-sm-6" required>
                        <input id="button_id_recover_completion" class="account col-sm-6" type="submit" value="아이디 찾기">
                        <div class="button_back0 col-sm-6">
                            <a href="<c:url value='/login/findPw'/>" class="account col-sm-6" class="button_back">비밀번호 찾기</a>
                        </div>
                        <div class="button_back col-sm-6">
                            <a href="<c:url value='/login'/>" id="button_back" class="account col-sm-6" class="button_back">돌아가기</a>
                        </div>
                     </form>
                 </main>
             </div>
        </section>
    </div>

    <jsp:include page="../footer.jsp" />
</body>
</html>