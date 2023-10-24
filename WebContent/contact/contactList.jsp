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
<c:if test="${not empty modifyContactResult }">
	<script>
		alert('${modifyContactResult}');
	</script>
</c:if>
<c:if test="${not empty replyResult }">
	<script>
		alert('${replyResult}');
	</script>
</c:if>
<jsp:include page="../main/header.jsp"/>
	<c:if test="${not empty ContactResult }">
		<script>
			alert('${ContactResult}');
		</script>
	</c:if>
	<div id="sub-title">
    <p class="desc">분양 문의 게시판</p>
  </div>
  <div id="bbs_wrap">
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
      	<th>상태</th>
      </tr>
      <c:forEach items="${contactList }" var="contact">
      	<tr>
      		<td>${contact.cid }</td>
      		<td>
      			<c:forEach var="i" begin="1" end="${contact.cindent }">
								<c:if test="${i eq contact.cindent }">└─</c:if>
								<c:if test="${i ne contact.cindent }"> &nbsp;&nbsp;</c:if>
							</c:forEach>
							<a href="${conPath }/contactPw.do?cid=${contact.cid}&cpw=${contact.cpw}&pageNum=${pageNum}">${contact.ctitle }</a>
      		</td>
      		<td>${contact.cwriter }</td>
      		<td>${contact.cdate }</td>
      		<td>
      			<c:if test="${contact.cdata_status eq 1 }"><b class="status_block">답변 대기중</b></c:if>
      			<c:if test="${contact.cdata_status eq 2 }"><b class="status_block">답변 완료</b></c:if>
      			<c:if test="${contact.cdata_status eq 3 }"><b class="status_block">${contact.cgroup}번 답변</b></c:if>
      		</td>
      	</tr>
      </c:forEach>
  	</table>
  </div>
  <div class="paging">
	  <c:if test="${startPage > BLOCKSIZE }">
	    <a href="${conPath }/contactList.do?pageNum=${startPage-BLOCKSIZE}">
	      <img src="${conPath }/img/ico/left_arrow_1.png" alt="이전 화살표" />
	    </a>
	  </c:if>
	  <c:forEach var="i" begin="${startPage }" end="${endPage }">
	    <c:choose>
	      <c:when test="${i == pageNum}">
	        <b> [ ${i } ]&nbsp;</b>
	      </c:when>
	      <c:otherwise>
	        [ <a href="${conPath }/contactList.do?pageNum=${i}">${i }</a> ]&nbsp;
	      </c:otherwise>
	    </c:choose>
	  </c:forEach>
	  <c:if test="${endPage < page }">
	    <a href="${conPath }/contactList.do?pageNum=${endPage+1}">
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
