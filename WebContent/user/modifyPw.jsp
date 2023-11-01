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
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<style>
  	.red {
  		color : red;
  	}
  	.blue {
  		color : blue;
  	}
  </style>
  <script>
  	$(function() {
  		$('input[name="pw"], input[name="pwchk"]').keyup(function() {
  			var pw = $('input[name="pw"]').val();
  			var pwchk = $('input[name="pwChk"]').val();
  			if(pw.length < 8 || pw.length > 20) {
  				$('#pwCheckResult').text('비밀번호는 8~20자리 이내로 입력하세요.');
  				$('.item_name > #pwCheckResult').addClass('red');
  				$('.item_name > #pwCheckResult').removeClass('blue');
  			} else {
  				if(pw == pwchk) {
  	  				$('#pwCheckResult').text('비밀번호가 일치합니다.');
  	  				$('#pwCheckResult').addClass('blue');
  	  				$('#pwCheckResult').removeClass('red');
  	  			} else {
  	  				$('#pwCheckResult').text('비밀번호가 일치하지 않습니다.');
  	  				$('#pwCheckResult').addClass('red');
  	  				$('#pwCheckResult').removeClass('blue');
  	  			}
  			}
  		});
  	});
  </script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<br /><br />
<div id="join_wrap">
    <form action="${conPath}/modifyPw.do" method="post">
    <input type="hidden" name="id" value="${member.id }" />
      <fieldset>
        <legend style="text-align: center;">변경할 비밀번호 입력</legend>
          <p class="item_name" style="text-align: center">새 비밀번호 입력</p>
          <br />
          <p><input type="password" name="pw" autofocus required></p> 
          <br />
          <p class="item_name" style="text-align: center">새 비밀번호 확인</p>
          <br />
          <p><input type="password" name="pwChk" autofocus required></p> 
          <p id="pwCheckResult" class=""></p>
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