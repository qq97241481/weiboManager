package com.hx.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hx.bean.Message;
import com.hx.de.DBOperation;

public class MesaageServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String msg = new String(request.getParameter("msg-box").getBytes("ISO-8859-1"),"UTF-8");
		Message message = new Message("0", user, msg, null, "0", null);
		DBOperation dbOperation = new DBOperation();
		boolean flag = dbOperation.insertMessage(message);
		if(flag){
			request.setAttribute("flag", "0");
			response.sendRedirect("getUserChart");
		}else{
			request.setAttribute("flag", "1");
		}
	}


}
