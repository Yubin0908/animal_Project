<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" href="${conPath}/css/contanta.css">
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<c:if test="${not empty contactPwMsg }">
		<script>
			alert('${contactPwMsg}');
			history.back();
		</script>
	</c:if>
	<div class="container">
		<h1>${contact.cid }번 문의내용 상세보기</h1>
		<table>
			<tr>
				<td>작성자</td>
				<td>${contact.cwriter }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${contact.ctitle }</td>
			</tr>
			<tr>
				<td>문의내용</td>
				<td style="padding: 100px 15px">${contact.ctext }</td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td>${contact.cdate }</td>
			</tr>
			<tr>
				<td>IP</td>
				<td>${contact.cip }</td>
			</tr>
			<tr>
				<td>답변상태 &nbsp;&nbsp;&nbsp;</td>
				<td>
					<c:if test="${contact.cdata_status eq 1 }">
						<c:if test="${empty admin }">
							<b>답변 준비중 입니다. [수정가능 : <button onclick="location.href='${conPath}/contactModifyView.do?cid=${contact.cid }&cpw=${contact.cpw }'">게시글 수정</button>]</b>
						</c:if>
						<c:if test="${not empty admin && contact.cdata_status eq 1}">
    					<b>답변을 달 수 있습니다. [답변가능 : <button onclick="location.href='${conPath}/contactReplyView.do?cid=${contact.cid }&cpw=${contact.cpw }'">답변달기</button>]</b>
						</c:if>
						
					</c:if>
					<c:if test="${contact.cdata_status eq 2 }">
						<b>답변이 완료되어 수정이 불가합니다.</b>
					</c:if>
					<c:if test="${contact.cdata_status eq 3 }">
						<b>답변글 입니다.</b>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>
