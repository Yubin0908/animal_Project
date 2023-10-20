package com.lec.animal.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.PetDao;
import com.lex.animal.dto.PetDto;

public class MainPetListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		PetDao pDao = PetDao.getInstance();
		ArrayList<PetDto> catListMain = pDao.mainPetList("고양이");
		request.setAttribute("catListMain", catListMain);
		ArrayList<PetDto> dogListMain = pDao.mainPetList("강아지");
		request.setAttribute("dogListMain", dogListMain);
	}

}
