package com.hx.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hx.bean.User;
import com.hx.de.DBOperation;

public class getUserChart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DBOperation dbOperation = new DBOperation();
		ArrayList<User> users = dbOperation.getUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/tables.jsp").forward(request, response);
	}
	
}
