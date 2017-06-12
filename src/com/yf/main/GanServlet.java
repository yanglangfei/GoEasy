package com.yf.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.utils.ClimbUtils;

public class GanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url="http://gank.io/api/data/¸£Àû/10/1";
	private Map<String, String> param=new HashMap<>();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.addHeader("Access-Control-Allow-Origin","*");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String res = ClimbUtils.get(url, null, null);
		out.print(res);
		out.flush();
		out.close();
	}

}
