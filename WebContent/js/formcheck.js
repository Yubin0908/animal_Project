// login & signin Form pattern check 정규표현식
// pattern
var id_p = /^[a-z0-9]{4,12}$/; // 4~12자리 수
var pw_p =/^[A-Za-z0-9]{8,20}$/; // 8~20자리 수
var name_p = /^[가-힣]{2,6}$/; // 2~6자리 수
var email_p = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; // 특수문자 ._ 사용가능
var tel_p = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;

// 유효성 체크
$("#id").blur( function() {
  if(id_p.test($(this).val())) {
    console.log(id_p.test($(this).val()));
    $("#id_check").text('');
  } else {
    $('#id_check').text('아이디가 올바르지 않습니다.');
    $('#id_check').css('color', 'red');
  }
});