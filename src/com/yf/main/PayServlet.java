package com.yf.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String account=request.getParameter("account");
		String bills=request.getParameter("bills");
		if(account!=null&&bills!=null){
			System.out.println("向【"+account+"】账户转账"+bills+"元成功");
		}else{
			System.out.println("转账失败");
		}
		out.flush();
		out.close();
	}

}
