package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.MemberDao;
import com.lex.animal.dto.MemberDto;

public class ModifyAccountService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto members = (MemberDto)session.getAttribute("member");
		String id = members.getId();
		String pw = members.getPw();
		String name = members.getName();
		String email = request.getParameter("email");
		String loctel = request.getParameter("loctel");
		String midtel = request.getParameter("midtel");
		String lastel = request.getParameter("lastel");
		String address = request.getParameter("address");
		String nickname = request.getParameter("nickname");
		
		MemberDao mDao = MemberDao.getInstance();
		MemberDto member = new MemberDto(id, null, null, loctel, midtel, lastel, email, address, nickname, null, 1);

		int result = mDao.modifyMember(member);
		if(result == MemberDao.PASS) {
			request.setAttribute("modifyMemberResult", "회원정보수정이 완료되었습니다.");
			request.setAttribute("member", member);
		} else {
			request.setAttribute("modifyMemberResult", "회원정보수정이 실패했습니다.");
		}
	}

}
