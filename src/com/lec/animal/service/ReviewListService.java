package com.lec.animal.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.ReviewDao;
import com.lex.animal.dto.ReviewDto;

public class ReviewListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			if(request.getAttribute("pageNum")!=null) {
				pageNum = (String)request.getAttribute("pageNum");
			} else {
				pageNum = "1";
			}
		}
		int currPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 15, BLOCKSIZE = 5;
		int startRow = (currPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		ReviewDao rDao = ReviewDao.getinstance();
		ArrayList<ReviewDto> reviewList = rDao.listReview(startRow, endRow);
		request.setAttribute("reviewList", reviewList);
		int cnt = rDao.getReviewCnt();
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
