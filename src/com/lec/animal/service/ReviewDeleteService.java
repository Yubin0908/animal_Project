package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.ReviewDao;

public class ReviewDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rid = Integer.parseInt(request.getParameter("rid"));
		ReviewDao rDao = ReviewDao.getinstance();
		int result = rDao.deleteReview(rid);
		if(result == ReviewDao.PASS) {
			request.setAttribute("ReviewAddResult", "리뷰가 삭제되었습니다.");
		} else {
			request.setAttribute("ReviewAddResult", "리뷰가 삭제되지않았습니다.");
		}

	}

}
