package com.hx.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hx.bean.Blog;
import com.hx.de.DBOperation;

public class getBlog extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBOperation dbOperation = new DBOperation();
		ArrayList<Blog> blogs =dbOperation.getBlogs();
		request.setAttribute("blogs", blogs);
		request.getRequestDispatcher("/blog.jsp").forward(request, response);
	}

}
