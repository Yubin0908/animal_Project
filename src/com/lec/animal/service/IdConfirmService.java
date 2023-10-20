package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.MemberDao;

public class IdConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.idConfirm(id);
		if(result == MemberDao.EXIST) {
			request.setAttribute("idConfirmResult", "<b>중복된 ID입니다. 다른 ID를 사용하세요.</b>");
		} else {
			request.setAttribute("idConfirmResult", "사용 가능한 ID 입니다.");
		}

	}

}
