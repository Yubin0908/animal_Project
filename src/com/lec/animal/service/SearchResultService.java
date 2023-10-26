package com.lec.animal.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.PetDao;
import com.lex.animal.dto.PetDto;

public class SearchResultService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String searchKeyword = request.getParameter("searchKeyword");
		System.out.println("검색 키워드 : " + searchKeyword);
		PetDao pDao = PetDao.getInstance();
		ArrayList<PetDto> searchPet = pDao.searchPet(searchKeyword);
		request.setAttribute("searchResult", searchPet);
	}

}
