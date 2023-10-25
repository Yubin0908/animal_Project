<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${conPath }/css/cardBbs.css" />
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<c:if test="${not empty PetAddResult }">
		<script>
			alert('${PetAddResult}');
		</script>
	</c:if>
	<c:if test="${not empty petDeleteResult }">
		<script>
			alert('${petDeleteResult}');
		</script>
	</c:if>
	<c:if test="${empty admin }">
		<c:if test="${pettype eq '강아지' }">
			<div id="pet_filter">
				<div class="filter_menu">
					<div class="sub-title">
						<p>우리집 강아지는 어디에 있을까?</p>
					</div>
					<a href="${conPath }/petList.do?pettype=${pettype}">전체보기</a> 
					<a href="${conPath }/petList.do?petbrads=푸들&pettype=${pettype}">푸들</a> 
					<a href="${conPath }/petList.do?petbrads=말티즈&pettype=${pettype}">말티즈</a> 
					<a href="${conPath }/petList.do?petbrads=미니비숑&pettype=${pettype}">미니비숑</a>
					<a href="${conPath }/petList.do?petbrads=비숑&pettype=${pettype}">비숑</a>  
					<a href="${conPath }/petList.do?petbrads=보더콜리&pettype=${pettype}">보더콜리</a> 
					<a href="${conPath }/petList.do?petbrads=포메라니안&pettype=${pettype}">포메라니안</a> 
					<a href="${conPath }/petList.do?petbrads=폼피츠&pettype=${pettype}">폼피츠</a> 
					<a href="${conPath }/petList.do?petbrads=기타&pettype=${pettype}">특수견</a> 
				</div>
			</div>
		</c:if>
		<c:if test="${pettype eq '고양이' }">
			<div id="pet_filter">
				<div class="filter_menu">
					<div class="sub-title">
						<p>우리집 고양이는 어디에 있을까?</p>
					</div>
					<a href="${conPath }/petList.do?pettype=${pettype}">전체보기</a> 
					<a href="${conPath }/petList.do?petbrads=노르웨이숲&pettype=${pettype}">노르웨이숲</a> 
					<a href="${conPath }/petList.do?petbrads=브리티쉬&pettype=${pettype}">브리티쉬</a> 
					<a href="${conPath }/petList.do?petbrads=랙돌&pettype=${pettype}">랙돌</a> 
					<a href="${conPath }/petList.do?petbrads=러시안블루&pettype=${pettype}">러시안블루</a> 
					<a href="${conPath }/petList.do?petbrads=먼치킨&pettype=${pettype}">먼치킨</a> 
					<a href="${conPath }/petList.do?petbrads=메인쿤&pettype=${pettype}">메인쿤</a> 
					<a href="${conPath }/petList.do?petbrads=뱅갈&pettype=${pettype}">뱅갈</a> 
					<a href="${conPath }/petList.do?petbrads=기타&pettype=${pettype}">특수묘</a> 
				</div>
			</div>
		</c:if>
	</c:if>
	<c:if test="${not empty admin }">
		<div id="pet_filter">
				<div class="filter_menu">
					<div class="admin_menu">
						<div class="sub_title">
							<p>등록현황</p>
						</div>
							<p>※ 등록 수량 : ${cnt }</p>
							<br />
							<a href="${conPath }/petAddView.do">분양 등록</a>
					</div>
				</div>
			</div>
	</c:if>
	<div id="card_wrap">
		<c:forEach items="${listPet}" var="pet">
	    <div class="card">
	      <img src="${conPath}/serverUploader/${pet.petimg}" alt="${pet.petname }이미지">
	      <h2>[${pet.petbrads}]&nbsp;&nbsp;${pet.petname}</h2>
	      <p>나이 : ${pet.petage }</p>
	      <p>책임분양가 : ${pet.petprice }</p>
	      <c:if test="${empty admin}">
	      	<a href="${conPath}/contactWriteView.do?petname=${pet.petname}&petbrads=${pet.petbrads}">분양 문의</a>
	      </c:if>
	      <c:if test="${not empty admin }">
	      	<br />
	      	<p>
	      		<a href="${conPath}/petModifyView.do?petid=${pet.petid}" style="width:50px; background-color: #ff3399; padding: 10px 30px; border-radius: 20px;" >수정</a>
	      		<a href="${conPath}/petDelete.do?petid=${pet.petid}&pettype=${pet.pettype}" style="width:50px; background-color: #ff3399; padding: 10px 30px; border-radius: 20px;">삭제</a>
	      	</p>
	      	
	      </c:if>
	    </div>
	  </c:forEach>
	 	<br />
  </div>
 	<div class="paging">
  	<c:if test="${startPage > BLOCKSIZE }">
 			<a href="${conPath }/petList.do?pettype=${pettype}&pageNum=${startPage-1}">
 				<img src="${conPath }/img/ico/left_arrow_1.png" alt="이전 화살표" />
 			</a>
 		</c:if>
 		<c:forEach var="i" begin="${startPage }" end="${endPage }">
 			<c:if test="${i == pageNum }">
 				<b> [ ${i } ]&nbsp;</b>
 			</c:if>
 			<c:if test="${i != pageNum }">
 				[ <a href="${conPath }/petList.do?pettype=${pettype }&pageNum=${i}">${i }</a> ]&nbsp;  
 			</c:if>
 		</c:forEach>
 		<c:if test="${endPage < cnt }">
 			<a href="${conPath }/petList.do?pettype=${pettype}&pageNum=${endPage+1}">
 				<img src="${conPath }/img/ico/right_arrow_1.png" alt="다음 화살표" />
 			</a>
 		</c:if>
  </div>
  	
  	
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>