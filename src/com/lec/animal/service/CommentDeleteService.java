package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.CommentDao;

public class CommentDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int mid = Integer.parseInt(request.getParameter("mid"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		CommentDao cDao = CommentDao.getInstance();
		int result = cDao.deleteComment(mid);
		if(result == CommentDao.PASS) {
			request.setAttribute("CommentResult", "댓글이 삭제되었습니다.");
		}

	}

}
