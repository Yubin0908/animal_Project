<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${conPath}/css/footer.css">
</head>
<body>
  <footer>
    <br>
    <hr>
    <div id="footer_wrap">
      <div class="logo_f">
        <a href="#"><img src="${conPath}/img/logo/logo_trans.png" alt="logo"></a>
      </div>
      <div class="info">
        <div class="customer">
          <h3>고객센터</h3><h1>02-0000-0000</h1>
          
        </div>
        <div class="info_text_footer">
          <p>운영시간 : AM 09:00 ~ PM 18:00</p>
          <p>주소 : 서울 서대문구 신촌로 00, 동물빌딩 / 사업자등록번호 : 000-00-00000</p>
          <p>동물 판매업 등록번호 : 제 5000000-012-3456-7890 호 / 대표자 : 애니멀</p>
          <p>COPYRIGHTⓒ 2023 DOG & PET. ALL RIGHTS RESERVED. BY ANIMAL</p>
        </div>
        </div>
      <div class="guide">
        <a href="#">개인정보처리방침</a>  <a href="#">이메일무단수집거부</a>
      </div>
    </div>
  </footer>
</body>
</html>