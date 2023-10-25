package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.CommentDao;

public class CommentModifyVIewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		CommentDao cDao = CommentDao.getInstance();
		int mid = Integer.parseInt(request.getParameter("mid"));
		request.setAttribute("comment", cDao.getComment(mid));
	}

}
