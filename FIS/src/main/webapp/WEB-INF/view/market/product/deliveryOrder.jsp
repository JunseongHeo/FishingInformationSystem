<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="URL" value="${pageContext.request.requestURL}" />
<html lang="ko">
<head>
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


    <title>상품 주문</title>
    <script type="text/javascript">
        //confirm()함수는 사용자의 선택을 할 때 사용
        function Order() {
            if(confirm("해당 상품을 거래하시겠습니까?")){
                alert('주문이 완료되었습니다.');
                document.addForm.submit();
            }
            else {
                document.addForm.reset();
            }
        }
    </script>

</head>
<body>
    <!-- div는 division 콘텐츠 영역 나누기 class는 스타일 적용을 위한 참조라벨 -->
    <div class ="wrap"> <!--전체-->
        <jsp:include page="../../topNav.jsp" /> <!-- 네비바 -->

        <!-- 페이지 배너 -->
        <div class="jumbotron">
            <div class="container">
                <h1>상품 정보 수정</h1>
            </div>
        </div>

        <section>
        <form id="join_form" method="post" action="/market/product/{p_id}/delivery" class="form-horizon tal"> <!--가운데 세션-->
        <input type="hidden" value="${deliveryInfo.p_id}" name="p_id">
        <input type="hidden" value="${member.id}" name="buyer">
        <div class="container add_con">
                <div class="form-group row">
                    <!-- 화면 크기가 768px 이상일 때 12컬럼 중 2칸 사용, 반응형으로-->
                    <label class="col-sm-2"><b>받는 분</b></label>
                    <div class="col-sm-3">
                        <input type="text" value="${sessionScope.member.userName}" name="buyer_name" class="form-control" required>
                    </div>
                </div>
                <div class="form-group row">
                    <!-- 화면 크기가 768px 이상일 때 12컬럼 중 2칸 사용, 반응형으로-->
                    <label class="col-sm-2"><b>연락처</b></label>
                    <div class="col-sm-3">
                        <input type="text" value="${sessionScope.member.phone}" name="buyer_phone" class="form-control" required>
                    </div>
                </div>
                <div class="form-group row">
                    <!-- 화면 크기가 768px 이상일 때 12컬럼 중 2칸 사용, 반응형으로-->
                    <label class="col-sm-2"><b>배송 주소</b></label>
                    <div class="col-sm-3">
                        <input type="text" value="${sessionScope.member.address}" name="buyer_address" class="form-control" required>
                    </div>
                </div>

                <input type="submit" class="btn btn-info" value="배송 주문" onclick="Order()">
        </div>
        </form>
        </section>
    </div>
    <jsp:include page="../../footer.jsp" />
</body>
</html>