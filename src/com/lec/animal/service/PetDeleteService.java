package com.lec.animal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.PetDao;

public class PetDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int petid = Integer.parseInt(request.getParameter("petid")); 
		PetDao pDao = PetDao.getInstance();
		int result = pDao.deletePet(petid);
		if(result == PetDao.PASS) {
			request.setAttribute("petDeleteResult", "정상적으로 삭제되었습니다.");
		} else {
			request.setAttribute("petDeleteResult", "삭제 중 오류가 발생했습니다.");
		}
	}

}
