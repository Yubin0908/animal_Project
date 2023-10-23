<%@ page language="java" contentType="text/html; charset=UTF-8"
				 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" href="${conPath}/css/bbs.css">
</head>
<body>
	<c:if test="${not empty ReviewAddResult }">
		<script>
			alert('${ReviewAddResult}');
		</script>
	</c:if>
<jsp:include page="../main/header.jsp" />
	<div id="sub-title">
    <p class="desc">고객 리뷰 게시판</p>
  </div>
  <div id="bbs_wrap">
  	<button onclick="location.href='${conPath}/reviewWriteView.do'" class="btn-write">리뷰 작성</button>
  	<table class="bbs_table">
  		<colgroup>
        <col width="10%">
        <col width="+%">
        <col width="12%">
        <col width="15%">
        <col width="15%">
      </colgroup>
      <tr>
      	<th>번호</th>
      	<th>제목</th>
      	<th>작성자</th>
      	<th>작성일</th>
      	<th>첨부파일</th>
      </tr>
      <c:forEach items="${reviewList }" var="review">
      	<tr>
      		<td>${review.rid }</td>
      		<td>
      			<a href="${conPath }/review.do?rid=${review.rid}&pageNum=${pageNum}">${review.rtitle }</a>
      		</td>
      		<td>${review.name }</td>
      		<td>${review.rdate }</td>
      		<td>
      			<c:if test="${empty review.rimg }">
      				없음
      			</c:if>
      			<c:if test="${not empty review.rimg }">
      				<img src="${conPath }/img/ico/image-con.png" alt="이미지 첨부 아이콘" style="width:20px; height:20px;"/>
      			</c:if>
      		</td>
      	</tr>
      </c:forEach>
  	</table>
  </div>
  <div class="paging">
	  <c:if test="${startPage > BLOCKSIZE }">
	    <a href="${conPath }/reviewList.do?pageNum=${startPage-BLOCKSIZE}">
	      <img src="${conPath }/img/ico/left_arrow_1.png" alt="이전 화살표" />
	    </a>
	  </c:if>
	  <c:forEach var="i" begin="${startPage }" end="${endPage }">
	    <c:choose>
	      <c:when test="${i == pageNum}">
	        <b> [ ${i } ]&nbsp;</b>
	      </c:when>
	      <c:otherwise>
	        [ <a href="${conPath }/reviewList.do?pageNum=${i}">${i }</a> ]&nbsp;
	      </c:otherwise>
	    </c:choose>
	  </c:forEach>
	  <c:if test="${endPage < page }">
	    <a href="${conPath }/reviewList.do?pageNum=${endPage+1}">
	      <img src="${conPath }/img/ico/right_arrow_1.png" alt="다음 화살표" />
	    </a>
	  </c:if>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<!-- <script>
	history.replaceState({}, null, location.pathname);
</script> -->
