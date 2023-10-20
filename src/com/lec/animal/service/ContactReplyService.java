package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.ContactDao;
import com.lex.animal.dto.ContactDto;

public class ContactReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cwriter = request.getParameter("cwriter");
		int cpw = Integer.parseInt(request.getParameter("cpw"));
		String ctitle = request.getParameter("ctitle");
		String ctext = request.getParameter("ctext");
		String cip = request.getRemoteAddr();
		int cgroup = Integer.parseInt(request.getParameter("cgroup"));
		int cstep = Integer.parseInt(request.getParameter("cstep"));
		int cindent = Integer.parseInt(request.getParameter("cindent"));
		ContactDao cDao = ContactDao.getinstance();
		ContactDto contact = new ContactDto(0, cpw, cwriter, ctitle, ctext, null, cgroup, cstep, cindent, cip, 3);
		int result = cDao.replyContact(contact);
		if(result == ContactDao.PASS) {
			request.setAttribute("replyResult", "답변글이 작성 되었습니다.");
		} else {
			request.setAttribute("replyResult", "답변글이 작성되지 않았습니다."); 	
		}
	}

}
