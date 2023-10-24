package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.NoticeDao;
import com.lex.animal.dto.NoticeDto;

public class NoticeService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nid = Integer.parseInt(request.getParameter("nid"));
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeDto notice = nDao.getNotice(nid);
		if(notice != null) {
			request.setAttribute("notice", notice);
		} 
	}

}
