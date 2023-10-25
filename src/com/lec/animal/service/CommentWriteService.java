package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.CommentDao;
import com.lex.animal.dto.CommentDto;
import com.lex.animal.dto.MemberDto;

public class CommentWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int nid = Integer.parseInt(request.getParameter("nid"));
		String mtext = request.getParameter("mtext");
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("member");
		String id = member.getId();
		String mip = request.getRemoteAddr();
		CommentDao cDao = CommentDao.getInstance();
		CommentDto comment = new CommentDto(0, id, nid, null, mtext, 0, 0, 0, mip, null);
		int result = cDao.addComment(comment);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("nid", nid);
	}

}
