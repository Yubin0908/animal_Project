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
    <form action="${conPath}/pwChk.do" method="post">
    <input type="hidden" name="id" value="${member.id }" />
      <fieldset>
        <legend style="text-align: center;">(개인정보변경) 비밀번호 확인</legend>
          <p class="item_name" style="text-align: center">비밀번호 입력</p>
          <br />
          <p><input type="password" name="pw" autofocus required></p> 
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