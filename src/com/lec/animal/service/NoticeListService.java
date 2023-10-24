package com.lec.animal.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.NoticeDao;
import com.lex.animal.dto.NoticeDto;

public class NoticeListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		final int PAGESIZE = 5, BLOCKSIZE = 5;
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int currPage = Integer.parseInt(pageNum);
		int startRow = (currPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		NoticeDao nDao = NoticeDao.getInstance();
		ArrayList<NoticeDto> listNotice = nDao.listNotice(startRow, endRow);
		request.setAttribute("listNotice", listNotice);
		int cnt = nDao.getNoticeCnt();
		int page = (int)Math.ceil((double)cnt / PAGESIZE);
		int startPage = ((currPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > page) {
			endPage = page;
		}
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("page", page);
		request.setAttribute("cnt", cnt);
		request.setAttribute("pageNum", pageNum);
	}

}
