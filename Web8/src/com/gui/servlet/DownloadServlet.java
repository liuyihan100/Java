package com.gui.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String fileName = request.getParameter("fileName");
		response.addHeader("content-Type", "application/octet-stream");
		response.setHeader("content-Disposition", "attachment;filename=\"" + new String(fileName.getBytes(),"iso8859-1") + "\"");
		InputStream is = getServletContext().getResourceAsStream(fileName);
		ServletOutputStream os = response.getOutputStream();
		byte[] b = new byte[10];
		int len = -1;
		while((len = is.read(b)) != -1) {
			os.write(b, 0, len);
		}
		os.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
