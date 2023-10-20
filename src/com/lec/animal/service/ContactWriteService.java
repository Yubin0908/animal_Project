package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.ContactDao;
import com.lex.animal.dto.ContactDto;

public class ContactWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cwriter = request.getParameter("cwriter");
		int cpw = Integer.parseInt(request.getParameter("cpw"));
		String ctitle = request.getParameter("ctitle");
		String ctext = request.getParameter("ctext");
		String cip = request.getRemoteAddr();
		ContactDao cDao = ContactDao.getinstance();
		ContactDto contact = new ContactDto(0, cpw, cwriter, ctitle, ctext, null, 0, 0, 0, cip, 1);
		int result = cDao.contactAdd(contact);
		if(result == ContactDao.PASS) {
			request.setAttribute("ContactResult", "문의글이 작성되었습니다.");
		} else {
			request.setAttribute("ContactResult", "문의글 작성에 실패하였습니다.");
		}
	}

}
