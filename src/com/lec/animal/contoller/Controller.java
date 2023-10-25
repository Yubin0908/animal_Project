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
	    } else if(command.equals("/pwChk.do")) {
	    	service = new ModifyPwCheck();
	    	service.execute(request, response);
	    	viewPage = "user/modify.jsp";
	    } else if(command.equals("/adminLoginView.do")) {
	    	viewPage = "admin/adminLogin.jsp";
	    } else if(command.equals("/adminLogin.do")) {
	    	service = new AdminLoginService();
	    	service.execute(request, response);
	    	viewPage = "main.do";
	    } else if(command.equals("/findAccountid.do")) {
	    	viewPage = "user/findid.jsp";
	    } else if(command.equals("/findAccountpw.do")) {
	    	viewPage = "user/findpw.jsp";
	    } else if(command.equals("/modifyAccount.do")) {
	    	service = new ModifyAccountService();
	    	service.execute(request, response);
	    	viewPage = "main.do";
	    } else if(command.equals("/withdrawAccount.do")) {
	    	service = new WithdrawAccountService();
	    	service.execute(request, response);
	    	viewPage = "main.do";
	    } else if(command.equals("/hotelService.do")) {
	    	viewPage = "content/hotel.jsp";
	    }
	    // 메뉴할당
	    else if(command.equals("/about.do")) {
	    	viewPage = "content/about.jsp";
	    } else if(command.equals("/petList.do")) {
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
	    } else if(command.equals("/petAddView.do")) {
	    	viewPage = "contact/petAdd.jsp";
	    } else if(command.equals("/petAdd.do")) {
	    	service = new PetAddService();
	    	service.execute(request, response);
	    	viewPage = "petList.do";
	    } else if(command.equals("/petDelete.do")) {
	    	String pettype = request.getParameter("pettype");
	    	service = new PetDeleteService();
	    	service.execute(request, response);
	    	viewPage = "petList.do";
	    } else if(command.equals("/petModifyView.do")) {
	    	service = new PetModifyViewService();
	    	service.execute(request, response);
	    	viewPage = "contact/petModify.jsp";
	    } else if(command.equals("/petModify.do")) {
	    	service = new PetModifyService();
	    	service.execute(request, response);
	    	viewPage = "petList.do";
	    } else if(command.equals("/contactList.do")) {
	    	service = new ContactListService();
	    	service.execute(request, response);
	    	viewPage = "contact/contactList.jsp";
	    } else if(command.equals("/contactPw.do")) {
	    	viewPage = "contact/pwCheck.jsp";
	    } else if(command.equals("/contact.do")) {
	    	service = new ContactService();
	    	service.execute(request, response);
	    	viewPage = "contact/contact.jsp";
	    } else if(command.equals("/contactWriteView.do")) {
	    	viewPage = "contact/contactWrite.jsp";
	    } else if(command.equals("/contactWrite.do")) {
	    	service = new ContactWriteService();
	    	service.execute(request, response);
	    	viewPage = "contactList.do";
	    } else if(command.equals("/contactModifyView.do")) {
	    	service = new ContactModifyViewService();
	    	service.execute(request, response);
	    	viewPage = "contact/contactModify.jsp";
	    } else if(command.equals("/contactModify.do")) {
	    	service = new ContactModifyService();
	    	service.execute(request, response);
	    	viewPage = "contactList.do";
	    } else if(command.equals("/contactReplyView.do")) {
	    	service = new ContactReplyViewService();
	    	service.execute(request, response);
	    	viewPage = "contact/contactReply.jsp";
	    } else if(command.equals("/contactReply.do")) {
	    	service = new ContactReplyService();
	    	service.execute(request, response);
	    	viewPage = "contactList.do";
	    } else if(command.equals("/reviewList.do")) {
	    	String pageNum = request.getParameter("pageNum");
	    	service = new ReviewListService();
	    	service.execute(request, response);
	    	viewPage = "bbs/reviewList.jsp";
	    } else if(command.equals("/review.do")) {
	    	service = new ReviewService();
	    	service.execute(request, response);
	    	viewPage = "bbs/review.jsp";
	    } else if(command.equals("/reviewWriteView.do")) {
	    	viewPage = "bbs/reviewWrite.jsp";
	    } else if(command.equals("/reviewWrite.do")) {
	    	service = new ReviewWriteService();
	    	service.execute(request, response);
	    	viewPage = "reviewList.do";
	    } else if(command.equals("/reviewModifyView.do")) {
	    	service = new ReviewModifyViewService();
	    	service.execute(request, response);
	    	viewPage = "bbs/reviewModify.jsp";
	    } else if(command.equals("/reviewModify.do")) {
	    	service = new ReviewModifyService();
	    	service.execute(request, response);
	    	viewPage = "reviewList.do";
	    } else if(command.equals("/reviewDelete.do")) {
	    	service = new ReviewDeleteService();
	    	service.execute(request, response);
	    	viewPage = "reviewList.do";
	    } else if(command.equals("/noticeList.do")) {
	    	service = new NoticeListService();
	    	service.execute(request, response);
	    	viewPage = "bbs/noticeList.jsp";
	    } else if(command.equals("/notice.do")) {
	    	service = new NoticeService();
	    	service.execute(request, response);
	    	viewPage = "bbs/notice.jsp";
	    } else if(command.equals("/noticeDelete.do")) {
	    	service = new NoticeDeleteService();
	    	service.execute(request, response);
	    	viewPage = "noticeList.do";
	    } else if(command.equals("/noticeWriteView.do")) {
	    	viewPage = "bbs/noticeWrite.jsp";
	    } else if(command.equals("/noticeWrite.do")) {
	    	service = new NoticeWriteService();
	    	service.execute(request, response);
	    	viewPage = "noticeList.do";
	    } else if(command.equals("/noticeModifyView.do")) {
	    	service = new NoticeModifyViewService();
	    	service.execute(request, response);
	    	viewPage = "bbs/noticeModify.jsp";
	    } else if(command.equals("/noticeModify.do")) {
	    	service = new NoticeModifyService();
	    	service.execute(request, response);
	    	viewPage = "noticeList.do";
	    } else if(command.equals("/commentWrite.do")) {
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
	    }
	    // Exception rediretion
	    else if(command.equals("/e404.do")) {
	    	viewPage = "except/e404.jsp";
	    }
	    
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	    dispatcher.forward(request, response);
	}

}
