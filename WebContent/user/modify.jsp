<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="${conPath}/css/joinForm.css">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <style>
  	.red {
  		color : red;
  	}
  	.blue {
  		color : blue;
  	}
  </style>
	<script>
  $( function() {
    $( "#datepicker" ).datepicker({
    	dateFormat: "yy-mm-dd",
    	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    	dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토" ],
    	changeMonth: true, changeYear: true,
    	showMonthAfterYear: true,
    	yearSuffix: '년',
    	maxDate : 'y',
    });
  } );
  </script>
</head>
<body>
	<c:if test="${not empty pwChkMsg }">
		<script>
			alert('${pwChkMsg}');
			history.back();
		</script>
	</c:if>
  <jsp:include page="../main/header.jsp"/>
  <br /><br /><br />
  <div id="join_wrap">
    <form action="${conPath}/modifyAccount.do" method="post">
      <fieldset>
        <legend>개인정보변경</legend>
          <p class="item_name">이메일&nbsp;&nbsp;&nbsp;<a id="emailCheckResult"></a></p>
          <p><input type="email" name="email" required value="${member.email }"></p>
          <p class="item_name">전화번호</p>
          <p style="text-align: center"><input type="text" name="loctel" style="width: 100px" placeholder="앞번호" value="${member.loctel }"> - <input type="text" name="midtel" style="width: 100px" placeholder="중간번호" value="${member.midtel }"> - <input type="text" name="lastel" style="width: 100px" placeholder="끝번호" value="${member.lastel }"></p>
      </fieldset>
      <fieldset>
        <legend>선택입력</legend>
          <p class="item_name">주소</p>
          <p><input type="text" name="address" value="${member.address }"/></p>
          <p class="item_name">호칭</p>
          <div class="radio-container">
            <p>
	            <input type="radio" name="nickname" id="radio_1" value="형아"><label for="radio_1" class="label-with-radio">형아</label>
	            <input type="radio" name="nickname" id="radio_2" value="누나"><label for="radio_2" class="label-with-radio">누나</label>
	            <input type="radio" name="nickname" id="radio_3" value="엄마"><label for="radio_3" class="label-with-radio">엄마</label>
	            <input type="radio" name="nickname" id="radio_4" value="아빠"><label for="radio_4" class="label-with-radio">아빠</label>
	            <input type="radio" name="nickname" id="radio_5" value=""><label for="radio_5" class="label-with-radio">기타<input type="text" name="nickname_input" id="nickname_input" disabled value="${member.nickname }"></label>
	            <input type="radio" name="nickname" id="radio_6" value=""><label for="radio_6" class="label-with-radio">선택안함</label>
            </p>
          </div>
      </fieldset>
      <div class="joinForm_submit">
        <input type="submit" value="회원정보수정">
        <input type="reset" value="취소" onclick="location.href='main.do'"/>
        <input type="reset" value="회원탈퇴" onclick="
        																					 var input =	confirm('회원 탈퇴 시 해당아이디로 재가입이 불가합니다. 정말 탈퇴 하시겠습니까?');
        																					 if(input == true) {
        																						 location.href= '${conPath}/withdrawAccount.do';
        																					 }
        																				  "/>
      </div>
    </form>
  </div>
  <br /><br /><br />
  <jsp:include page="../main/footer.jsp"/>
</body>
</html>

<script>

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
