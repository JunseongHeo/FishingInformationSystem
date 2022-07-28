<!DOCTYPE html>
<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/style.css">

    <script src="https://kit.fontawesome.com/30bc34d870.js" crossorigin="anonymous"></script>
    <!-- 나눔스퀘어 폰트 연결 링크 -->
    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
    <!-- 부트스트랩 연동 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- 구글 폰트 (로고에 사용 : font-family: 'Albert Sans', sans-serif;) 연결 링크 -->
    <link href="https://fonts.googleapis.com/css2?family=Albert+Sans:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <!-- css 연결 링크 -->
    <link rel="stylesheet" href="/css/design.css" />
    <link rel="stylesheet" href="/css/productsDesign.css" />
    <link rel="stylesheet" href="/css/style.css" />


</head>
<body>
    <!-- div는 division 콘텐츠 영역 나누기 class는 스타일 적용을 위한 참조라벨 -->
    <div class ="wrap"> <!--전체-->
        <jsp:include page="../topNav.jsp" /> <!-- 네비바 -->

        <!-- 페이지 배너 -->
        <div class="jumbotron">
            <div class="container">
                <h1>커뮤니티 게시판</h1>
            </div>
        </div>

        <section class="main_section"> <!--가운데 세션-->
            <div class="board_main">
                <table name="button_board_writing_create">
                    <tr>
                        <td colspan="5" id="button_writing_create">
                            <input type="button" value="글작성" onclick=' location.href="${path}/board/createPost" '>
                        </td>
                    </tr>
                    <tr>
                        <th>글번호</th>
                        <th>글제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                    <c:forEach items="${list}" var="listUp">
                    <tr>
                        <td>${listUp.bno}</td>
                        <td>
                            <a href="${path}/board/getPost/${listUp.bno}">
                            ${listUp.title}</a>
                        </td>
                        <td>${listUp.userName}</td>
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${listUp.registerDate}" /></td>
                        <td>${listUp.hits}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
    </div>

    <jsp:include page="../footer.jsp" />
</body>
</html>