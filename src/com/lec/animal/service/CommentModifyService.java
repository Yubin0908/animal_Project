package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.CommentDao;
import com.lex.animal.dto.CommentDto;
import com.lex.animal.dto.MemberDto;

public class CommentModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int mid = Integer.parseInt(request.getParameter("mid"));
		int nid = Integer.parseInt(request.getParameter("nid"));
		String mtext = request.getParameter("mtext");
		String mip = request.getRemoteAddr();
		CommentDao cDao = CommentDao.getInstance();
		CommentDto comment = new CommentDto(mid, null, nid, null, mtext, 0, 0, 0, mip, null);
		int result = cDao.modifyComment(comment);
	}

}
