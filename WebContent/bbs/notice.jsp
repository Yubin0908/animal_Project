<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
  <title>Mong - Meow Review</title>
  <link rel="stylesheet" href="${conPath}/css/review.css">
  <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<c:if test="${not empty CommentResult }">
			<script>
				alert('${CommentResult}');
			</script>
		</c:if>
	<div id="sub_title">
		  <p class="desc">공지사항</p>
		  <h1 class="title">NEW NOTICE</h1>
		</div>
    <div id="review_wrap">
	    <table class="review_table">
	     <colgroup>
	      <col class="col_w">
	      <col width="*">
	     </colgroup>
	     <tr>
	      <td class="review_header">
	        <p class="title">${notice.ntitle }</p>
	        <p class="info">관리자 | <span class="date">${notice.ndate }</span></p>
	      </td>
	     </tr>
	     <tr>
	      <td class="content" colspan="2" style="text-align: center;">
	        <c:if test="${not empty notice.nimg }">
	         	<img src="${conPath }/serverUploader/${notice.nimg}" alt="공지사항 이미지" class="공지사항 이미지" />
	        </c:if>
	        <c:if test="${empty notice.nimg }">
	        	<img src="${conPath }/img/logo/logo_trans.png" alt="" />
	        </c:if>
	        <div class="review-text">${notice.ntext }</div>
	      </td>
	     </tr>
	    </table>
	    <div class="review_btn_div">
	     	<a href="${conPath }/noticeList.do?pageNum=${param.pageNum}" class="btn-back">목록</a>
	      <c:if test="${not empty admin }">
	      	<a href="${conPath }/noticeModifyView.do?pageNum=${param.pageNum}&nid=${notice.nid}" class="btn-back">수정</a>
	      	<a href="${conPath }/noticeDelete.do?pageNum=${param.pageNum}&nid=${notice.nid}" class="btn-back">삭제</a>
	      </c:if>
	     </div>
	    <div class="comment_wrap">
	    <div class="comment_write_box">
	      <p class="comment_guide_text">댓글 수 : ${cnt }개</p>
	      <p>
	        <form action="commentWrite.do" method="post">
	          <input type="hidden" name="nid" value="${param.nid }" />
	          <input type="hidden" name="pageNum" value="${param.pageNum }"/>
	          <c:if test="${empty member && empty admin }">
	         	 <textarea name="mtext" class="comment_write_input" placeholder="로그인 하셔야 댓글 달기가 가능합니다." disabled></textarea>
	          </c:if>
	          <c:if test="${not empty member || not empty admin }">
	        	  <textarea name="mtext" class="comment_write_input"></textarea>
	          </c:if>
	          <input type="submit" value="댓글 달기" class="comment_write_btn">
	        </form>
	      </p>
	    </div>
	    <div class="comment_list">
	      <ul>
       <c:if test="${empty commentList }">등록된 댓글이 없습니다.</c:if>
       <c:forEach items="${commentList }" var="cmt">
        <li class="comment_part">
          <div class="comment_inner">
            <div class="comment_info">
             	<c:forEach var="i" begin="1" end="${cmt.mindent }">
	              <c:if test="${i == cmt.mindent }">
	              	&nbsp; &nbsp; &nbsp; <img src="${conPath }/img/ico/enter.png" alt="enter" width="15"/>
	              </c:if>
	              <c:if test="${i != cmt.mindent }">
	              	&nbsp; &nbsp; &nbsp; 	
	              </c:if>
              </c:forEach>
              <input type="hidden" name="mid" value="${cmt.mid }" class="mid_value"/>
              <span class="comment_name">${cmt.id }</span>
              <span class="comment_date">${cmt.mdate }</span>
              <span class="comment_date" style="float: right">${cmt.mip }</span>
              <c:if test="${member.id == cmt.id }">
              <a href="javascript:void(0);" class="comment_answer_btn" onclick="toggleModify(this)">수정</a>
           	 	<a href="${conPath }/commentDelete.do?mid=${cmt.mid}&nid=${cmt.nid}&pageNum=${param.pageNum}" class="comment_answer_btn">삭제</a>
             </c:if>
             <a href="javascript:void(0);" class="comment_answer_btn" onclick="toggleReply(this)">답글</a>
             
						<div class="comment_text modify${comment.mid }">
					    ${cmt.mtext}
						</div>
						<div class="comment_reply">
					    <form action="${conPath }/commentReply.do?mid=${cmt.mid}&nid=${cmt.nid}&pageNum=${param.pageNum}" method="post">
					    	<input type="hidden" name="nid" value="${cmt.nid }" />
					    	<input type="hidden" name="mgroup" value="${cmt.mgroup }"/>
					    	<input type="hidden" name="mstep" value="${cmt.mstep }"/>
					    	<input type="hidden" name="mindent" value="${cmt.mindent }"/>
					    	<textarea name="mtext" class="text-reply comment_reply_input" <c:if test="${empty member && empty admin }">placeholder="로그인 하셔야 답글 달기가 가능합니다." disabled</c:if>></textarea>
				    		<input type="submit" value="답글 달기" class="btn-reply comment_write_btn">
					    </form>
						</div>
	       		 <div class="comment_modify">
						    <form action="${conPath }/commentModify.do" method="post">
						    	<input type="hidden" name="nid" value="${cmt.nid }" />
						    	<input type="hidden" name="mgroup" value="${cmt.mgroup }"/>
						    	<input type="hidden" name="mstep" value="${cmt.mstep }"/>
						    	<input type="hidden" name="mindent" value="${cmt.mindent }"/>
						    	<input type="hidden" name="pageNum" value="${param.pageNum }"/>
						    	<input type="hidden" name="mid" value="${cmt.mid }" />
						    	<textarea name="mtext" class="text-modify comment_reply_input"></textarea>
					    		<input type="submit" value="댓글 수정" class="btn-reply comment_write_btn">
						    </form>
							</div>
       		 </li>
      	 </c:forEach>
	      </ul>
	    </div>
	    <div class="paging">
		  	<c:if test="${startPage > BLOCKSIZE }">
		 			<a href="${conPath }/notice.do?nid=${param.nid}&pageNum=${startPage-1}">
		 				<img src="${conPath }/img/ico/left_arrow_1.png" alt="이전 화살표" />
		 			</a>
		 		</c:if>
		 		<c:forEach var="i" begin="${startPage }" end="${endPage }">
		 			<c:if test="${i == pageNum }">
		 				<b> [ ${i } ]&nbsp;</b>
		 			</c:if>
		 			<c:if test="${i != pageNum }">
		 				[ <a href="${conPath }/notice.do?nid=${param.nid}&pageNum=${i}">${i }</a> ]&nbsp;  
		 			</c:if>
		 		</c:forEach>
		 		<c:if test="${endPage < cnt }">
		 			<a href="${conPath }/notice.do?nid=${param.nid}&pageNum=${endPage+1}">
		 				<img src="${conPath }/img/ico/right_arrow_1.png" alt="다음 화살표" />
		 			</a>
		 		</c:if>
		  </div>
	  </div>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<script>
	function toggleReply(link) {
	  const replyBox = link.closest(".comment_inner").querySelector(".comment_reply");
	  if (replyBox.style.display === "block") {
	    replyBox.style.display = "none";
	  } else {
	    replyBox.style.display = "block";
	  }
	}
	function toggleModify(link) {
		const replyBox = link.closest(".comment_inner").querySelector(".comment_modify");
		const mtext = link.closest(".comment_inner").querySelector(".comment_text");
		  if (replyBox.style.display === "block") {
		    replyBox.style.display = "none";
		  } else {
		    const trimText = mtext.textContent.trim();
		    replyBox.style.display = "block";
		    replyBox.querySelector(".text-modify").value = trimText;
		  }
		}
	
	//history.replaceState({}, null, location.pathname);
</script>