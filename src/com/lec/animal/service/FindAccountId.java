package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.MemberDao;

public class FindAccountId implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberDao mDao = MemberDao.getInstance();
		String result = mDao.idFind(name, email);
		
		if(result.equals("")) {
			request.setAttribute("findIdResult", "해당 계정 정보가 존재하지 않습니다.");
		} else {
			request.setAttribute("findIdResult", "요청하신 ID는 " + result + " 입니다.");
		}
		
	}

}
