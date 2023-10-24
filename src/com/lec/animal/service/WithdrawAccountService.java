package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.MemberDao;
import com.lex.animal.dto.MemberDto;

public class WithdrawAccountService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = null;
		MemberDto sMember = (MemberDto)session.getAttribute("member");
		if(sMember != null) {
			id = sMember.getId();
		}
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.withdrawalMember(id);
		session.invalidate();
		if(result == MemberDao.PASS) {
			request.setAttribute("WithdrawResult", "회원탈퇴가 완료되었습니다.");
		} else {
			request.setAttribute("WithdrawResult", "잘못된 접근입니다.");
		}

	}

}
