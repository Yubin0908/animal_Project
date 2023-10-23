package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.ContactDao;
import com.lex.animal.dto.ContactDto;

public class ContactService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		int cpw = Integer.parseInt(request.getParameter("cpw"));
		ContactDao cDao = ContactDao.getinstance();
		ContactDto contact = cDao.getContact(cid, cpw);
		
		if(contact != null) {
			request.setAttribute("contact", contact);
		} else {
			request.setAttribute("contactPwMsg", "비밀번호가 일치하지 않습니다. 비밀번호를 확인하세요.");
		}
		

	}

}
