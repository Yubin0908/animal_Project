package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.MemberDao;
import com.lex.animal.dto.MemberDto;

public class LoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.logincheck(id, pw);
		if(result == MemberDao.PASS) {
			HttpSession session = request.getSession();
			MemberDto member = mDao.getMember(id);
			session.setAttribute("member", member);
		} else {
			request.setAttribute("LoginFailMsg", "아이디와 비밀번호를 확인하세요.");
		}
	}
}
