<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        #notice_wrap {
            max-width: 800px;
            margin: 0 auto;
        }

        .card {
            display: flex;
            border: 1px solid #ccc;
            margin-bottom: 20px;
            background-color: #fff;
        }

        .card img {
            max-width: 150px;
            height: auto;
            object-fit: cover;
            padding: 20px 15px;
        }

        .card .card-content {
            flex: 1;
            padding: 20px;
            line-height: auto;
        }

        .card .card-content p {
            font-size: 18px;
            font-weight: bold;
            margin: 0;
        }

        .card .card-content span {
            color: #777;
            font-size: 14px;
        }
        .paging {
				  text-align: center;
				  margin-bottom: 60px;
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
				#sub-title {
			    text-align: center;
			    padding: 30px 0;
				}
				
				.desc {
			    color: #ff3399;
			    letter-spacing: 5px;
			    font-weight: 700;
			    text-transform: uppercase;
			    font-size: 36px;
				}
    </style>
</head>
<body>
  <c:if test="${not empty NoticeMsg }">
	 	<script>
	 		alert('${NoticeMsg}');
	 	</script>
  </c:if>
  <jsp:include page="../main/header.jsp" />
  <br /><br /><br />
  <div id="sub-title">
  <p class="desc">멍이랑 냥이랑 새소식</p>
  </div>
    <div id="notice_wrap">
	   	<c:forEach items="${listNotice}" var="notice">
	    	<a href="${conPath }/notice.do?nid=${notice.nid }&pageNum=${pageNum}">
		      <div class="card">
		        <div class="card-img">
		          <c:choose>
	              <c:when test="${empty notice.nimg || notice.nimg eq null}">
	               	<img src="${conPath}/img/logo/logo_trans.png" alt="배경이미지" />
	              </c:when>
	             	<c:otherwise>
	               	<img src="${conPath}/serverUploader/${notice.nimg}" alt="공지사항 이미지" width="500" height="500"/>
	             	</c:otherwise>
		          </c:choose>
		      	</div>
		      <div class="card-content">
		          <p>${notice.ntitle}&nbsp;<span style="color: #ff66b2; font-size: 20px; ">[${notice.reply_count }]</span></p>
		          <span>${notice.ndate}</span>
		      		<br /><br />
		        </div>
		      </div>
	   		</a>
	    </c:forEach>
    </div>
 	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			<a href="${conPath }/noticeList.do?pageNum=${startPage-1}">
				<img src="${conPath }/img/ico/left_arrow_1.png" alt="이전 화살표" />
			</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i == pageNum }">
				<b> [ ${i } ]&nbsp;</b>
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/noticeList.do?pageNum=${i}">${i }</a> ]&nbsp;  
			</c:if>
		</c:forEach>
		<c:if test="${endPage < cnt }">
			<a href="${conPath }/noticeList.do?pageNum=${endPage+1}">
				<img src="${conPath }/img/ico/right_arrow_1.png" alt="다음 화살표" />
			</a>
		</c:if>
	</div>
	<br /><br /><br />
	<jsp:include page="../main/footer.jsp" />
</body>
</html>
