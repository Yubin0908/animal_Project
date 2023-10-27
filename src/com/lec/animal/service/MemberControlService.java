package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.MemberDao;
import com.lex.animal.dto.MemberDto;

public class MemberControlService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		int account_status = Integer.parseInt(request.getParameter("account_status"));
		
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.membeControl(id, account_status);
		if(result == MemberDao.PASS) {
			request.setAttribute("controlResult", "회원상태변경을 완료했습니다.");
		} else {
			request.setAttribute("controlResult", "회원상태변경을 실패했습니다.");
		}
	}

}
