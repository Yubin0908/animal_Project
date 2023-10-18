
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
				<c:if test="${empty member}">
					<ul>
						<li><a href="${conPath}/loginView.do">로그인</a></li>
						<li><a href="${conPath}/joinView.do">회원가입</a></li>
						<li><a href="${conPath}/sub/custom.jsp">고객센터</a></li>
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
										${aname} 네<br> ${nickname}
									</c:when>
									<c:otherwise>
										${aname} 네 ${nickname}님 환영합니다!
									</c:otherwise>
								</c:choose>
							</a><br><a href="${conPath}/logout.do" style="margin: 0 20px 0 0;">로그아웃</a><a
										href="${conPath}/sub/memberConfirm.jsp">정보수정</a>
						</c:if>
						<!-- 관리자 로그인 -->
						<c:if test="${not empty admin }">
							${comname}(${comno })님 환영합니다!
							관리자로 접속하셨습니다.
						</c:if>
					</li>
				</ul>
			</div>
			<div class="logo">
				<a href="${conPath}/main/main.jsp"><img src="${conPath}/img/logo/logo_trans.png" alt="logo"></a>
			</div>
			<div class="lnb_right">
				<form>
					<input type="text" name="search">
					<input type="submit" value="">
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
									<li><a href="${conPath}/sub/about.jsp">About</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_dog">
					<ul>
						<li><a href="#">강아지</a>
							<div class="gnb_depth gnb_depth_02">
								<ul>
									<li><a href="${conPath}/photoBbs/dog_all.jsp">전체 보기</a></li>
									<li><a href="${conPath}/dog_type.jsp">견종별 보기</a></li>
									<li><a href="${conPath}/dog_loc.jsp">지점별 보기</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_cat">
					<ul>
						<li><a href="#">고양이</a>
							<div class="gnb_depth gnb_depth_03">
								<ul>
									<li><a href="${conPath}/photoBbs/cat_all.jsp">전체 보기</a></li>
									<li><a href="${conPath}/cat_type.jsp">묘종별 보기</a></li>
									<li><a href="${conPath}/cat_loc.jsp">지점별 보기</a></li>
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
									<li><a href="${conPath}/interview.jsp">가족 인터뷰</a></li>
									<li><a href="${conPath}/review.jsp">가족 리뷰</a></li>
									<li><a href="${conPath}/textBbs/contact.jsp">분양문의 게시판</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_service">
					<ul>
						<li><a href="#">service</a>
							<div class="gnb_depth gnb_depth_05">
								<ul>
									<li><a href="${conPath}/cat_hotel.jsp">고양이 호텔</a></li>
									<li><a href="${conPath}/dog_hotel.jsp">강아지 호텔</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
				<div class="gnb_menu gnb_system">
					<ul>
						<li><a href="#">system</a>
							<div class="gnb_depth gnb_depth_06">
								<ul>
									<li><a href="${conPath}/notice.jsp">공지사항</a></li>
									<li><a href="${conPath}/before.jsp">사전점검 서비스</a></li>
									<li><a href="${conPath}/sales.jsp">협력업체</a></li>
									<li><a href="${conPath}/after.jsp">사후 서비스</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script src="${conPath}/js/header.js"></script>
</body>
</html>