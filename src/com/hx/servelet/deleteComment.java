package com.hx.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hx.bean.Blog;
import com.hx.bean.Comments;
import com.hx.de.DBOperation;

public class deleteComment extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commentid = request.getParameter("commentid");
		String blogId = request.getParameter("blogid");
		DBOperation dbOperation = new DBOperation();
		dbOperation.deleteCommentsByID(commentid);
		Blog blog= dbOperation.getBlogsByID(blogId);
		ArrayList<Comments> comments = dbOperation.getCommentsByID(blogId);
		request.setAttribute("comments", comments);
		request.setAttribute("blog", blog);
		request.getRequestDispatcher("/bloginfo.jsp").forward(request, response);
	}

}
