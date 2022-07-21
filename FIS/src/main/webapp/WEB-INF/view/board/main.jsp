<html lang="ko">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/style.css">
    <script src="https://kit.fontawesome.com/30bc34d870.js" crossorigin="anonymous"></script>
    <title>커뮤니티</title>
</head>
<body>
    <!-- div는 division 콘텐츠 영역 나누기 class는 스타일 적용을 위한 참조라벨 -->
    <div class ="wrap"> <!--전체-->
        <nav class="navbar"> <!--네비게이션바. header-->
            <div class="nav_logo"> <!--로고블럭-->
                <a href="<c:url value='/'/>" title="메인화면으로 이동">
                    <i class="fa-solid fa-fish"></i>
                    낚시 정보 시스템
                </a>
            </div>
            <ul class="nav_menu"> <!--메뉴블럭-->
                <li><a href="http://www.kff.or.kr/fishing/zoneList.php" target='_blank'>낚시터 찾기</a></li>
                <li><a href="https://www.yanolja.com/" target='_blank'>숙박</a></li>
                <li><a href="http://www.dinakmall.co.kr/" target='_blank'>도구대여/거래</a></li>
                <li><a href="<c:url value='/board'/>">커뮤니티</a></li>
            </ul>
            <div class="nav_login">
                <a href="../_login/login_main.html" title="로그인">
                    <i class="fa-solid fa-right-to-bracket"></i>
                    로그인
                </a>
            </div>
        </nav> <!--네비게이션바 끝-->
        <section class="main_section"> <!--가운데 세션-->
            <div class="board_main">
                <h2>커뮤니티</h2>
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
                        <td>${listUp.writer}</td>
                        <td>${listUp.registerDate}</td>
                        <td>${listUp.hits}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
    </div>
</body>
</html>