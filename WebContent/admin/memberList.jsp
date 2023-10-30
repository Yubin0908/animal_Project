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
    }
    
    body {
      font-family: Arial, sans-serif;
    }
    
    #memberList_wrap {
      width: 1000px;
      margin: 0 auto;
    }
    
    table {
      border-collapse: collapse;
      width: 100%;
    }
    
    th {
      background-color: #f2b4c1;
      color: #fff;
    }
    
    td {
      padding: 10px;
      text-align: center;
    }
    
    tr:nth-child(odd) {
      background-color: #fce1e0
    }
    
    tr:nth-child(even) {
      background-color: #f9c2b0;
    }
    
    .status_btn {
      text-decoration: none;
      color: #fff;
      text-align: center;
      background-color: #ff66b2;
      padding: 5px;
      border-radius: 8px;
    }
    .paging {
		  text-align: center;
		  margin-bottom: 20px;
		}
		
		.paging img {
		  width: 25px;
		  height: auto;
		  vertical-align: middle;
		  margin: 0 5px;
		}
		
		.paging a {
		  text-decoration: none;
		  color: #ff3399;
		  font-weight: bold;
		  font-size: 16px;
		  margin: 0 5px;
		  transition: color 0.3s ease;
		}
		
		.paging a:hover {
		  color: #ff66b2;
		}
		
		.paging b {
		  font-size: 18px;
		  color: #ff3399;
		  font-weight: bold;
		  margin: 0 5px;
		}
		
		.paging a:visited {
		  color: #ff66b2;
		}
		.btn-write {
		    display: inline-block;
		    padding: 10px 20px;
		    background-color: #ff3399;
		    color: #fff;
		    text-decoration: none;
		    border-radius: 5px;
		    font-weight: bold;
		    cursor: pointer;
		    border: none;
		}
		.search_wrap {
			margin-bottom: 10px;
		}
  </style>
</head>
<body>
  <jsp:include page="../main/header.jsp"/>
  <c:if test="${not empty controlResult }">
  	<script>
  		alert('${controlResult}');
  	</script>
  </c:if>
  <br /><br /><br />
  <div id="memberList_wrap">
    <div>전체 회원 수 : <a style="font-weight: 700; color: #ff66b2; font-size: 1.2em">${cnt }</a> 명 입니다.</div>
    <table>
      <tr>
        <th>ID</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>E-Mail</th>
        <th>주소</th>
        <th>가입일</th>
        <th>상태</th>
        <th>상태변경</th>
      </tr>
      <c:forEach items="${memberList }" var="memberL">
      	<tr>
      		<td>${memberL.id }</td>
      		<td>${memberL.name }</td>
      		<td>${memberL.loctel}-${memberL.midtel }-${memberL.lastel }</td>
      		<td>${memberL.email }</td>
      		<td>
      			<c:if test="${empty memberL.address }">
      				주소 없음
      			</c:if>
      			<c:if test="${not empty memberL.address }">
      				${memberL.address }
      			</c:if>
      		</td>
      		<td>${memberL.regidate }</td>
					<td>
						<c:if test="${memberL.account_status eq 0 }">탈퇴회원</c:if>
						<c:if test="${memberL.account_status eq 1 }">정상회원</c:if>
						<c:if test="${memberL.account_status eq 2 }">정지회원</c:if>
					</td>
      		<td>
						<c:if test="${memberL.account_status eq 1 }"><a href="${conPath }/memberControl.do?id=${memberL.id}&account_status=2" class="status_btn">회원정지</a></c:if>
						<c:if test="${memberL.account_status eq 2 }"><a href="${conPath }/memberControl.do?id=${memberL.id}&account_status=1" class="status_btn">원상복귀</a></c:if>
      		</td>
      	</tr>
      </c:forEach>
    </table>
  </div>
  <div class="paging">
  	<c:if test="${startPage > BLOCKSIZE }">
 			<a href="${conPath }/memberList.do?pageNum=${startPage-1}">
 				<img src="${conPath }/img/ico/left_arrow_1.png" alt="이전 화살표" />
 			</a>
 		</c:if>
 		<c:forEach var="i" begin="${startPage }" end="${endPage }">
 			<c:if test="${i == pageNum }">
 				<b> [ ${i } ]&nbsp;</b>
 			</c:if>
 			<c:if test="${i != pageNum }">
 				[ <a href="${conPath }/memberList.do?pageNum=${i}">${i }</a> ]&nbsp;  
 			</c:if>
 		</c:forEach>
 		<c:if test="${endPage < cnt }">
 			<a href="${conPath }/memberList.do?pageNum=${endPage+1}">
 				<img src="${conPath }/img/ico/right_arrow_1.png" alt="다음 화살표" />
 			</a>
 		</c:if>
  </div>
  <br /><br /><br />
  <jsp:include page="../main/footer.jsp"/>
</body>
</html>