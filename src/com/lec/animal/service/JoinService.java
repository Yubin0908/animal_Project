package com.lec.animal.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.MemberDao;
import com.lex.animal.dto.MemberDto;

public class JoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// need param
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String loctel = request.getParameter("loctel");
		String midtel = request.getParameter("midtel");
		String lastel = request.getParameter("lastel");
		String email = request.getParameter("email");
		// not need param
		String address = request.getParameter("address") == null ? "":request.getParameter("address");
		String nickname = request.getParameter("nickname") == null ? "":request.getParameter("nickname");
		// Customer-pet info param
		String aname = request.getParameter("aname") == null ? "":request.getParameter("aname");
		String adateStr = request.getParameter("adate");
		Date adate = null;
		if (adateStr != null && !adateStr.isEmpty()) {
		    adate = Date.valueOf(adateStr);
		}
		
		MemberDao mDao = MemberDao.getInstance();
		MemberDto member = new MemberDto(id, pw, name, loctel, midtel, lastel, email, address, nickname, null, 1, 1, aname, adate);
		int result = mDao.joinMember(member);
		if(result == MemberDao.PASS) {
			request.setAttribute("joinResult", "축하합니다! 회원가입이 완료되었습니다.");
		}

	}

}
