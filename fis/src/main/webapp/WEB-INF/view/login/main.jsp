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
    <link rel="stylesheet" href="../css/design2.css" />
    <link rel="stylesheet" href="../css/login.css" />
    <title>로그인</title>
</head>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<body>
    <div class ="wrap header"> <!--전체-->

        <jsp:include page="../topNav.jsp" /> <!-- 네비바 -->

            <!-- 페이지 배너 -->
            <div class="jumbotron">
                <div class="container">
                    <h1>로그인</h1>
                    <p>더 다양한 서비스를 이용하시려면 회원가입 또는 로그인을 진행해주세요</p>
                </div>
            </div>

            <section class="main_section"> <!--가운데 세션-->
                <div class="container">
                    <main class="main_center_screen col-sm-8" align="center">
                        <c:if test = "${result == 0}">
                            <div class = "warning_loginFalse"> ID 또는 Password를 잘못 입력하셨습니다.</div>
                        </c:if>
                        <!--비로그인 상태-->
                        <c:if test = "${member == null}">
                            <h1 class="box_header">로그인</h1>
                            <form id="login_form" method="post" > <!--가운데 세션-->
                                <input id="id" type="text" placeholder="아이디" name="id" class="account col-sm-6">
                                <br>
                                <input id="password" type="password" placeholder="비밀번호를 입력해주세요" name="pw" class="account col-sm-6">
                                <br>
                            </form>
                            <button type="submit" id="button_login" class="account col-sm-6">로그인</button>
                             <div id="membership" class="">
                                 <a href="<c:url value='/login/join'/>" id="membership_join">회원가입</a>
                                 <span>ㅣ</span>
                                 <a href="<c:url value='/login/findId'/>" id="membership_id_recover">아이디 찾기</a>
                                 <span>ㅣ</span>
                                 <a href="<c:url value='/login/findPw'/>" id="membership_password_recover">비밀번호 찾기</a>
                             </div>
                        </c:if>
                        <!--로그인 상태-->
                        <c:if test = "${member != null}">
                            <h1 class="box_header">로그인 되셨습니다.</h1>
                            <br>
                            <h1 class="box_header">환영합니다 "${member.userName}"님!</h1>
                        </c:if>
                    </main>
                </div>
            </section>

    </div> <!-- wrap header 끝-->

    <jsp:include page="../footer.jsp" />
    <script>
        $("#button_login").click(function(){
            $("#login_form").attr("action", "/login/login");
            $("#login_form").submit();
        });
    </script>
</body>
</html>