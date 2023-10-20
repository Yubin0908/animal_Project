package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.MemberDao;
import com.lex.animal.dto.MemberDto;

public class ModifyPwCheck implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String pw = request.getParameter("pw");
		String id = request.getParameter("id");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.pwcheck(id, pw);
		if(result == MemberDao.FAIL) {
			session.setAttribute("pwChkMsg", "비밀번호가 올바르지 않습니다.");
		} else {
			MemberDto member = mDao.getMember(id);
			session.setAttribute("member", member);
		}
	}

}
