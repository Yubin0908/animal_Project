package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.ContactDao;
import com.lex.animal.dto.ContactDto;

public class ContactModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		int cpw = Integer.parseInt(request.getParameter("cpw"));
		String cwriter = request.getParameter("cwriter");
		String ctitle = request.getParameter("ctitle");
		String ctext = request.getParameter("ctext");
		String cip = request.getRemoteAddr();
		
		ContactDao cDao = ContactDao.getinstance();
		ContactDto contact = new ContactDto(cid, cpw, cwriter, ctitle, ctext, null, 0, 0, 0, cip, 1);
		
		int result = cDao.modifyContact(contact);
		if(result == ContactDao.PASS) {
			request.setAttribute("modifyContactResult", "글 수정이 완료되었습니다.");
		} else {
			request.setAttribute("modifyContactResult", "글 수정이 실패하였습니다.");
		}
	}

}
