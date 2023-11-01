<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
		<script defer src="${conPath }/js/hotel.js"></script>
		<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCiH3wc-L426sYwgkfih0AbVUq4sNwTEbM&callback=initMap"></script>
	<style>
    * {
      margin: 0; padding: 0;
    }
    
    body {
    	background-color: #fff;
    }
    #hotel_wrap {
      width: 1400px;
      min-height: 600px;
      padding: 0 90px 100px 90px;
      margin: 0 auto;
      box-sizing: border-box;
    }
    .hotel_btn {
      border-bottom: 1px solid #ccc;
    }
    .hotel_btn button{
      color: #e9a624;
      background-color: #fff;
      outline: none !important;
      border: none;
      cursor: pointer;
      padding: 10px;
      display: inline-block;
      position: relative;
      font-size: 20px;
      margin-bottom: 10px;
      font-weight: 400;
      letter-spacing: -0.8px;
    }
    button:hover > .theme_color {
      background-color: #e9a624;
      position: absolute;
      left: 0;
      bottom: -10px;
      width: 100%;
      height: 1px;
    }
    .hotel_content {
      text-align: center;
    }
    .hotel_content img {
      width: 100%;
    }
    .hotel_content p {
      color: #999;
      padding: 3px 0 4px 0;
      font-size: 15px;
      line-height: 25px;
      letter-spacing: .3em;
    }
    .content_line {
      width: 100%;
      border-bottom: 1px solid #ccc;
      margin-bottom: 40px;
    }
    .hotel_table {
      width: 100%;
      border-spacing: 0;
      border: 1px solid #ebebeb;
      border-width: 1px;
      font-size: 13px;
      letter-spacing: -.7px;
      color: #333;
      box-sizing: border-box;
    }
    .discount_line {
      text-decoration: line-through;
    }
    .discount_color {
      color: red;
    }
    .table_tab {
      background-color: #eee;
    }
    #map {
    	height: 600px;
    }
  </style>
</head>
<body>
  <jsp:include page="../main/header.jsp"/>
  
  <div id="hotel_wrap">
    <div class="hotel_btn">
      <button>
        <h3>요금안내</h3>
        <span class="theme_color"></span>
      </button>
    <!--   <button>
        <h3>객실정보</h3>
        <span class="theme_color"></span>
      </button>
      <button>
        <h3>예약방법 및 확불규정</h3>
        <span class="theme_color"></span>
      </button> -->
    </div>
    <div class="hotel_content">
      <img src="${conPath }/img/hotel/hotel_back.png" alt="">
      <p>멍이랑 냥이량 이용 요금은 정액요금제로 운영됩니다.</p>
      <p>기본제공 : 물, 사료, 장난감, 담요 등</p>
      <p>입-퇴실 가능 시간 : AM 08:00 ~ PM 08:00</p>
      <p class="content_line"></p>
      <h4 style="color:#e9a624; text-align: left;">1. 요금제</h4>
      <p>요금제 관련 문의는 고객센터 또는 내방해 주시면 자세히 설명해드리겠습니다.</p>
      <table class="hotel_table" cellspacing="0" border="1" summary="표">
        <tr>
          <th class="table_tab">종류</th><th>5일권</th><th>10일권</th><th>15일권</th><th>20일권</th><th>30일권</th>
        </tr>
        <tr>
          <td class="table_tab">요금</td>
          <td>50000원</td>
          <td><a class="discount_line">100000원</a>(<a class="discount_color">80000원</a>)</td>
          <td><a class="discount_line">200000원</a>(<a class="discount_color">170000원</a>)</td>
          <td><a class="discount_line">280000원</a>(<a class="discount_color">250000원</a>)</td>
          <td><a class="discount_line">400000원</a>(<a class="discount_color">350000원</a>)</td>
        </tr>
        <tr>
          <td class="table_tab">이용기준</td>
          <td colspan="5">강아지,고양이 1마리 기준 / 실제 호텔이용 기간 만큼 차감</td>
        </tr>
        <tr>
          <td class="table_tab">추가비용</td>
          <td colspan="5">강아지, 고양이 추가시, 호텔이용기간 * 5000원 추가</td>
        </tr>
        <tr>
          <td class="table_tab">이용객실</td>
          <td colspan="5">공실 객실 중 모든 객식 이용 가능</td>
        </tr>
      </table>
      <p class="content_line"></p>
     	<h4 style="color:#e9a624; text-align: left;">2. 이용안내</h4>
      <p>오픈기념 이벤트 진행중으로 정액권 할인중입니다.</p>
      <p>멍이랑냥이랑에서 분양받으신 회원님께는 요금 - 10% 추가로 할인해 드립니다.</p>
      <p>⚠ 예약 취소시, 환불 규정에따라 환불해 드립니다. 환불 규정을 꼭 읽어주시고 진행해주세요.</p>
      <p>저희 멍이랑냥이랑에서는 수의사가 상주하고 있으며, 위급/긴급 상황시 최대한 케어해드립니다.</p>
      <p>모든 객실은 분리 운영 되고있으며, 매일 소독/청소를 진행하고 있으니 안심하고 맡겨주세요.</p>
      <p>입-퇴실 시, 혹시 모를 불상사를 대비하여 보호자 깨서는 밖에서 대기해 주셔야 합니다.</p>
    </div>
    
    <p class="content_line"></p>
    <h4 style="color:#e9a624; text-align: left;">3. 호텔 위치</h4>
    <div id="map">
    </div>
  </div>
  <jsp:include page="../main/footer.jsp"/>
</body>
</html>