<%@ page language="java" contentType="text/html; charset=UTF-8"
				 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" href="${conPath}/css/textBbs.css">
</head>
<body>
<c:if test="${not empty modifyContactResult }">
	<script>
		alert('${modifyContactResult}');
	</script>
</c:if>
<c:if test="${not empty replyResult }">
	<script>
		alert('${replyResult}');
	</script>
</c:if>
<jsp:include page="../main/header.jsp"/>
	<c:if test="${not empty ContactResult }">
		<script>
			alert('${ContactResult}');
		</script>
	</c:if>
	<div id="contact">
		<h1>분양문의 게시판</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
				<c:forEach items="${contactList }" var="contact">
					<tr>
						<td>${contact.cid }</td>
						<td>${contact.cwriter }</td>
						<td>
							<c:forEach var="i" begin="1" end="${contact.cindent }">
								<c:if test="${i eq contact.cindent }">└─</c:if>
								<c:if test="${i ne contact.cindent }"> &nbsp;&nbsp;</c:if>
							</c:forEach>
							<a href="${conPath }/contactPw.do?cid=${contact.cid}&cpw=${contact.cpw}">${contact.ctitle }</a>
						</td>
						<td>${contact.cdate }</td>
					</tr>
				</c:forEach>
			
	
		</table>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<script>
	history.replaceState({}, null, location.pathname);
</script>
