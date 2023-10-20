package com.lec.animal.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.PetDao;
import com.lex.animal.dto.PetDto;

public class PetListFilterEtcService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String petbrads = request.getParameter("petbrads");
		String pettype = request.getParameter("pettype");
		PetDao pDao = PetDao.getInstance();
		if(pettype.equals("고양이")) {
			ArrayList<PetDto> filterPet = pDao.filterEtcCat(pettype);
			int cnt = pDao.getPetCnt(pettype);
			request.setAttribute("listPet", filterPet);
			request.setAttribute("pettype", pettype);
			request.setAttribute("cnt", cnt);
		} else {
			ArrayList<PetDto> filterPet = pDao.filterEtcDog(pettype);
			int cnt = pDao.getPetCnt(pettype);
			request.setAttribute("listPet", filterPet);
			request.setAttribute("pettype", pettype);
			request.setAttribute("cnt", cnt);
		}
			
	}

}
