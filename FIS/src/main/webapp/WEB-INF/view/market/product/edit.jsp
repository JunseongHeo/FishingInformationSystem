<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="URL" value="${pageContext.request.requestURL}" />
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/style.css">
    <script src="https://kit.fontawesome.com/30bc34d870.js" crossorigin="anonymous"></script>
    <title>상품 등록</title>
</head>
<body>
    <jsp:include page="../../topNav.jsp" /> <!-- 네비바 -->
	<jsp:include page="../menu.jsp" />

	<!-- 점보트론은 대형전광판이라는 의미를 지니고 있는데, 다양한 컴포넌트(텍스트, 이미지, 회사로고 등) 포함 가능 -->
	<div class="jumbotron">
        <div class="container">
            <h1 class="display-4">상품 등록</h1>
        </div>
    </div>

    <div class="container">

	</div>

    <div class="container">
        <!-- class="form-horizontal"은 폼요소들이 수평적으로 배치가 되도록 해줌 -->

        <form action="${path}/market/product/${productInfo.p_id}/edit" class="form-horizontal"
        	method="post" enctype="multipart/form-data">  <!-- 파일 업로드 -->
            <div class="form-group row">
                <!-- 화면 크기가 768px 이상일 때 12컬럼 중 2칸 사용, 반응형으로-->
                <label class="col-sm-2"><b>상품 코드</b></label>
                <div class="col-sm-3">
                	<!-- id 속성을 추가한 것은 유효성 검사를 위해서 이 document에서 자바스크립트 파일에서 참조하기 위함 -->
                    <input type="text" name="p_id" class="form-control" value="${productInfo.p_id}">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2"><b>상품명</b></label>
                <div class="col-sm-3">
                    <input type="text" name="p_name" class="form-control" value="${productInfo.p_name}">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2"><b>가격</b></label>
                <div class="col-sm-3">
                    <input type="number" name="p_unitPrice" class="form-control" value="${productInfo.p_unitPrice}">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2"><b>상세정보</b></label>
                <div class="col-sm-5">
                    <textarea name="p_description" cols="50" rows="2" class="form-control">${productInfo.p_description}</textarea>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2"><b>제조사</b></label>
                <div class="col-sm-3">
                    <input type="text" name="p_manufacturer" class="form-control" value="${productInfo.p_manufacturer}">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2"><b>분류</b></label>
                <div class="col-sm-3">
                    <input type="text" name="p_category" class="form-control" value="${productInfo.p_category}">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2"><b>재고 수</b></label>
                <div class="col-sm-3">
                    <input type="number" name="p_unitsInStock" class="form-control" value="${productInfo.p_unitsInStock}">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2"><b>상태</b></label>
                <div class="col-sm-5">
                    <input type="radio" name="p_condition" value="New"
                    <c:if test="${productInfo.p_condition eq 'New'}">checked</c:if>> 신규 제품 &nbsp;
                    <input type="radio" name="p_condition" value="Old"
                    <c:if test="${productInfo.p_condition eq 'Old'}">checked</c:if>> 중고 제품 &nbsp;
                    <input type="radio" name="p_condition" value="Refurbished"
                    <c:if test="${productInfo.p_condition eq 'Refurbished'}">checked</c:if>> 재생 상품 &nbsp;
                </div>
            </div>

            <!-- 상품 이미지 업로드 부분 -->
            <div class="form-group row">
                <label class="col-sm-2"><b>이미지</b></label>
                <div class="col-sm-3">
                    <input type="text" name="p_filename" class="form-control" value="${productInfo.p_filename}">
                </div>
            </div>

            <div class="form-group row">
            	<!-- offset : col의 2만큼 띄워라 -->
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-primary" value="수정완료">
                </div>
            </div>

        </form>
    </div>
    <jsp:include page="../footer.jsp" />
</body>
</html>