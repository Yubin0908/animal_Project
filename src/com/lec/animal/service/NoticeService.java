package com.lec.animal.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.CommentDao;
import com.lec.animal.dao.NoticeDao;
import com.lex.animal.dto.CommentDto;
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
		String cpageNum = request.getParameter("cpageNum");
		if(cpageNum == null || cpageNum.equals("")) {
			cpageNum = "1";
		}
		String pageNum = request.getParameter("pageNum");
		if(pageNum != null || pageNum.equals("")) {
			pageNum = "1";
		}
		int cCurrPage = Integer.parseInt(cpageNum);
		final int PAGESIZE = 10, BLOCKSIZE = 5;
		int cstartRow = (cCurrPage -1) * PAGESIZE + 1;
		int cendRow = cstartRow + PAGESIZE - 1;
		CommentDao cDao = CommentDao.getInstance();
		ArrayList<CommentDto> comment = cDao.listComment(cstartRow, cendRow);
		request.setAttribute("commentList", comment);
		int ccnt = cDao.getCommentCnt(nid);
		int comno = ccnt - cstartRow + 1;
		int cpage = (int)Math.ceil((double)ccnt / PAGESIZE);
		int cstartPage = ((cCurrPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int cendPage = cstartPage + BLOCKSIZE - 1;
		if(cendPage > cpage) {
			cendPage = cpage;
		}
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", cstartPage);
		request.setAttribute("endPage", cendPage);
		request.setAttribute("page", cpage);
		request.setAttribute("cnt", ccnt);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cpageNum", cpageNum);
		request.setAttribute("omno", comno);
	}

}
