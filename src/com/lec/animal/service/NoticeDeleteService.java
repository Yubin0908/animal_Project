package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.NoticeDao;

public class NoticeDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nid = Integer.parseInt(request.getParameter("nid"));
		NoticeDao nDao = NoticeDao.getInstance();
		int result = nDao.deleteNotice(nid);
		if(result == NoticeDao.PASS) {
			request.setAttribute("NoticeMsg", "공지글 삭제되었습니다.");
		} else {
			request.setAttribute("NoticeMsg", "공지글 살제 실패 하였습니다.");
		}

	}

}
