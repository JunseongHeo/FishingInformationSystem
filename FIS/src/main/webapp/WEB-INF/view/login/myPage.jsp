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
    <link rel="stylesheet" type="text/css" href="../style.css">
    <script src="https://kit.fontawesome.com/30bc34d870.js" crossorigin="anonymous"></script>
    <title>마이페이지</title>
</head>

<body>
    <div class ="wrap"> <!--전체-->
        <jsp:include page="../topNav.jsp" /> <!-- 네비바 -->
        <section class="main_section"> <!--가운데 세션-->
            <main class="main_center_screen">
                <h2>회원 정보 보기</h2>
                <form method="post" action="${path}/login/MyPage">
                    <input type="hidden" name="id" value="${sessionScope.member.id}">
                    <table>
                        <tr>
                            <th>username</th>
                            <td><input type="text" name="userName" value="${sessionScope.member.userName}" required></td>
                        </tr>
                        <tr>
                            <th>gender</th>
                            <td><input type="text" name="gender" value="${sessionScope.member.gender}"></td>
                        </tr>
                        <tr>
                            <th>phone</th>
                            <td><input type="text" name="phone" value="${sessionScope.member.phone}"></td>
                        </tr>
                        <tr>
                            <th>email</th>
                            <td><input type="text" name="email" value="${sessionScope.member.email}"></td>
                        </tr>
                        <tr>
                            <th>address</th>
                            <td><input type="text" name="address" value="${sessionScope.member.address}"></td>
                        </tr>
                        <tr>
                            <th>회원 가입일</th>
                            <td><fmt:formatDate value="${sessionScope.member.registerDate}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                    </table>
                    <input class="btn" type="submit" value="수정">
                    <input class="btn" type="reset" value="취소">
                </form>
            </main>
        </section>
    </div>
</body>
</html>