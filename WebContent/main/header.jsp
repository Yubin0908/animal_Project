
<%@ page language="java" contentType="text/html; charset=UTF-8"
				 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="${conPath}/css/header.css" rel="stylesheet">
</head>
<body>
	<div id="header" class="fixed_header">
		<div id="lnb">
			<div class="lnb_left">
				<c:if test="${empty member && empty admin}">
					<ul>
						<li><a href="${conPath}/loginView.do">로그인</a></li>
						<li><a href="${conPath}/joinAgree.do">회원가입</a></li>
						<li><a href="${conPath }/customer.jsp">고객센터</a></li>
					</ul>
				</c:if>
				<ul>
					<li>
						<!-- 회원 로그인 -->
						<c:if test="${not empty member}">
							<c:set var="aname" value="${member.aname}" />
							<c:set var="nickname" value="${member.nickname}" />
							<c:if test="${empty aname}">
								<c:set var="aname" value="멍이랑 & 냥이랑" />
							</c:if>
							<c:if test="${empty nickname}">
								<c:set var="nickname" value="회원" />
							</c:if>
							<a href="#" style="color:#ff3399;">
								<c:choose>
								  <c:when test="${fn:length(aname) >= 5}">
								    ${aname} 네<br> ${nickname} 님 환영합니다!
								  </c:when>
								  <c:otherwise>
								    ${aname} 네 ${nickname}님 환영합니다!
								  </c:otherwise>
								</c:choose>
							</a><br><a href="${conPath}/logout.do" style="margin: 0 20px 0 0;">로그아웃</a><a
										href="${conPath}/modifyPwCheck.do">정보수정</a>
						</c:if>
						<!-- 관리자 로그인 -->
						<c:if test="${not empty admin }">
							<p style="color:#ff3399;">
								${admin.comname}(${admin.comno })님 환영합니다!
								<br />
								관리자로 접속하셨습니다.
								<br><a href="${conPath}/logout.do" style="margin: 0 20px 0 0;">로그아웃</a>	
							</p>					
						</c:if>
					</li>
				</ul>
			</div>
			<div class="logo">
				<a href="${conPath}/main.do"><img src="${conPath}/img/logo/logo_trans.png" alt="logo"></a>
			</div>
			<div class="lnb_right">
				<form action="searchResult.do">
					<input type="text" name="searchKeyword" id="search_box" placeholder="검색어를 입력하세요.">
					<input type="submit" value="" id="search_btn">
				</form>
			</div>
		</div>
		<div id="gnb">
			<div class="gnb_wrap">
				<div class="gnb_menu gnb_about">
					<ul>
						<li><a href="#">멍이랑 냥이랑</a>
							<div class="gnb_depth gnb_depth_01">
								<ul>
									<li><a href="${conPath}/about.do">About</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_pet">
					<ul>
						<li><a href="#">분양 게시판</a>
							<div class="gnb_depth gnb_depth_02">
								<ul>
									<li><a href="${conPath}/petList.do?pettype=강아지">강아지</a></li>
									<li><a href="${conPath}/petList.do?pettype=고양이">고양이</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_review">
					<ul>
						<li><a href="#">고객 게시판</a>
							<div class="gnb_depth gnb_depth_04">
								<ul>
									<li><a href="${conPath}/reviewList.do">고객 리뷰</a></li>
									<li><a href="${conPath}/contactList.do">분양문의 게시판</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_service">
					<ul>
						<li><a href="#">호텔서비스</a>
							<div class="gnb_depth gnb_depth_05">
								<ul>
									<li><a href="${conPath }/hotelService.do">이용 요금</a></li>
									<li><a href="${conPath }/hotelBookingView.jsp">이용 예약</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_system">
					<ul>
						<li><a href="${conPath }/noticeList.do">공지사항</a>
							<c:if test="${not empty admin }">
								<div class="gnb_depth gnb_depth_06">
									<ul>
										<li><a href="${conPath }/noticeWriteView.do">공지사항 등록</a></li>
									</ul>
								</div>
							</c:if>
						</li>
					</ul>
				</div>
				<c:if test="${not empty admin }">
					<div class="gnb_menu gnb_admin">
						<ul>
							<li><a href="#">관리자 메뉴</a>
								<div class="gnb_depth gnb_depth_07">
									<ul>
										<li><a href="${conPath }/memberList.do">회원관리</a></li>
									</ul>
								</div>
							</li>
						</ul>
					</div>
				</c:if>
				
			</div>
		</div>
	</div>
	<script src="${conPath}/js/header.js"></script>
</body>
</html>