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
            width: 400px;
            margin: 20px auto;
            padding: 20px;
        }

        .review-form p {
            margin: 0;
            padding: 10px 0;
        }

        .review-form input[name="rtitle"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
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
	<c:if test="${empty member }">
		<script>
			alert('로그인 후 등록가능 합니다.');
			history.back();
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<br /><br /><br />
	<form class="review-form" action="${conPath }/reviewModify.do" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="pageNum" value="${param.pageNum }" />
	    <input type="hidden" name="rid" value="${param.rid }" />
	    <p>제목 <input type="text" name="rtitle" required value="${review.rtitle }"/></p>
	    <textarea name="rtext">${review.rtext }</textarea>
	    <input type="file" class="file-input" name=rimg accept="image/*" id="file-upload" style="background-color: transparent;" value="${review.rimg }"/>
	<label for="file-upload" class="custom-file-upload">파일 업로드</label>
	    <input type="submit" value="리뷰 등록" class="review-btn" />
	</form>
	<br /><br /><br />
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<script>
    tinymce.init({
        selector: 'textarea',
        plugins: 'ai tinycomments mentions anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed permanentpen footnotes advtemplate advtable advcode editimage tableofcontents mergetags powerpaste tinymcespellchecker autocorrect a11ychecker typography inlinecss',
        toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table mergetags | align lineheight | tinycomments | checklist numlist bullist indent outdent | emoticons charmap | removeformat',
        tinycomments_mode: 'embedded',
        tinycomments_author: 'Author name',
        mergetags_list: [
            { value: 'First.Name', title: 'First Name' },
            { value: 'Email', title: 'Email' },
        ],
        ai_request: (request, respondWith) => respondWith.string(() => Promise.reject("See docs to implement AI Assistant"))
    });
</script>





