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
        <c:if test="${param.cdata_status eq 1 }">
        	<legend style="text-align: center;">(문의글 상세보기) 비밀번호 확인</legend>
        </c:if>
        <c:if test="${param.cdata_status eq 3 }">
        	<legend style="text-align: center;">(답변글 상세보기) 비밀번호 확인</legend>
        </c:if>
          <p class="item_name" style="text-align: center">비밀번호 입력</p>
          <br />
          <c:if test="${not empty admin }">
    				<p><input type="password" name="cpw" value="${param.cpw }" autofocus required></p> 
   				</c:if>
          <c:if test="${empty admin }">
          	<p><input type="password" name="cpw" value="" autofocus required></p> 
          	<c:if test="${param.cdata_status eq 3 }">
    					<p style="color:red; font-weight: 700; font-size: 13px; text-align: center;">답변글 비밀번호는 고객님이 문의하실때 등록한 비밀번호와 같습니다.</p>
    				</c:if>
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