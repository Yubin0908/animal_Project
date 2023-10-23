package com.lec.animal.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.animal.dao.ReviewDao;
import com.lex.animal.dto.MemberDto;
import com.lex.animal.dto.ReviewDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("serverUploader");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mRequest = null;
		String rimg = "";
		int result = ReviewDao.FAIL;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			rimg = mRequest.getFilesystemName(param);
			if(rimg == null) {
				rimg = "";
			}
			HttpSession httpSession = request.getSession();
			MemberDto member = (MemberDto)httpSession.getAttribute("member");
			String id = member.getId();
			String rtitle = mRequest.getParameter("rtitle");
			String rtext = mRequest.getParameter("rtext");
			if(rimg != null) {
				rimg = mRequest.getParameter("rimg");
			}
			String rip = request.getRemoteAddr();
			ReviewDao rDao = ReviewDao.getinstance();
			ReviewDto review = new ReviewDto(null, 0, id, null, rtitle, rtext, rimg, rip, 1);
			result = rDao.ReviewAdd(review);
			if(result == ReviewDao.PASS) {
				request.setAttribute("ReviewAddResult", "리뷰 작성 감사합니다.");
			} else {
				request.setAttribute("ReviewAddResult", "리뷰 등록에 실패하였습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "addReview 에러");
		}
		
		if(rimg != null && result == ReviewDao.PASS) {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				File serverFile = new File(path+"/"+rimg);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/Project/source/08_1stProject/animal/WebContent/serverUploader/"+rimg);
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
