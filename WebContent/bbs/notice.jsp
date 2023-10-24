<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>Mong - Meow Review</title>
    <link rel="stylesheet" href="${conPath}/css/review.css">
</head>
<body>
<jsp:include page="../main/header.jsp"/>
		<div id="sub_title">
		  <p class="desc">공지사항</p>
		  <h1 class="title">NEW NOTICE</h1>
		</div>
    <div id="review_wrap">
	    <table class="review_table">
	     <colgroup>
	      <col class="col_w">
	      <col width="*">
	     </colgroup>
	     <tr>
	      <td class="review_header">
	        <p class="title">${notice.ntitle }</p>
	        <p class="info">관리자 | <span class="date">${notice.ndate }</span></p>
	      </td>
	     </tr>
	     <tr>
	      <td class="content" colspan="2" style="text-align: center;">
	        <c:if test="${not empty notice.nimg }">
	         	<img src="${conPath }/serverUploader/${notice.nimg}" alt="공지사항 이미지" class="공지사항 이미지" />
	        </c:if>
	        <c:if test="${empty notice.nimg }">
	        	<img src="${conPath }/img/logo/logo_trans.png" alt="" />
	        </c:if>
	        <div class="review-text">${notice.ntext }</div>
	      </td>
	     </tr>
	    </table>
	    <div class="review_btn_div">
	     	<a href="${conPath }/noticeList.do?pageNum=${param.pageNum}" class="btn-back">목록</a>
	      <c:if test="${not empty admin }">
	      	<a href="${conPath }/noticeModifyView.do?pageNum=${param.pageNum}&nid=${notice.nid}" class="btn-back">수정</a>
	      	<a href="${conPath }/noticeDelete.do?pageNum=${param.pageNum}&nid=${notice.nid}" class="btn-back">삭제</a>
	      </c:if>
	     </div>
    </div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>