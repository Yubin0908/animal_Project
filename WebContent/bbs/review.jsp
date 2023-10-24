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
        <p class="desc">멍이랑 냥이랑 고객리뷰</p>
        <h1 class="title">Mong - Meow Review</h1>
    </div>
    <div id="review_wrap">
	    <table class="review_table">
	     <colgroup>
	         <col class="col_w">
	         <col width="*">
	     </colgroup>
	     <tr>
	      <td class="review_header">
	          <p class="title">${review.rtitle }</p>
	          <p class="info">${review.name } | <span class="date">${review.rdate }</span></p>
	      </td>
	     </tr>
	     <tr>
	      <td class="content" colspan="2" style="text-align: center;">
	          <c:if test="${not empty review.rimg }">
	              <img src="${conPath }/serverUploader/${review.rimg}" alt="고객 리뷰 이미지" class="review-img" />
	          </c:if>
	          <p class="review-text">${review.rtext }</p>
	      </td>
	     </tr>
	    </table>
	    <div class="review_btn_div">
	     	<a href="${conPath }/reviewList.do?pageNum=${param.pageNum}" class="btn-back">목록</a>
	      <c:if test="${member.id eq review.id }">
	      	<a href="${conPath }/reviewModifyView.do?pageNum=${param.pageNum}&rid=${review.rid}" class="btn-back">수정</a>
	      	<a href="${conPath }/reviewDelete.do?pageNum=${param.pageNum}&rid=${review.rid}" class="btn-back">삭제</a>
	      </c:if>
	     </div>
    </div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>