package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.ContactDao;
import com.lex.animal.dto.ContactDto;

public class ContactReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		int cpw = Integer.parseInt(request.getParameter("cpw"));
		ContactDao cDao = ContactDao.getinstance();
		ContactDto originalContact = cDao.getContact(cid, cpw);
		request.setAttribute("orgContact", originalContact);

	}

}
