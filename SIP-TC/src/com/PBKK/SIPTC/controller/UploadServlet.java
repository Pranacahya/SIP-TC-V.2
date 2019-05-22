package com.PBKK.SIPTC.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// checks if the request actually contains upload file
		try
		{
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles = sf.parseRequest(request);
			System.out.println("test");
			for(FileItem item : multifiles)
			{
				item.write(new File("/Users/Pranacahya/" + item.getName()));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
//		if (!ServletFileUpload.isMultipartContent(request)) {
//		    PrintWriter writer = response.getWriter();
//		    writer.println("Request does not contain upload data");
//		    writer.flush();
//		    return;
//		super.doPost(req, resp);
	}
}
