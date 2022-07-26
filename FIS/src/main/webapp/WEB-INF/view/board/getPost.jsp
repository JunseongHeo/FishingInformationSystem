<!DOCTYPE html>
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
        <jsp:include page="../topNav.jsp" /> <!-- 네비바 -->
        <section class="main_section"> <!--가운데 세션-->
            <div class="board_main">
                <h2>게시글 보기</h2>
                    <table class="borad_writing_table">
                        <tr>
                            <th>제목</th>
                            <td id="read_title">${postInfo.title}</td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td><div class="board_writing_read_content">${postInfo.contents}</div></td>
                        </tr>
                    </table>
                    <form method="post" action="${postInfo.bno}/delete">
                        <div class="borad_writing_create_button">
                        <input class="btn" type="button" value="목록" onclick=' location.href="${path}/board" '>
                        <c:if test = "${sessionScope.member.id eq postInfo.userId }">
                        <input class="btn" type="button" value="수정" onclick=' location.href="${path}/board/getPost/${postInfo.bno}/update" '>
                        <input class="btn" type="submit" value="삭제">
                        </c:if>
                        </div>
                    </form>
            </div>
        </section>
    </div>
</body>
</html>