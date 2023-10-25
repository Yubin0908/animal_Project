package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.CommentDao;
import com.lex.animal.dto.CommentDto;
import com.lex.animal.dto.MemberDto;

public class CommentReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("member");
		String id = member.getId();
		String mtext = request.getParameter("mtext");
		String mip = request.getRemoteAddr();
		int nid = Integer.parseInt(request.getParameter("nid"));
		int mgroup = Integer.parseInt(request.getParameter("mgroup"));
		int mstep = Integer.parseInt(request.getParameter("mstep"));
		int mindent = Integer.parseInt(request.getParameter("mindent"));
		CommentDao cDao = CommentDao.getInstance();
		CommentDto comment = new CommentDto(0, id, nid, null, mtext, mgroup, mstep, mindent, mip, null);
		int result = cDao.replyComment(comment);
		
	}

}
