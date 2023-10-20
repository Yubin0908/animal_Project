package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.AdminDao;
import com.lex.animal.dto.AdminDto;

public class AdminLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String comnoStr = request.getParameter("comno");
		int comno = Integer.parseInt(comnoStr);
		String compw = request.getParameter("compw");
		AdminDao aDao = AdminDao.getinstance();
		int result = aDao.adminLogin(comno, compw);
		if(result == AdminDao.PASS) {
			HttpSession session = request.getSession();
			AdminDto admin = aDao.getAdmin(comno);
			session.setAttribute("admin", admin);
		} else {
			request.setAttribute("LoginFailMsg", "잘못된 계정정보 입니다.");
		}
	}

}
