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
    <title>마이페이지</title>
</head>

<body>
    <table>
    <c:forEach itmes="${deliInfo}" var="listUP">
        <tr>
          <td>판매자 ID : ${listUP.p_id}/td>
          <td>판매자 이름 : ${listUP.p_user}/td>
          <td>구매자 ID : ${listUP.buyer}/td>
          <td>배송 받는분 : ${listUP.buyer_name}/td>
          <td>받는분 연락처 : ${listUP.buyer_phone}/td>
          <td>받는 주소 : ${listUP.buyer_address}/td>
        </tr>
    </c:forEach>

    </table>

</body>
</html>