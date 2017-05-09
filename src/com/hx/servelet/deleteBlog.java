package com.hx.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hx.de.DBOperation;

public class deleteBlog extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String blogid = request.getParameter("blogid");
		DBOperation dbOperation = new DBOperation();
		dbOperation.deleteBlogByID(blogid);
		response.sendRedirect("getBlog");
	}

}
