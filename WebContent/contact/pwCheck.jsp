<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${conPath }/css/joinForm.css" />
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<br /><br />
<div id="join_wrap">
    
    <form action="${conPath}/contact.do" method="post">
    <input type="hidden" name="cid" value="${param.cid }" />
      <fieldset>
        <legend style="text-align: center;">(게시물 상세보기) 비밀번호 확인</legend>
          <p class="item_name" style="text-align: center">비밀번호 입력</p>
          <br />
          <c:if test="${not empty admin }">
    				<p><input type="password" name="cpw" value="${param.cpw }" autofocus required></p> 
   				</c:if>
          <c:if test="${empty admin }">
          	<p><input type="password" name="cpw" value="" autofocus required></p> 
          </c:if>
          
          <br />
	      <div class="joinForm_submit">
	        <input type="submit" value="확인">
	      </div>
      </fieldset>
    </form>
  </div>
	<br /><br />	
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<script>
	history.replaceState({}, null, location.pathname);
</script>