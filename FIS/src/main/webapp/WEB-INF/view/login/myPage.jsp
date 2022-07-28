<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="/css/design.css" />
    <link rel="stylesheet" href="/css/join.css" />
    <link rel="stylesheet" href="../css/productsDesign.css" />

    <title>마이 페이지</title>
</head>

<body>
    <div class ="wrap"> <!--전체-->
        <jsp:include page="../topNav.jsp" /> <!-- 네비바 -->
        <!-- 페이지 배너 -->
        <div class="jumbotron">
            <div class="container">
                <h1>마이 페이지</h1>
            </div>
        </div>
        <!-- 서브 메뉴 -->
        <div class="products_menu">
            <div class="navbar navbar-expand">
                <div class="container">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item"><a class="nav-link active" href="<c:url value='/login/myInfoUpdate'/>">회원 정보 수정</a></li>
                        <!-- <form method="post" acton="https:localhost:3070/login/deliveryInfo">
                            <input type="hidden" value="${sessionScope.member.id}" name="p_user">
                            <input class="btn" type="submit" value="배송주문 현황">
                        </form> -->
                    </ul>
                </div>
            </div>
        </div>
        <section class="main_section"> <!--가운데 세션-->
        <div class="container">
            <main class="main_center_screen col-sm-8" align="center">
                <h2>회원 정보</h2>
                    <table align="center">
                        <tr>
                            <th>username</th>
                            <td>${sessionScope.member.userName}</td>
                        </tr>
                        <tr>
                            <th>gender</th>
                            <td>${sessionScope.member.gender}</td>
                        </tr>
                        <tr>
                            <th>phone</th>
                            <td>${sessionScope.member.phone}</td>
                        </tr>
                        <tr>
                            <th>email</th>
                            <td>${sessionScope.member.email}</td>
                        </tr>
                        <tr>
                            <th>address</th>
                            <td>${sessionScope.member.address}</td>
                        </tr>
                        <tr>
                            <th>회원 가입일</th>
                            <td><fmt:formatDate value="${sessionScope.member.registerDate}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                    </table>
                </form>
            </main>
        </div>
        </section>
    </div>
    <jsp:include page="../footer.jsp" /> <!-- 푸터 -->
</body>
</html>