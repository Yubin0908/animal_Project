package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.ReviewDao;
import com.lex.animal.dto.ReviewDto;

public class ReviewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rid = Integer.parseInt(request.getParameter("rid"));
		ReviewDao rDao = ReviewDao.getinstance();
		ReviewDto review = rDao.getReview(rid);
		request.setAttribute("review", review);

	}

}
