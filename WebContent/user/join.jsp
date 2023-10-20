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
  	$(function() { // ID 8 ~ 20 자리
  		$('input[name="id"]').keyup(function() {
  			var id = $(this).val();
  			if(id.length < 8 || id.length > 20) {
  				$('#idConfirmResult').text('ID는 8~20자리 이내로 입력해주세요.');
  				$('.item_name > #idConfirmResult').addClass('red');
  				$('.item_name > #idConfirmResult').removeClass('blue');
  			} else {
  				$('.item_name > #idConfirmResult').addClass('blue');
  				$('.item_name > #idConfirmResult').removeClass('red');
  				$.ajax({
  					url : '${conPath}/idConfirm.do',
  					type : 'get',
  					data : 'id='+id,
  					dataType : 'html',
  					success : function(data) {
  						$('#idConfirmResult').html(data);
  					},
  				});
  			}
  		});
  		$('input[name="pw"], input[name="pwchk"]').keyup(function() {
  			var pw = $('input[name="pw"]').val();
  			var pwchk = $('input[name="pwchk"]').val();
  			if(pw.length < 8 || pw.length > 20) {
  				$('#pwCheckResult').text('비밀번호는 8~20자리 이내로 입력하세요.');
  				$('.item_name > #pwCheckResult').addClass('red');
  				$('.item_name > #pwCheckResult').removeClass('blue');
  			} else {
  				if(pw == pwchk) {
  	  				$('#pwCheckResult').text('비밀번호가 일치합니다.');
  	  				$('.item_name > #pwCheckResult').addClass('blue');
  	  				$('.item_name > #pwCheckResult').removeClass('red');
  	  			} else {
  	  				$('#pwCheckResult').text('비밀번호가 일치하지 않습니다.');
  	  				$('.item_name > #pwCheckResult').addClass('red');
  	  				$('.item_name > #pwCheckResult').removeClass('blue');
  	  			}
  			}
  		});
  		var email_p = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
  		$('input[name="email"]').keyup(function() {
  			var email = $(this).val();
  			if(!email.match(email_p)) {
  				$('#emailCheckResult').text('메일 형식이 올바르지 않습니다.');
  				$('.item_name > #emailCheckResult').addClass('red');
  				$('.item_name > #emailCheckResult').removeClass('blue');
  			} else {
  				$('#emailCheckResult').html('&nbsp;');
  			}
  		});
  		$()
  		$('form').submit(function() {
  			var idResult = $('#idConfirmResult').text().trim();
  			var pwResult = $('#pwCheckResult').text().trim();
  			if(idResult != '사용 가능한 ID 입니다.') {
  				alert('중복된 아이디로 가입이 불가합니다.');
  				$('input[name="id"]').focus();
  				return false();
  			} else if(pwResult != '비밀번호가 일치합니다.') {
  				alert('비밀번호를 확인하세요.');
  				$('input[name="pw"]').focus();
  				return false();
  			}
  		});
  	});
  </script>
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
  <jsp:include page="../main/header.jsp"/>
  <div id="join_wrap">
    <form action="${conPath}/join.do" method="post">
      <fieldset>
        <legend>필수입력</legend>
          <p class="item_name">아이디&nbsp;&nbsp;&nbsp;<a id="idConfirmResult"></a></p>
          <p><input type="text" name="id" autofocus required></p>
          <p class="item_name">비밀번호</p>
          <p><input type="password" name="pw" required></p>
          <p class="item_name">비밀번호 확인&nbsp;&nbsp;&nbsp;<a id="pwCheckResult"></a></p>
          <p><input type="password" name="pwchk" required></p>
          <p class="item_name">이름</p>
          <p><input type="text" name="name" required></p>
          <p class="item_name">이메일&nbsp;&nbsp;&nbsp;<a id="emailCheckResult"></a></p>
          <p><input type="email" name="email" required></p>
          <p class="item_name">전화번호</p>
          <p style="text-align: center"><input type="text" name="loctel" style="width: 100px" placeholder="앞번호"> - <input type="text" name="midtel" style="width: 100px" placeholder="중간번호"> - <input type="text" name="lastel" style="width: 100px" placeholder="끝번호"></p>
      </fieldset>
      <fieldset>
        <legend>선택입력</legend>
          <p class="item_name">주소</p>
          <p><input type="text" name="address"/></p>
          <p class="item_name">호칭</p>
          <div class="radio-container">
            <p>
              <input type="radio" name="nickname" id="radio_1" value="형아"><label for="radio_1" class="label-with-radio">형아</label>
              <input type="radio" name="nickname" id="radio_2" value="누나"><label for="radio_2" class="label-with-radio">누나</label>
              <input type="radio" name="nickname" id="radio_3" value="엄마"><label for="radio_3" class="label-with-radio">엄마</label>
              <input type="radio" name="nickname" id="radio_4" value="아빠"><label for="radio_4" class="label-with-radio">아빠</label>
              <input type="radio" name="nickname" id="radio_5" value=""><label for="radio_5" class="label-with-radio">기타<input type="text" name="nickname_input" id="nickname_input" disabled></label>
              <input type="radio" name="nickname" id="radio_6" value="" checked><label for="radio_6" class="label-with-radio">선택안함</label>
            </p>
          </div>
      </fieldset>
      <fieldset>
        <legend>반려동물 정보입력</legend>
        <p class="item_name">반려동물 이름</p>
        <p><input type="text" name="aname"></p>
        <p class="item_name">반려동물 생일</p>
        <p><input type="text" name="adate" id="datepicker"></p>
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