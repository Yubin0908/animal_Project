package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.MemberDao;
import com.lex.animal.dto.MemberDto;

public class ModifyPwService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDao mDao = MemberDao.getInstance();
		MemberDto member = new MemberDto(id, pw, null, null, null, null, null, null, null, null, 1);
		int result = mDao.pwmodify(member);
		if(result == MemberDao.PASS) {
			request.setAttribute("modifyMemberResult", "비밀번호수정이 완료되었습니다. 다시 로그인 해주세요.");
			session.invalidate();
		} else {
			request.setAttribute("modifyMemberResult", "비밀번호수정이 실패했습니다.");
		}
	}

}
