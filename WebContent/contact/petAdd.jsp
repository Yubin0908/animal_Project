<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<style>
		body {
			background-color: #fff3e6;
			font-family: Arial, sans-serif;
		}

		#petadd_wrap {
			max-width: 600px;
			margin: 0 auto;
			padding: 20px;
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
			text-align: center;
		}

		table {
			width: 100%;
			border-collapse: collapse;
			text-align: left;
		}

		table td {
			padding: 10px;
		}

		input[type="text"],
		textarea {
			width: 100%;
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 5px;
			margin-bottom: 10px;
		}

		#petadd_wrap input[type="submit"] {
			background-color: #ff3399;
			color: #fff;
			padding: 10px 20px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
			transition: background-color 0.3s ease;
		}

		#petadd_wrap input[type="submit"]:hover {
			background-color: #ff66b2;
		}

		.nosize {
			resize: none;
		}

		.petname_in {
			font-size: 1.2rem;
			color: #ff3399;
			font-weight: bold;
		}

		#petadd_wrap input[type="file"] {
			display: none;
		}

		.file-label {
			background-color: #ff3399;
			color: #fff;
			padding: 10px 20px;
			border-radius: 5px;
			cursor: pointer;
			transition: background-color 0.3s ease;
		}

		.file-label:hover {
			background-color: #ff66b2;
		}

		.file-label::before {
			content: "이미지 등록";
		}

		#file {
			margin: 10px 0;
		}
	</style>
	<script>
		$(function() {
			$('input[name="pettype"]').click(function() {
				var radio_select = $('input[name="pettype"]:checked').val();
				$('.petname_in').text(radio_select);
			});
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<br /><br /><br />
	<div id="petadd_wrap">
		<form action="${conPath}/petAdd.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>
						<b>분류 : &nbsp;</b> 
						<input type="radio" name="pettype" id="dog" value="강아지" checked/><label for="dog" >강아지</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="pettype" id="cat" value="고양이"/><label for="cat">고양이</label>
					</td>
				</tr>
				<tr>
					<td>
						 등록할 &nbsp;<a class="petname_in">강아지</a>&nbsp;이름
						 <input type="text" name="petname" required style="width: 100px;">&nbsp;&nbsp;&nbsp;
						등록할 &nbsp;<a class="petname_in">강아지</a>&nbsp;종류
						<input type="text" name="petbrads" required style="width: 100px;">
					</td>
				</tr>
				<tr>
					<td>
						 등록할 &nbsp;<a class="petname_in">강아지</a>&nbsp;나이
						<input type="text" name="petage" placeholder="숫자만 입력"  required style="width: 100px;">&nbsp;&nbsp;&nbsp;
						등록할 &nbsp;<a class="petname_in">강아지</a>&nbsp;분양가
						<input type="text" name="petprice" placeholder="만원단위" required style="width: 80px;">
					</td>
				</tr>
				
				<tr>
					<td>
						<label for="file" class="file-label"></label>
						<input type="file" name="petimg" id="file" accept=".jpg, .png, .jpeg, .gif" onchange="checkImg()"/><span id="imgPASS" style="display:none; color: green; font-weight: bold;">이미지 등록됨</span>
					</td>
				</tr>
				<tr>
					<td>
						작성자
						<input type="text" name="comno" value="${admin.comno }" disabled style="width: 100px;"><span style="margin-left: 15px; font-weight: 700;">담당자 : ${admin.comname }</span>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="등록하기"></td>
				</tr>
			</table>
		</form>
	</div>
		<br /><br /><br />
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<script>
	function checkImg() {
		var input = document.getElementById('file');
		var imgPASS = document.getElementById('imgPASS');
		
		if(input.files.length > 0) {
			imgPASS.style.display = 'inline';
		} else {
			imgPASS.style.dispaly = 'none';
		}
	}
</script>
