package com.lec.animal.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.service.*;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
	    String conPath = request.getContextPath();
	    String command = uri.substring(conPath.length());
	    String viewPage = null;
	    Service service = null;
		
	    if(command.equals("/main.do")) { // main page
	    	service = new MainPetListService();
	    	service.execute(request, response);
	    	viewPage = "main/main.jsp";
	    } else if(command.equals("/loginView.do")) { // login View
	    	viewPage = "user/login.jsp";
	    } else if(command.equals("/login.do")) { // login Process
	    	service = new LoginService();
	    	service.execute(request, response);
	    	viewPage = "main.do";
	    } else if(command.equals("/logout.do")) { // logout Process
	    	service = new LogoutService();
	    	service.execute(request, response);
	    	viewPage = "main.do";
	    } else if(command.equals("/joinAgree.do")) { // joinagree View
	    	viewPage = "user/joinagree.jsp";
	    } else if(command.equals("/joinView.do")) { // join View 
	    	viewPage = "user/join.jsp";
	    } else if(command.equals("/idConfirm.do")) { // id 중복체크
	    	service = new IdConfirmService();
	    	service.execute(request, response);
	    	viewPage = "user/idConfirm.jsp";
	    } else if(command.equals("/join.do")) { // join Process
	    	service = new JoinService();
	    	service.execute(request, response);
	    	viewPage = "main.do";
	    } else if(command.equals("/modifyPwCheck.do")) { // pwCheck View
	    	viewPage = "user/userPwChk.jsp";
	    } else if(command.equals("/pwChk.do")) { // pwChk Process
	    	service = new ModifyPwCheck();
	    	service.execute(request, response);
	    	viewPage = "user/modify.jsp";
	    } else if(command.equals("/adminLoginView.do")) { // admin Login View
	    	viewPage = "admin/adminLogin.jsp";
	    } else if(command.equals("/adminLogin.do")) { // admin Login Process
	    	service = new AdminLoginService();
	    	service.execute(request, response);
	    	viewPage = "main.do";
	    } else if(command.equals("/findAccountid.do")) { // id find view
	    	viewPage = "user/findid.jsp";
	    } else if(command.equals("/findAccountpw.do")) { // pw find view
	    	viewPage = "user/findpw.jsp";
	    } else if(command.equals("/modifyAccount.do")) { // user account modify Process
	    	service = new ModifyAccountService();
	    	service.execute(request, response);
	    	viewPage = "main.do";
	    } else if(command.equals("/withdrawAccount.do")) { // user withdraw Process
	    	service = new WithdrawAccountService();
	    	service.execute(request, response);
	    	viewPage = "main.do";
	    } else if(command.equals("/hotelService.do")) { //content view - pet 호텔
	    	viewPage = "content/hotel.jsp";
	    }
	    // 메뉴할당
	    else if(command.equals("/about.do")) { // content view - about
	    	viewPage = "content/about.jsp";
	    } else if(command.equals("/petList.do")) { // view 분양리스트
	    	String pettype = request.getParameter("pettype");
	    	String petbrads = request.getParameter("petbrads");
	    	if(petbrads == null) {
	    		service = new PetListService();
	    	} else if(!petbrads.equals("기타")) {
	    		service = new PetListFilterService();
	    	} else if(petbrads.equals("기타")) {
	    		service = new PetListFilterEtcService();
	    	}
	    	service.execute(request, response);
	    	viewPage = "contact/petList.jsp";
	    } else if(command.equals("/petAddView.do")) { // view 분양리스트 추가
	    	viewPage = "contact/petAdd.jsp";
	    } else if(command.equals("/petAdd.do")) { // Process 분양리스트 추가
	    	service = new PetAddService();
	    	service.execute(request, response);
	    	viewPage = "petList.do";
	    } else if(command.equals("/petDelete.do")) { // Process 분양리스트 삭제
	    	String pettype = request.getParameter("pettype");
	    	service = new PetDeleteService();
	    	service.execute(request, response);
	    	viewPage = "petList.do";
	    } else if(command.equals("/petModifyView.do")) { // view 분양리스트 수정
	    	service = new PetModifyViewService();
	    	service.execute(request, response);
	    	viewPage = "contact/petModify.jsp";
	    } else if(command.equals("/petModify.do")) { // Process 분양리스트 수정
	    	service = new PetModifyService();
	    	service.execute(request, response);
	    	viewPage = "petList.do";
	    } else if(command.equals("/contactList.do")) { // view 분양문의게시판 리스트
	    	service = new ContactListService();
	    	service.execute(request, response);
	    	viewPage = "contact/contactList.jsp";
	    } else if(command.equals("/contactPw.do")) { // view 분양문의게시판 비민번호확인
	    	viewPage = "contact/pwCheck.jsp";
	    } else if(command.equals("/contact.do")) { // view 분양문의게시판 상세보기
	    	service = new ContactService();
	    	service.execute(request, response);
	    	viewPage = "contact/contact.jsp";
	    } else if(command.equals("/contactWriteView.do")) { // view 분양문의게시판 새글작성
	    	viewPage = "contact/contactWrite.jsp";
	    } else if(command.equals("/contactWrite.do")) { // Process 분양문의게시판 새글작성
	    	service = new ContactWriteService();
	    	service.execute(request, response);
	    	viewPage = "contactList.do";
	    } else if(command.equals("/contactModifyView.do")) { // view 분양문의게시판 글 수정
	    	service = new ContactModifyViewService();
	    	service.execute(request, response);
	    	viewPage = "contact/contactModify.jsp";
	    } else if(command.equals("/contactModify.do")) { // view 분양문의게시판 글 수정
	    	service = new ContactModifyService();
	    	service.execute(request, response);
	    	viewPage = "contactList.do";
	    } else if(command.equals("/contactReplyView.do")) { // view 분양문의게시판 답글작성
	    	service = new ContactReplyViewService();
	    	service.execute(request, response);
	    	viewPage = "contact/contactReply.jsp";
	    } else if(command.equals("/contactReply.do")) { // Process 분양문의게시판 답글작성
	    	service = new ContactReplyService();
	    	service.execute(request, response);
	    	viewPage = "contactList.do";
	    } else if(command.equals("/reviewList.do")) { // view 리뷰게시판 리스트
	    	String pageNum = request.getParameter("pageNum");
	    	service = new ReviewListService();
	    	service.execute(request, response);
	    	viewPage = "bbs/reviewList.jsp";
	    } else if(command.equals("/review.do")) { // view 리뷰게시판 상세보기
	    	service = new ReviewService();
	    	service.execute(request, response);
	    	viewPage = "bbs/review.jsp";
	    } else if(command.equals("/reviewWriteView.do")) { // view 리뷰게시판 새글작성
	    	viewPage = "bbs/reviewWrite.jsp";
	    } else if(command.equals("/reviewWrite.do")) { // Process 리뷰게시판 새글작성
	    	service = new ReviewWriteService();
	    	service.execute(request, response);
	    	viewPage = "reviewList.do";
	    } else if(command.equals("/reviewModifyView.do")) { // view 리뷰게시판 글수정
	    	service = new ReviewModifyViewService();
	    	service.execute(request, response);
	    	viewPage = "bbs/reviewModify.jsp";
	    } else if(command.equals("/reviewModify.do")) { // Process 리뷰게시판 글수정
	    	service = new ReviewModifyService();
	    	service.execute(request, response);
	    	viewPage = "reviewList.do";
	    } else if(command.equals("/reviewDelete.do")) { // Process 리뷰게시판 글 삭제
	    	service = new ReviewDeleteService();
	    	service.execute(request, response);
	    	viewPage = "reviewList.do";
	    } else if(command.equals("/noticeList.do")) { // view 공지사항 게시판 리스트
	    	service = new NoticeListService();
	    	service.execute(request, response);
	    	viewPage = "bbs/noticeList.jsp";
	    } else if(command.equals("/notice.do")) { // view 공지사항 게시판 상세보기
	    	service = new NoticeService();
	    	service.execute(request, response);
	    	viewPage = "bbs/notice.jsp";
	    } else if(command.equals("/noticeDelete.do")) { // Process 공지사항 게시판 글 삭제
	    	service = new NoticeDeleteService();
	    	service.execute(request, response);
	    	viewPage = "noticeList.do";
	    } else if(command.equals("/noticeWriteView.do")) { // view 공지사항 게시판 새글 작성
	    	viewPage = "bbs/noticeWrite.jsp";
	    } else if(command.equals("/noticeWrite.do")) { // Process 공지사항 게시판 새글 작성
	    	service = new NoticeWriteService();
	    	service.execute(request, response);
	    	viewPage = "noticeList.do";
	    } else if(command.equals("/noticeModifyView.do")) { // view 공지사항 게시판 글 수정
	    	service = new NoticeModifyViewService();
	    	service.execute(request, response);
	    	viewPage = "bbs/noticeModify.jsp";
	    } else if(command.equals("/noticeModify.do")) { // Process 공지사항 게시판 글 수정
	    	service = new NoticeModifyService();
	    	service.execute(request, response);
	    	viewPage = "noticeList.do";
	    } else if(command.equals("/commentWrite.do")) { // Process 공지사항 게시판 댓글 작성
	    	service = new CommentWriteService();
	    	service.execute(request, response);
	    	viewPage = "notice.do";
	    } else if(command.equals("/commentModifyView.do")) { // 구현중
	    	service = new CommentModifyVIewService();
	    	service.execute(request, response);
	    	viewPage = "notice.do";
	    } else if(command.equals("/commentReply.do")) {
	    	service = new CommentReplyService();
	    	service.execute(request, response);
	    	viewPage = "notice.do";
	    } else if(command.equals("/commentModify.do")) { // 구현중
	    	service = new CommentModifyService();
	    	service.execute(request, response);
	    	viewPage = "notice.do";
	    } else if(command.equals("/commentDelete.do")) {
	    	service = new CommentDeleteService();
	    	service.execute(request, response);
	    	viewPage = "notice.do";
	    }else if(command.equals("/searchResult.do")) { // 검색
	    	service = new SearchResultService();
	    	service.execute(request, response);
	    	viewPage = "main/serchResultView.jsp";
	    }
	    
	    // Exception rediretion
	    else if(command.equals("/e404.do")) {
	    	viewPage = "except/e404.jsp";
	    }
	    // test Menu
	    
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	    dispatcher.forward(request, response);
	}

}
