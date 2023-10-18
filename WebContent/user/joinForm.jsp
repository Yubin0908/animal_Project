<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="${conPath}/css/joinForm.css">
  
</head>
<body>
    <jsp:include page="../main/header.jsp"/>
  <div id="join_wrap">
    <form action="${conPath}/action/joinAction.jsp" method="post">
      <fieldset>
        <legend>필수입력</legend>
          <p class="item_name">아이디</p>
          <p><input type="text" name="id" autofocus required></p>
          <p class="item_name">비밀번호</p>
          <p><input type="password" name="pw" required></p>
          <p class="item_name">비밀번호 확인</p>
          <p><input type="password" name="pwchk" required></p>
          <p class="item_name">이름</p>
          <p><input type="text" name="name" required></p>
          <p class="item_name">이메일</p>
          <p><input type="email" name="email" required></p>
      </fieldset>
      <fieldset>
        <legend>선택입력</legend>
          <p class="item_name">전화번호</p>
          <p><input type="text" name="tel"></p>
          <p class="item_name">호칭</p>
          <div class="radio-container">
            <p>
              <input type="radio" name="nickname" id="radio_1" value="형아"><label for="radio_1" class="label-with-radio">형아</label>
              <input type="radio" name="nickname" id="radio_2" value="누나"><label for="radio_2" class="label-with-radio">누나</label>
              <input type="radio" name="nickname" id="radio_3" value="엄마"><label for="radio_3" class="label-with-radio">엄마</label>
              <input type="radio" name="nickname" id="radio_4" value="아빠"><label for="radio_4" class="label-with-radio">아빠</label>
              <input type="radio" name="nickname" id="radio_5" value="" checked><label for="radio_5" class="label-with-radio">기타<input type="text" name="nickname_input" id="nickname_input" disabled></label>
            </p>
          </div>
      </fieldset>
      <fieldset>
        <legend>반려동물 정보입력</legend>
        <p class="item_name">반려동물 종류</p>
        <div class="checkbox-container">
          <p>
            <input type="checkbox" name="atype" id="dog"><label for="dog" class="label-with-checkbox">강아지</label>
            <input type="checkbox" name="atype" id="cat"><label for="cat" class="label-with-checkbox">고양이</label>
          </p>
        </div>
        <p class="item_name">반려동물 이름</p>
        <p><input type="text" name="aname"></p>
        <p class="item_name">반려동물 생일</p>
        <p><input type="date" name="tempbirth"></p>
      </fieldset>
      <div class="joinForm_submit">
        <input type="submit" value="회원가입">
      </div>
      
    </form>
  </div>
  <jsp:include page="../main/footer.jsp"/>
</body>
</html>

<script>
  // JavaScript 코드
  var radioButtons = document.querySelectorAll('input[name="nickname"]');
  var input = document.getElementById("nickname_input");
  
  // 라디오 버튼의 변경 시 텍스트 입력 필드 활성화/비활성화 및 값을 설정
  radioButtons.forEach(function(radio) {
    radio.addEventListener("change", function() {
      if (radio.id === "radio_5") {
        input.removeAttribute("disabled");
      } else {
        input.setAttribute("disabled", "disabled");
        input.value = "";
      }
    });
  });
  
  // 텍스트 입력 필드의 값이 변경될 때 선택된 라디오 버튼의 값을 업데이트
  input.addEventListener("input", function() {
    var selectedRadio = document.querySelector('input[name="nickname"]:checked');
    if (selectedRadio && selectedRadio.id === "radio_5") {
      selectedRadio.value = input.value;
    }
  });
</script>