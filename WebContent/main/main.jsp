<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="${conPath}/css/main.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" />
    <%-- login Msg --%>
  <c:if test="${not empty LoginFailMsg}">
  	<script>
  		alert('${LoginFailMsg}');
  		history.back();
  	</script>
  </c:if>
  <br><br>
	<div id="wrap">
		<div id="container">
			<div class="slide">
				<img src="${conPath}/img/banner/banner_1.png" alt="banner_1">
			</div>
			<div class="slide">
				<img src="${conPath}/img/banner/banner_2.png" alt="banner_2">
			</div>
			<div class="slide">
				<img src="${conPath}/img/banner/banner_3.png" alt="banner_3">
			</div>
			<div class="slide">
				<img src="${conPath}/img/banner/banner_4.png" alt="banner_4">
			</div>
		</div>
		<div id="content">
			<div class="ext_list">
        <h2 class="ext_list_title">
          LOVE CAT
          <span>
            <img src="${conPath}/img/ico/cat-100.png" alt="cat_100">
          </span>
        </h2>
      </div>
        <ul>
          <li>
            <div class="ext_list_cat">
              <div class="info_img">
                <a href="${conPath}/photoBbs/catinfo.jsp?catname=겨울">
                  <img src="${conPath}/img/cat/겨울_노르웨이숲_01.jpg" alt="1">
                </a>
              </div>
              <div class="info_text">
                <h4>
                  <span>노르웨이숲</span>
                  <p>겨울</p>
                </h4>
                <p>2023.06월생</p>
              </div>
            </div>
          </li>
          <li>
            <div class="ext_list_cat">
              <div class="info_img">
                <a href="${conPath}/photoBbs/catinfo.jsp?catname=라브">
                  <img src="${conPath}/img/cat/라브_랙돌_01.jpg" alt="1">
                </a>
              </div>
              <div class="info_text">
                <h4>
                  <span>랙돌</span>
                  <p>라브</p>
                </h4>
                <p>2023.06월생</p>
              </div>
            </div>
          </li>
          <li>
            <div class="ext_list_cat">
              <div class="info_img">
                <a href="${conPath}/photoBbs/catinfo.jsp?catname=미니">
                  <img src="${conPath}/img/cat/미니_먼치킨_01.jpg" alt="1">
                </a>
              </div>
              <div class="info_text">
                <h4>
                  <span>먼치킨</span>
                  <p>미니</p>
                </h4>
                <p>2023.06월생</p>
              </div>
            </div>
          </li>
          <li>
            <div class="ext_list_cat">
              <div class="info_img">
                <a href="${conPath}/photoBbs/catinfo.jsp?catname=호잇">
                  <img src="${conPath}/img/cat/호잇_브리티쉬_02.jpg" alt="1">
                </a>
              </div>
              <div class="info_text">
                <h4>
                  <span>브리티쉬</span>
                  <p>호잇</p>
                </h4>
                <p>2023.06월생</p>
              </div>
            </div>
          </li>
        </ul>
        <ul>
          <li>
            <div class="ext_list_cat">
              <div class="info_img">
                <a href="${conPath}/photoBbs/catinfo.jsp?catname">
                  <img src="${conPath}/img/cat/준비중.png" alt="1">
                </a>
              </div>
              <div class="info_text">
                <h4>
                  <span>-</span>
                  <p>준비중</p>
                </h4>
                <p>2023.10 예정</p>
              </div>
            </div>
          </li>
          <li>
            <div class="ext_list_cat">
              <div class="info_img">
                <a href="${conPath}/photoBbs/catinfo.jsp?catname">
                  <img src="${conPath}/img/cat/준비중.png" alt="1">
                </a>
              </div>
              <div class="info_text">
                <h4>
                  <span>-</span>
                  <p>준비중</p>
                </h4>
                <p>2023.10 예정</p>
              </div>
            </div>
          </li>
          <li>
            <div class="ext_list_cat">
              <div class="info_img">
                <a href="${conPath}/photoBbs/catinfo.jsp?catname">
                  <img src="${conPath}/img/cat/준비중.png" alt="1">
                </a>
              </div>
              <div class="info_text">
                <h4>
                  <span>-</span>
                  <p>준비중</p>
                </h4>
                <p>2023.10 예정</p>
              </div>
            </div>
          </li>
          <li>
            <div class="ext_list_cat">
              <div class="info_img">
                <a href="${conPath}/photoBbs/catinfo.jsp?catname">
                  <img src="${conPath}/img/cat/준비중.png" alt="1">
                </a>
              </div>
              <div class="info_text">
                <h4>
                  <span>-</span>
                  <p>준비중</p>
                </h4>
                <p>2023.10 예정</p>
              </div>
            </div>
          </li>
        </ul>
        <div class="ext_list">
          <h2 class="ext_list_title">
            LOVE DOG
            <span>
              <img src="${conPath}/img/ico/dog-100.png" alt="cat_100">
            </span>
          </h2>
        </div>
          <ul>
            <li>
              <div class="ext_list_cat">
                <div class="info_img">
                  <a href="${conPath}/photoBbs/doginfo.jsp?dogname=구름">
                    <img src="${conPath}/img/dog/dog_스피츠_01.jpg" alt="1">
                  </a>
                </div>
                <div class="info_text">
                  <h4>
                    <span>스피츠</span>
                    <p>구름</p>
                  </h4>
                  <p>2023.03월생</p>
                </div>
              </div>
            </li>
            <li>
              <div class="ext_list_cat">
                <div class="info_img">
                  <a href="${conPath}/photoBbs/doginfo.jsp?dogname=초코">
                    <img src="${conPath}/img/dog/dog_시츄_01.jpg" alt="1">
                  </a>
                </div>
                <div class="info_text">
                  <h4>
                    <span>시츄</span>
                    <p>초코</p>
                  </h4>
                  <p>2023.06월생</p>
                </div>
              </div>
            </li>
            <li>
              <div class="ext_list_cat">
                <div class="info_img">
                  <a href="${conPath}/photoBbs/doginfo.jsp?dogname=짜장">
                    <img src="${conPath}/img/dog/dog_포메_01.jpg" alt="1">
                  </a>
                </div>
                <div class="info_text">
                  <h4>
                    <span>포메라니안</span>
                    <p>짜장</p>
                  </h4>
                  <p>2023.06월생</p>
                </div>
              </div>
            </li>
            <li>
              <div class="ext_list_cat">
                <div class="info_img">
                  <a href="가을">
                    <img src="${conPath}/img/dog/dog_포메_02.jpg" alt="1">
                  </a>
                </div>
                <div class="info_text">
                  <h4>
                    <span>포메라니안</span>
                    <p>가을</p>
                  </h4>
                  <p>2023.06월생</p>
                </div>
              </div>
            </li>
          </ul>
          <ul>
            <li>
              <div class="ext_list_cat">
                <div class="info_img">
                  <a href="${conPath}/photoBbs/doginfo.jsp?dogname=모카">
                    <img src="${conPath}/img/dog/dog_푸들_03.jpg" alt="1">
                  </a>
                </div>
                <div class="info_text">
                  <h4>
                    <span>푸들</span>
                    <p>모카</p>
                  </h4>
                  <p>2023.01월생</p>
                </div>
              </div>
            </li>
            <li>
              <div class="ext_list_cat">
                <div class="info_img">
                  <a href="${conPath}/photoBbs/doginfo.jsp?dogname=나리">
                    <img src="${conPath}/img/dog/나리_푸들_02.jpg" alt="1">
                  </a>
                </div>
                <div class="info_text">
                  <h4>
                    <span>푸들</span>
                    <p>나리</p>
                  </h4>
                  <p>2023.01월생</p>
                </div>
              </div>
            </li>
            <li>
              <div class="ext_list_cat">
                <div class="info_img">
                  <a href="${conPath}/photoBbs/doginfo.jsp?dogname=상아">
                    <img src="${conPath}/img/dog/상아_말티즈_01.jpg" alt="1">
                  </a>
                </div>
                <div class="info_text">
                  <h4>
                    <span>푸들</span>
                    <p>상아</p>
                  </h4>
                  <p>2023.01월생</p>
                </div>
              </div>
            </li>
            <li>
              <div class="ext_list_cat">
                <div class="info_img">
                  <a href="${conPath}/photoBbs/doginfo.jsp?dogname=지구">
                    <img src="${conPath}/img/dog/지구_etc_03.jpg" alt="1">
                  </a>
                </div>
                <div class="info_text">
                  <h4>
                    <span>믹스</span>
                    <p>지구</p>
                  </h4>
                  <p>2023.01월생</p>
                </div>
              </div>
            </li>
          </ul>
      </div>
		</div>
	</div>
<br><br>
<jsp:include page="footer.jsp"/>
<script src="${conPath}/js/slide.js"></script>
</body>
</html>





