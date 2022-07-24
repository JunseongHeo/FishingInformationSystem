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
    <title>낚시터 찾기</title>
</head>
<body>
    <!-- div는 division 콘텐츠 영역 나누기 class는 스타일 적용을 위한 참조라벨 -->
    <div class ="wrap"> <!--전체-->
        <nav class="navbar"> <!--네비게이션바. header-->
            <div class="nav_logo"> <!--로고블럭-->
                <a href="<c:url value='/'/>" title="메인화면으로 이동">
                    <i class="fa-solid fa-fish"></i>
                    낚시 정보 시스템
                </a>
            </div>
            <ul class="nav_menu"> <!--메뉴블럭-->
                    <li><a href="<c:url value='/location'/>" target='_blank'>낚시터 찾기</a></li>
                    <li><a href="#">날씨 정보</a></li>
                    <li><a href="https://www.yanolja.com/" target='_blank'>숙박</a></li>
                    <li><a href="http://www.dinakmall.co.kr/" target='_blank'>도구대여/거래</a></li>
                    <li><a href="<c:url value='/board'/>">커뮤니티</a></li>
            </ul>
            <div class="nav_login">
                <a href="../_login/login_main.html" title="로그인">
                    <i class="fa-solid fa-right-to-bracket"></i>
                    로그인
                </a>
            </div>
        </nav> <!--네비게이션바 끝-->
        <section class="location_section"> <!--가운데 세션-->
            <div class="map_wrap">
                <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
                <!-- 지도타입 컨트롤 div 입니다 -->
                <div class="custom_typecontrol radius_border">
                    <span id="btnRoadmap" class="selected_btn" onclick="setMapType('roadmap')">지도</span>
                    <span id="btnSkyview" class="btn" onclick="setMapType('skyview')">스카이뷰</span>
                </div>
                <!-- 지도 확대, 축소 컨트롤 div 입니다 -->
                <div class="custom_zoomcontrol radius_border">
                    <span onclick="zoomIn()"><img src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/ico_plus.png" alt="확대"></span>
                    <span onclick="zoomOut()"><img src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/ico_minus.png" alt="축소"></span>
                </div>
            </div>

            <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=72f719b911cadc391d972ee5c8f1c118&libraries=clusterer"></script>
            <script>
                var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                    mapOption = {
                        center: new kakao.maps.LatLng(37.3502055, 127.1089451),
                        level: 3,
                        mapTypeId : kakao.maps.MapTypeId.ROADMAP
                    };
                var map = new kakao.maps.Map(mapContainer, mapOption);

                function setMapType(maptype) {
                    var roadmapControl = document.getElementById('btnRoadmap');
                    var skyviewControl = document.getElementById('btnSkyview');
                    if (maptype === 'roadmap') {
                        map.setMapTypeId(kakao.maps.MapTypeId.ROADMAP);
                        roadmapControl.className = 'selected_btn';
                        skyviewControl.className = 'btn';
                    } else {
                        map.setMapTypeId(kakao.maps.MapTypeId.HYBRID);
                        skyviewControl.className = 'selected_btn';
                        roadmapControl.className = 'btn';
                    }
                }
                function zoomIn() { map.setLevel(map.getLevel() - 1); }
                function zoomOut() { map.setLevel(map.getLevel() + 1); }

                var clusterer = new kakao.maps.MarkerClusterer({
                    map: map,
                    averageCenter: true,
                    minLevel: 5
                })
                var markersArry = [
                    [37.3503352, 127.1098906, '<div class="infoWindow">이젠컴퓨터학원</div>'],
                    [37.3502055, 127.1089451, '<div class="infoWindow">분당 미금역</div>'],
                    [37.3508661, 127.1092592, '<div class="infoWindow">미금역 담소순대국</div>'],
                    [37.3504635, 127.1108343, '<div class="infoWindow">미금역 명륜진사갈비</div>'],
                    [37.3669433,127.1082382, '<div class="infoWindow">포항사람 웃음소리는? <br> 포항항 ꉂꉂ(ᵔᗜᵔ*)</div>']
                ];
                var markers = [];
                for(var i=0; i<markersArry.length; i++) {
                    var marker = new kakao.maps.Marker({
                        position: new kakao.maps.LatLng(markersArry[i][0], markersArry[i][1]),
                        map: map
                    })
                    var infowindow = new kakao.maps.InfoWindow({
                        content : markersArry[i][2]
                    })
                    markers.push(marker);
                    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
                }
                clusterer.addMarkers(markers);
                function makeOverListener(map, marker, infowindow) {
                    return function() {
                        infowindow.open(map, marker);
                    };
                }
                function makeOutListener(infowindow) {
                    return function() {
                        infowindow.close();
                    };
                }
            </script>
        </section>
    </div>
</body>
</html>

