<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	  * {
	    margin: 0;
	    padding: 0;
	    box-sizing: border-box;
	  }
	
	  body {
	    background-color: #f9f9f9;
	    font-family: Arial, sans-serif;
	  }
	
	  #search_wrap {
	    width: 100%;
	    text-align: center;
	    padding: 20px;
	  }
	
	  .result_view {
	    width: 100%;
	    max-width: 1000px;
	    background-color: #fff;
	    margin: 0 auto;
	    padding: 20px;
	    border-radius: 10px;
	    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	  }
	
	  .title {
	    font-weight: 700;
	    font-size: 2em;
	    margin-bottom: 20px;
	  }
	
	  .content_line {
	    border-bottom: 1px solid #ddd;
	    margin: 10px 0;
	  }
	
	  .result_info {
	    display: flex;
	    align-items: center;
	    padding: 20px 0;
	  }
	
	  .result_info img {
	    width: 130px;
	    height: 130px;
	    border-radius: 50%;
	    object-fit: cover;
	    margin-right: 20px;
	  }
	
	  .petname {
	    font-weight: 600;
	    font-size: 1.2em;
	    color: #000;
	  }
	
	  .petbrads {
	    font-size: 1.1em;
	    color: #000;
	  }
	
	  .date {
	    font-size: 1em;
	    color: #000;
	  }
	</style>

</head>
<body>
<jsp:include page="header.jsp" />
	<div id="search_wrap">
    <div class="result_view">
    	<p class="title">${param.searchKeyword }&nbsp;검색결과</p>
      <p class="content_line"></p>
      <c:if test="${empty searchResult }">검색결과가 존재하지 않습니다.</c:if>
      <c:forEach items="${searchResult }" var="s">
      	<c:if test="${not empty searchResultNull }">
      		<p>${searchResultNull }</p>
      		<script>
      			alert('${searchResultNull}');
      		</script>
      	</c:if>
      	<div class="result_info">
	        <img src="${conPath }/serverUploader/${s.petimg}" alt="검색결과 이미지">
	        <p class="petname">이름 : ${s.petname }</p>&nbsp;&nbsp;&nbsp;
	        <p class="petbrads">종류 : ${s.petbrads }</p>&nbsp;&nbsp;&nbsp;
	        <p class="date">등록일자 : ${s.petupdate }</p>&nbsp;&nbsp;&nbsp;
   	 		</div>
   	 		<p class="content_line"></p>
      </c:forEach>
    </div>
  </div>
<jsp:include page="footer.jsp" />
</body>
</html>