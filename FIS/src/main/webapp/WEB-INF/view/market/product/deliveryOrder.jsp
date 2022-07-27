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
        <jsp:include page="../menu.jsp" />
        <section>
        <form id="join_form" method="post" action="/market/product/{p_id}/delivery" class="main_section"> <!--가운데 세션-->
        <input type="hidden" value="${deliveryInfo.p_id}" name="p_id">
        <input type="hidden" value="${member.id}" name="buyer">
            <main class="main_center_screen">
                <h1 class="box_header">배송 정보</h1>
                받는 분 : <input type="text" value="${sessionScope.member.userName}" name="buyer_name" class="account" required>
                연락처 : <input type="text" value="${sessionScope.member.phone}" name="buyer_phone" class="account" required>
                배송 주소 : <input type="text" value="${sessionScope.member.address}" name="buyer_address" class="account" required>
                <input type="submit" class="btn btn-info" value="배송 주문" onclick="Order()">
            </main>
        </form>
        </section>
    </div>
    <jsp:include page="../footer.jsp" />
</body>
</html>