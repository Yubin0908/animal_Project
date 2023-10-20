package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.PetDao;
import com.lex.animal.dto.PetDto;

public class PetModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int petid = Integer.parseInt(request.getParameter("petid"));
		PetDao pDao = PetDao.getInstance();
		PetDto pet = pDao.getPet(petid);
		request.setAttribute("pet", pet);

	}

}
