<%--
  Created by IntelliJ IDEA.
  User: kotor
  Date: 2023-10-01
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<title>Title</title>
	<style>
    body {
      margin: 0;
      padding: 0;
      overflow-x: hidden;
      background-color: #fff3e6;
    }

    #about_wrap {
      width: 1000px;
      margin: 0 auto;
      text-align: center;
      padding: 50px 0; /* 내용과 상하 여백 추가 */
    }

    .about_1,
    .about_2,
    .about_3 {
      margin-bottom: 100px;
      opacity: 0;
      transform: translateY(50px);
      transition: opacity 0.5s ease, transform 0.5s ease;
      background-color: #fff; /* 배경색을 흰색으로 설정 */
      padding: 20px; /* 내용과 상하 여백 추가 */
      border-radius: 10px; /* 귀여운 둥근 모서리 설정 */
      box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 추가 */
    }

    .visible {
      opacity: 1;
      transform: translateY(0);
    }
	
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
  <div id="about_wrap">
		<div class="about_1">
			<img src="${conPath}/img/about/ab1.png" alt="about_firstIMG">
		</div>
		<div class="about_2">
			<img src="${conPath}/img/about/ab2.png" alt="about_middleIMG">
		</div>
		<div class="about_3">
			<img src="${conPath}/img/about/ab3.png" alt="about_lastIMG">
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<script>
    const elementsToAnimate = document.querySelectorAll('.about_1, .about_2, .about_3');

    function checkScroll() {
        elementsToAnimate.forEach(element => {
            const elementTop = element.getBoundingClientRect().top;
            const windowHeight = window.innerHeight;

            if (elementTop < windowHeight * 0.75) {
                element.classList.add('visible');
            }
        });
    }

    window.addEventListener('scroll', checkScroll);
    window.addEventListener('resize', checkScroll);
    checkScroll();

   
</script>