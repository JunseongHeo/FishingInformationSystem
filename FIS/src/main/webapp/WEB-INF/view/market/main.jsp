<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="URL" value="${pageContext.request.requestURL}" />
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 나눔스퀘어 폰트 연결 링크 -->
    <link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
    <!-- 부트스트랩 연동 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- 구글 폰트 (로고에 사용 : font-family: 'Albert Sans', sans-serif;) 연결 링크 -->
    <link href="https://fonts.googleapis.com/css2?family=Albert+Sans:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <!-- css 연결 링크 -->
    <link rel="stylesheet" href="../css/design.css" />
    <link rel="stylesheet" href="../css/productsDesign.css" />

    <title>상품 목록</title>
</head>
<body>
    <jsp:include page="../topNav.jsp" /> <!-- 네비바 -->

	<!-- 페이지 배너 -->
    <div class="jumbotron">
        <div class="container">
            <h1>중고거래</h1>
            <p>중고 낚시 용품을 자유롭게 사고 팔 수 있는 중고거래 게시판입니다.</p>
        </div>
    </div>

    <!-- 서브 메뉴 -->
    <div class="products_menu">
        <div class="navbar navbar-expand">
            <div class="container">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link active" href="<c:url value='/market'/>">상품 목록</a></li>
                    <li class="nav-item"><a class="nav-link click" href="<c:url value='/market/product/add'/>">상품 등록</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row" align="center">
            <c:forEach items="${list}" var="listUp">
                <div class="col-md-4 products_text">
                <img src="${pageContext.request.contextPath}/images/${listUp.p_filename}"
                style="width:100%; padding-bottom:15px">
                <h3>${listUp.p_name}</h3>
                <p class="description">${listUp.p_description}</p>
                <p class="price"><fmt:formatNumber value="${listUp.p_unitPrice}" pattern="#,###"/>원</p>
                <p class="more">
                    <a href="/market/product/${listUp.p_id}" class="btn" role="button"> 상세보기 </a>
                </p>
                </div>
            </c:forEach>
        </div>
    </div>

    <jsp:include page="../footer.jsp" />

</body>
</html>
