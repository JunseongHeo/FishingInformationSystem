<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="URL" value="${pageContext.request.requestURL}" />
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	
	<div class="jumbotron">
        <div class="container">
            <h1 class="display-4">상품 목록</h1>
        </div>
    </div>
    <div class="container">
        <div class="row" align="center">
            <c:forEach items="${list}" var="listUp">
                <div class="col-md-4">
                <img src="${pageContext.request.contextPath}/_images/${listUp.p_filename}"
                style="width:100%; padding-bottom:10px">
                <h3>${listUp.p_name}</h3>
                <p>${listUp.p_description}</p>
                <p><fmt:formatNumber value="${listUp.p_unitPrice}" pattern="#,###"/>원</p>
                <p>
                    <a href="./${listUp.p_id}"
                    class="btn btn-secondary" role="button"> 상세보기 </a>
                </p>
                </div>
            </c:forEach>
        </div>
    </div>

    <jsp:include page="../footer.jsp" />

</body>
</html>
