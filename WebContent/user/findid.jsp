<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${conPath }/css/login.css" />
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<br /><br /><br />
	<c:if test="${not empty findIdResult }">
		<script>
			alert('${findIdResult}');
		</script>
	</c:if>
	<div id="login_wrap">
    <div class="login_title">
      <p class="desc">아이디/비밀번호 찾기</p>
      <p class="login_sub_title bold">FIND YOUR ID </p>
    </div>
    <form action="${conPath }/findid.do" method="post">
      <div class="login_form_id">
        <p>이름</p>
        <input type="text" name="name" id="name" placeholder="가입 시 등록한 이름" required>
        <br />
       </div>
       <div class="login_form_id">
	       <p>이메일</p>
	       <input type="text" name="email" id="email" placeholder="가입 시 등록한 이메일" required>     
      </div>
      <div class="member_find">
        <a href="${conPath }/findAccountpw.do">비밀번호를 잊으셨나요?</a>
      </div>
      <div class="login_submit">
        <input type="submit" value="찾기" id="lg_submit">
      </div>
      <div class="login_join">
        <input type="button" value="뒤로 가기" onclick="history.back()">
      </div>
    </form>
  </div>
  <br /><br /><br />
  <jsp:include page="../main/footer.jsp"/>
</body>
</html>