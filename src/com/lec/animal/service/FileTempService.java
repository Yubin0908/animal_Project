package com.lec.animal.service;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class FileTempService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Part filePart = request.getPart("file");
			  // 업로드 경로 설정 (여기서는 웹 애플리케이션 루트 디렉토리 아래에 uploads 디렉토리를 생성)
	        String uploadDirectory = getServletContext().getRealPath("") + "uploads" + java.io.File.separator;

	        // 파일명 추출
	        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

	        // 파일을 업로드 경로에 저장
	        filePart.write(uploadDirectory + fileName);

	        // 업로드한 파일의 경로를 request에 저장
	        request.setAttribute("uploadedFilePath", "uploads/" + fileName);

	        // 파일 업로드 JSP 페이지로 포워딩
	        request.getRequestDispatcher("/upload.jsp").forward(request, response);
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private ServletRequest getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

}
