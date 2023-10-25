<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="${conPath }/commentModify.do">
		<input type="text" name="mid" value="${comment.mid}" />
		<input type="text" name="pageNum" value="${pageNum }" />
		<input type="text" name="nid" value="${comment.nid }" />
		<c:forEach var="i" begin="1" end="${comment.mindent }">
			<c:if test="${i==comment.mindent }">
				&nbsp; &nbsp; &nbsp; └
			</c:if>
			<c:if test="${i!= comment.cindent}">
				&nbsp; &nbsp; &nbsp;
			</c:if>
		</c:forEach>
		<textarea rows="2" cols="5" name="cmemo" style="width:50%; height:30px; float:left; margin: 5px;">${comment.ctext }</textarea>
		<input type="submit" value="수정" class="btn" style="height:30px; float:left; margin: 5px;">
	</form>
</body>
</html>