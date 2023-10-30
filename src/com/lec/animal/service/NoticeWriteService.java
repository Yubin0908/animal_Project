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

import com.lec.animal.dao.NoticeDao;
import com.lec.animal.dao.ReviewDao;
import com.lex.animal.dto.AdminDto;
import com.lex.animal.dto.MemberDto;
import com.lex.animal.dto.NoticeDto;
import com.lex.animal.dto.ReviewDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("serverUploader");
		int maxSize = 1024 * 1024 * 10;
		MultipartRequest mRequest = null;
		String nimg = "";
		int result = NoticeDao.FAIL;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			nimg = mRequest.getFilesystemName(param);
			HttpSession httpSession = request.getSession();
			AdminDto admin = (AdminDto)httpSession.getAttribute("admin");
			int comno = admin.getComno();
			String ntitle = mRequest.getParameter("ntitle");
			String ntext = mRequest.getParameter("ntext");
			String nip = request.getRemoteAddr();
			NoticeDao nDao = NoticeDao.getInstance();
			NoticeDto notice = new NoticeDto(0, comno, null, ntitle, ntext, nimg, nip, 0);
			result = nDao.addNotice(notice);
			if(result == NoticeDao.PASS) {
				request.setAttribute("NoticeMsg", "공지사항이 등록되었습니다.");
			} else {
				request.setAttribute("ReviewAddResult", "공지사항이 등록되지 않았습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "addNotice 에러");
		}
		
		if(nimg != null && result == ReviewDao.PASS) {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				File serverFile = new File(path+"/"+nimg);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/Project/source/08_1stProject/animal/WebContent/serverUploader/"+nimg);
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
