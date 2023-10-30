<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="${conPath}/css/review.css">
    <script src="https://cdn.tiny.cloud/1/nd8grynjd8268gdl5ya7l9blew0p9nql98thf7fre8azeeg6/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .review-form {
            background-color: #fff;
            border: 1px solid #eee;
            border-radius: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 1000px;
            margin: 20px auto;
            padding: 20px;
        }

        .review-form p {
            margin: 0;
            padding: 10px 0;
        }

        .review-form input[name="ntitle"] {
            width: 80%;
            padding: 10px;
            margin: 5px 20px;
            border-radius: 15px;
            border-color: #ccc;
            outline: none;
        }

        .review-form textarea {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
        }

        .file-input {
            margin: 5px 0;
        }

        .review-btn {
            background-color: #ff3399;
            border: none;
            border-radius: 5px;
            color: #fff;
            cursor: pointer;
            font-size: 18px;
            font-weight: bold;
            padding: 15px 0;
            width: 100%;
            margin-top: 10px;
            transition: background-color 0.3s ease;
        }

        .review-btn:hover {
            background-color: #ff66b2;
        }

    </style>
</head>
<body>
	<c:if test="${empty admin }">
		<script>
			alert('로그인 후 등록가능 합니다.');
			history.back(); 
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<br /><br /><br />
	<form class="review-form" action="${conPath }/noticeWrite.do" method="post" enctype="multipart/form-data">
	    <p>제목 <input type="text" name="ntitle" required/></p>
	    <textarea name="ntext"><p><img src="${conPath }/img/logo/logo_trans.png" alt="Logo" width="300"/></p></textarea>
	    <input type="file" class="file-input" name="nimg" accept="image/*" id="file-upload" style="background-color: transparent; display: none;"/>
	<label for="file-upload" class="custom-file-upload">대표 이미지 등록</label>
	    <input type="submit" value="공지글 올리기" class="review-btn" />
	</form>
	<br /><br /><br />
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<script>
	tinymce.init({
	    selector: 'textarea',
	    plugins: 'autolink code link autoresize paste contextmenu image preview',
	    toolbar: 'undo redo | fintsizeselect | forecolor | bold italic strikethrough underline | alignleft aligncenter alignright alignjustify | tinycomments | bullist numlist outdent indent | link custom_image | code preview',
	    fintsize_formats: '8px 10px 12px 14px 16px 18px 20px 22px 24px 26px 28px 30px 36px 40px 48px',
	    tinycomments_mode: 'embedded',
	    tinycomments_author: 'Author name',
	    fullpage_default_font_size: "16px",
	    paste_as_text: true,
	    paste_data_images: true,
	    branding: false,
	    language: "ko_KR",
	    menubar: false,
	    min_height: 800,
	    max_height: 800,
	    content_style: 'body { text-align: center; }',
	});
</script>





