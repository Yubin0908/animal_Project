
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<title>Title</title>
	<style>
    #catinfo_wrap {
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

    input[type="text"], input[type="number"], input[type="password"],
    textarea {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-bottom: 10px;
    }

    #catinfo_wrap input[type="submit"] {
      background-color: #ff3399;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    #catinfo_wrap input[type="submit"]:hover {
      background-color: #ff66b2;
    }
		.nosize {
			resize: none;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
		<div id="catinfo_wrap">
			<form action="${conPath}/contactReply.do" method="post">
				<input type="hidden" name="cgroup" value="${orgContact.cgroup }" />
				<input type="hidden" name="cstep" value="${orgContact.cstep }"/>
				<input type="hidden" name="cindent" value="${orgContact.cindent }"/>
				<table>
					<tr>
						<td>
							당담자
								<input type="text" name="cwriter" value="${admin.comname }(${admin.comno})" readonly>				
						</td>
					</tr>
					<tr>
						<td>
							비밀번호<a style="color: red; font-weight: bold">[비밀번호는 고객이 입력한 비밀번호가 입력됩니다.]</a>
							<input type="password" name="cpw" value=${param.cpw } required readOnly>
						</td>
					</tr>
					<tr>
						<td>
							제목
							<input type="text" name="ctitle" value="[답변 : ]">
						</td>
					</tr>
					<tr>
						<td>
							문의내용
							<textarea cols="40" rows="20" class="nosize" name="ctext" required>[ Pet is Companian 안녕하세요. 멍이랑 냥이랑  답변담당자 ${admin.comname }입니다. ]</textarea>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="답변달기"></td>
					</tr>
				</table>
			</form>
		</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<script>
	history.replaceState({}, null, location.pathname);
</script>