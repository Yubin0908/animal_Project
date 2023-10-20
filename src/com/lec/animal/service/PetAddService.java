package com.lec.animal.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.PetDao;
import com.lex.animal.dto.AdminDto;
import com.lex.animal.dto.PetDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PetAddService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("serverUploader");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mRequest = null;
		String petimg = "";
		int result = PetDao.FAIL;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			petimg = mRequest.getFilesystemName(param);
			HttpSession httpSession = request.getSession();
			AdminDto admin = (AdminDto)httpSession.getAttribute("admin");
			int comno = admin.getComno();
			String pettype = mRequest.getParameter("pettype");
			String petbrads = mRequest.getParameter("petbrads");
			String petname = mRequest.getParameter("petname");
			String petageStr = mRequest.getParameter("petage");
			int petage = Integer.parseInt(petageStr);
			String petpriceStr = mRequest.getParameter("petprice");
			int petprice = Integer.parseInt(petpriceStr);
			PetDao pDao = PetDao.getInstance();
			PetDto pet = new PetDto(0, comno, pettype, petbrads, petname, petage, petprice, petimg, null, 1);
			result = pDao.addPet(pet);
			if(result == PetDao.PASS) {
				request.setAttribute("PetAddResult", "정상적으로 등록되었습니다.");
				request.setAttribute("pettype", pettype);
			} else {
				request.setAttribute("PetAddResult", "등록에 실패하였습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "addPetService 에러");
		}
		
		if(petimg != null && result == PetDao.PASS) {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				File serverFile = new File(path+"/"+petimg);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/Project/source/08_1stProject/animal/WebContent/serverUploader/"+petimg);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int mByteCnt = is.read(bs);
					if(mByteCnt == -1) break;
					os.write(bs, 0, mByteCnt);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage() + "fileCopy 에러");
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (Exception e) {
					System.out.println(e.getMessage() + "File Copy[Close] 에러");
				}
			}
		}

	}

}
