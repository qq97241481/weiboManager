package com.hx.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hx.bean.Blog;
import com.hx.bean.User;
import com.hx.de.DBOperation;

public class getUserinfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBOperation dbOperation = new DBOperation();
		User user= dbOperation.getUserInfo();
		ArrayList<Blog> blogsHot = dbOperation.getBlogsByHot();
		ArrayList<Blog> blogsNow = dbOperation.getBlogsByNow();
		
		request.setAttribute("blogsNow", blogsNow);
		request.setAttribute("blogsHot", blogsHot);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
