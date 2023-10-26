<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="${conPath}/css/main.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script>
    	$(document).ready(function() {
    		$('#go-to-top').click(function(e) {
    			e.stopPropagation();
    			$('html, body').animate({ scrollTop:0}, 'slow', 'easeOutCubic');
    		});
    		$(window).scroll(function() {
    			if($(window).scrollTop()==0) {
    				$('#go-to-top').css('opacity',0);
    			} else {
    				$('#go-to-top').css('opacity',1);
    			}
    		});
    	});
    </script>
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
  <!-- join Msg -->
  <c:if test="${not empty joinResult }">
  	<script>
  		alert('${joinResult}');
  	</script>
  </c:if>
  <!-- 회원탈퇴 Msg -->
  <c:if test="${not empty WithdrawResult }">
	  <script>
	  	alert('${WithdrawResult}');
	  </script>
  </c:if>
  <!-- 회원정보수정 Msg -->
  <c:if test="${not empty modifyMemberResult }">
  	<script>
  		alert('${modifyMemberResult}');
  	</script>
  </c:if>
  <div id="go-to-top">
  	<a href="#"><img src="${conPath }/img/ico/top_arrow.png" alt="위로가기" /></a>
  </div>
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
          <c:if test="${not empty catListMain }">
          	<c:forEach items="${catListMain }" var="cat">
          	<li>
          		<div class="ext_list_cat">
          			<div class="info_img">
          				<a href="${conPath }/contactWriteView.do?petname=${cat.petname}&petbrads=${cat.petbrads}">
          					<img src="${conPath }/serverUploader/${cat.petimg}" alt="${cat.petname }이미지" />
          				</a>
          			</div>
          				<div class="info_text">
          				<h4>
          					<span>${cat.petbrads }</span>
          					<p>${cat.petname }</p>
          				</h4>
          					<p>등록일 : ${cat.petupdate }</p>
          				</div>
          			</div>
          		</li>
          	</c:forEach>
          	</c:if>
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
            <c:if test="${not empty dogListMain }">
          	<c:forEach items="${dogListMain }" var="dog">
          	<li>
          		<div class="ext_list_cat">
          			<div class="info_img">
          				<c:if test="${not empty admin }">
          					<a href="${conPath}/petModify.do?petname=${dog.petname}&pettype=${dog.pettype}">
          						<img src="${conPath }/serverUploader/${dog.petimg}" alt="${dog.petname }이미지" />
          					</a>
          				</c:if>
          				<c:if test="${empty admin }">
          					<a href="contactWriteView.do?petname=${dog.petname}&petbrads=${dog.petbrads}">
          						<img src="${conPath }/serverUploader/${dog.petimg}" alt="${dog.petname }이미지" />
          					</a>
          				</c:if>
          			</div>
          			<div class="info_text">
          				<h4>
          					<span>${dog.petbrads }</span>
          					<p>${dog.petname }</p>
          				</h4>
          					<p>등록일 : ${dog.petupdate }</p>
          				</div>
          			</div>
          		</li>
          	</c:forEach>
          </c:if>
      	</ul>
      </div>
		</div>
<br><br>
<jsp:include page="footer.jsp"/>
<script src="${conPath}/js/slide.js"></script>
</body>
</html>
