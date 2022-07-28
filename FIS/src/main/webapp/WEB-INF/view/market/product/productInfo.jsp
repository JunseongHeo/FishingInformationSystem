<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="URL" value="${pageContext.request.requestURL}" />

<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
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
        <link rel="stylesheet" href="/css/productDesign.css" />


    <title>상품 상세 정보</title>
<script type="text/javascript">
	//confirm()함수는 사용자의 선택을 할 때 사용
	function addToCart() {
		if(confirm("해당 상품을 거래하시겠습니까?")){
			document.addForm.submit();
		}
		else {
			document.addForm.reset();
		}
	}
</script>

</head>
<body>
    <jsp:include page="../../topNav.jsp" /> <!-- 네비바 -->

	<!-- 페이지 배너 -->
	<div class="jumbotron">
        <div class="container">
            <h1 class="display-4">상품 상세 정보</h1>
        </div>
    </div>
		<div class="container">
			<div class="row">
				<!-- 이미지 추가 -->
				<div class="col-md-5 product_img">
                    <img src="${pageContext.request.contextPath}/images/${productInfo.p_filename}"
						 style="width: 100%">
				</div>
	            <div class="col-md-6 product_text">
					<h3> ${productInfo.p_name} </h3>
					<p> ${productInfo.p_description} </p>
					<p><b>등록날짜 : <fmt:formatDate value="${productInfo.regiDate}" pattern="yyyy-MM-dd HH:ss"/></b></p>
					<p><b>상품 코드 : </b><span class="badge badge-danger">${productInfo.p_id}</span></p>
					<p><b>제조사 : ${productInfo.p_manufacturer}</b></p>
					<p><b>분류 : ${productInfo.p_category}</b></p>
					<p><b>재고 수 : <fmt:formatNumber value="${productInfo.p_unitsInStock}" pattern="#,###"/></b></p>
					<p class="product_price"><fmt:formatNumber value="${productInfo.p_unitPrice}" pattern="#,###"/>원</p>

					<p>
						<!-- 상품 주문을 클릭하면 자바스크립트의 핸들러 함수 addToCart()호출되도록 만들었다. -->
						<!-- 장바구니 버튼을 추가하였다.클릭하면 /cart.jsp로 이동하게 만들어 주었다. -->
						<a href="<c:url value='/market/product/${productInfo.p_id}/delivery'/>" class="btn btn-info">상품 주문 >></a>
					    <form name="addForm" action="./addCart.jsp?id=아이디 %>" method="post" style="display: inline;">
					    </form>
						<a href="<c:url value='/market'/>" class="btn btn-secondary">상품 목록 >></a>
                        <c:if test = "${sessionScope.member.id eq productInfo.p_user}">
                            <a href="<c:url value='/market/product/${productInfo.p_id}/edit'/>" class="btn btn-success" role="button">수정 >></a>
                            <form method="post" action="${productInfo.p_id}/delete" style="display: inline;">
                                <input type="submit" class="btn btn-danger" value="삭제 >>">
                            </form>
						</c:if>
					</p>
				</div>
			</div>
	        </div>
    <jsp:include page="../../footer.jsp" />
</body>
</html>