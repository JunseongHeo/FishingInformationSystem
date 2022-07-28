<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="URL" value="${pageContext.request.requestURL}" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<!-- 외부 자바스크립트 파일을 가져오기 위해서 아래와 같이 코드를 입력하도록 함 -->
<script type="text/javascript" src="./resources/js/validation.js"></script>
<meta charset="UTF-8">
<title>상품 등록</title>
<!-- 나눔스퀘어 폰트 연결 링크 -->
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square.css" rel="stylesheet">
<!-- 부트스트랩 연동 -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
<!-- 구글 폰트 (로고에 사용 : font-family: 'Albert Sans', sans-serif;) 연결 링크 -->
<link href="https://fonts.googleapis.com/css2?family=Albert+Sans:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
<!-- css 연결 링크 -->
<link rel="stylesheet" href="/css/design.css" />
<link rel="stylesheet" href="/css/productsDesign.css" />
<link rel="stylesheet" href="/css/addProductDesign.css" />
</head>
<body>

    <jsp:include page="../../topNav.jsp" /> <!-- 네비바 -->

	<!-- 페이지 배너 -->
    <div class="jumbotron">
        <div class="container">
            <h1>상품 등록</h1>
            <p>판매할 물건의 정보를 입력해주세요</p>
        </div>
    </div>

    
    <div class="container add_con">
        <!-- class="form-horizontal"은 폼요소들이 수평적으로 배치가 되도록 해줌 -->
        <form name="newProduct" action="/market/product/add" class="form-horizontal"
        	method="post" enctype="multipart/form-data">  <!-- 파일 업로드 -->
            <input type="hidden" value="${member.id}" name="p_user">
            <div class="form-group row">
                <!-- 화면 크기가 768px 이상일 때 12컬럼 중 2칸 사용, 반응형으로-->
                <label class="col-sm-2"><b>상품 코드</b></label>
                <div class="col-sm-3">
                	<!-- id 속성을 추가한 것은 유효성 검사를 위해서 이 document에서 자바스크립트 파일에서 참조하기 위함 -->
                    <input type="text" name="p_id" class="form-control" placeholder="상품 코드를 입력하세요">
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-sm-2 add_name"><b>상품명&nbsp;&nbsp;*</b></label>
                <div class="col-sm-3">
                    <input type="text" name="p_name" class="form-control" placeholder="상품명을 입력하세요">
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-sm-2 add_name"><b>가격&nbsp;&nbsp;*</b></label>
                <div class="col-sm-3">
                    <input type="number" name="p_unitPrice" class="form-control" placeholder="가격을 입력하세요">
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-sm-2 add_name"><b>상세정보&nbsp;&nbsp;*</b></label>
                <div class="col-sm-5">
                    <textarea name="p_description" cols="50" rows="2" class="form-control"></textarea>
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-sm-2 add_name"><b>제조사</b></label>
                <div class="col-sm-3">
                    <input type="text" name="p_manufacturer" class="form-control" placeholder="제조사를 입력하세요">
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-sm-2 add_name"><b>분류&nbsp;&nbsp;*</b></label>
                <div class="col-sm-3">
                    <input type="text" name="p_category" class="form-control" placeholder="분류를 입력하세요">
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-sm-2 add_name"><b>재고 수</b></label>
                <div class="col-sm-3">
                    <input type="number" name="p_unitsInStock" class="form-control" placeholder="재고 수를 입력하세요">
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-sm-2"><b>상태</b></label>
                <div class="col-sm-5">
                    <input type="radio" name="p_condition" value="New"> 신규 제품 &nbsp;
                    <input type="radio" name="p_condition" value="Old"> 중고 제품 &nbsp;
                    <input type="radio" name="p_condition" value="Refurbished"> 재생 상품 &nbsp;
                </div>
            </div>
            
            <!-- 상품 이미지 업로드 부분 -->
            <div class="form-group row">
                <label class="col-sm-2 add_name"><b>이미지&nbsp;&nbsp;*</b></label>
                <div class="col-sm-3">
                    <input type="text" name="p_filename" class="form-control">
                </div>
            </div>
            
            <div class="form-group row">
            	<!-- offset : col의 2만큼 띄워라 -->
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-primary" value="등록">
                </div>
            </div>
            
        </form>
    </div>
    
    <jsp:include page="../../footer.jsp" />
    
</body>
</html>