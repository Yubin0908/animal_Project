<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/login.css" rel="stylesheet">
	<link href="${conPath}/css/common.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../main/header.jsp" />
	
  <br>
  <div id="login_wrap">
    <form action="${conPath }/login.do" method="post" id="frm" name="frm">
      <div class="login_title">
        <p class="desc">로그인</p>
        <p class="login_sub_title bold">MEMBER LOGIN</p>
      </div>
      <div class="login_form">
        <div class="login_form_id">
          <p>아이디</p>
          <input type="text" name="id" id="id" placeholder="아이디">
        </div>
        <div class="login_form_pw">
          <p>비밀번호</p>
          <input type="password" name="pw" id="pw" placeholder="비밀번호">
        </div>
      </div>
      <div class="id_save">
        <input type="checkbox" name="save_id" id="save_id" value="ok">
        <label for="save_id">
          <input type="checkbox" style="display:none;">
          아이디 저장
        </label>
      </div>
      <div class="member_find">
        <a href="${conPath}/findAccountid.do">아이디/비밀번호 찾기</a>
      </div>
      <div class="login_submit">
        <input type="submit" value="로그인" id="lg_submit">
      </div>
      <div class="login_join">
        <input type="button" value="회원가입" onclick="location.href='${conPath}/joinAgree.do'">
      </div>
    </form>
  </div>
    <br>

<jsp:include page="../main/footer.jsp"/>
</body>
</html>