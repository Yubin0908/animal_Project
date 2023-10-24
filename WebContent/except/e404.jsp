<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
     * {
			margin: 0;
			padding: 0;
			background-color: #F7F2E0;
		}
		#e404_wrap {
			width: 1400px;
			margin: 0 auto;
			height: 500px;
		}
    .img {
      margin: 250px 300px 0 300px;
    }
    .img img {
      width: 300px;
      display: block;
      margin: auto;
    }
    .text {
      text-align: center;
      font-size: 1.3em;
      font-weight: 600;

    }
	</style>
</head>
<body>
  <div id="e404_wrap">
    <div class="img">
      <img src="${conPath }/img/catdog_trans.png" alt="강아지/고양이">
    </div>
    <div class="text">
      <p>보다 나은 서비스를 위해 준비중에 있습니다</p>
      <p>최대한 빠른 시일내에 찾아뵙겠습니다. 감사합니다.</p>
    </div>
  </div>
</body>
</html>
<script>
	setInterval(() => {
		location.href="main.do";
	}, 3000);
</script>