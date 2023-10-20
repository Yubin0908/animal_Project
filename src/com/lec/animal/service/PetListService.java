package com.lec.animal.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.animal.dao.PetDao;
import com.lex.animal.dto.PetDto;

public class PetListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		String pettype = request.getParameter("pettype");
		final int PAGESIZE = 12, BLOCKSIZE = 5;
		if(pettype == null) {
			pettype = "고양이";
		}
		
		if(pageNum == null) {
			if(request.getAttribute("pageNum")!=null) {
				pageNum = (String)request.getAttribute("pageNum");
			} else {
				pageNum = "1";
			}
		}
		int currPage = Integer.parseInt(pageNum);
		
		int startRow = (currPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		PetDao pDao = PetDao.getInstance();
		if(pettype.equals("고양이")) {
			ArrayList<PetDto> listPet = pDao.listCat(startRow, endRow);
			request.setAttribute("listPet", listPet);
			int cnt = pDao.getPetCnt(pettype);
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
			request.setAttribute("pettype", pettype);
		} else if(pettype.equals("강아지")) {
			ArrayList<PetDto> listPet = pDao.listDog(startRow, endRow);
			request.setAttribute("listPet", listPet);
			int cnt = pDao.getPetCnt(pettype);
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
			request.setAttribute("pettype", pettype);
		} 
		
	}

}
