package com.yf.main.base;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UpLoadServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pathname=req.getServletContext().getRealPath("/")+"imgs";
		File file=new File(pathname);
		if(!file.exists()){
			file.mkdir();
		}
		SmartUpload smartUpload=new SmartUpload();
		smartUpload.initialize(getServletConfig(), req, resp);
		smartUpload.setAllowedFilesList("jpeg,png,jpg,gif");
		smartUpload.setMaxFileSize(1024*1024*10);
		smartUpload.setTotalMaxFileSize(1024*1024*50);
		try {
			smartUpload.save(pathname);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
	}

}
