package com.hx.de;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.hx.bean.Blog;
import com.hx.bean.Comments;
import com.hx.bean.Message;
import com.hx.bean.User;

public class DBOperation {
	DBConnect DateBase = new DBConnect();
	Connection connection;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;

	public boolean getUserFromDB(User user) {
		String queryUser = "select * from user where name = '"
				+ user.getUsername() + "'";
		connection = DateBase.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryUser);
			while (resultSet.next()) {
				if (resultSet.getString("password").equals(user.getPassword())) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public User getUserInfo() {
		String queryUser = "select * from user";
		User user = new User();
		connection = DateBase.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryUser);
			int i = 0;
			while (resultSet.next()) {
				i++;
			}
			user.setUserCount((i - 1) + "");
			user.setNewUser("0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String queryBlog = "select * from question";
		connection = DateBase.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryBlog);
			int i = 0;
			while (resultSet.next()) {
				i++;
			}
			user.setBlogCount(i+ "");
			user.setNewBlog("0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	
	public ArrayList<User> getUsers(){
		String queryUser = "select * from user";
		ArrayList<User> users = new ArrayList<User>();
		connection = DateBase.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryUser);
			while (resultSet.next()) {
				users.add(new User(resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("head_url")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	

	public ArrayList<Blog> getBlogs(){
		String queryBlog = "select * from question left join user on question.user_id = user.id ";
		ArrayList<Blog> blogs = new ArrayList<Blog>();
		connection = DateBase.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryBlog);
			while (resultSet.next()) {
				blogs.add(new Blog(resultSet.getString("id"),resultSet.getString("title"),resultSet.getString("content"),resultSet.getString("name"),resultSet.getString("created_date"),resultSet.getString("comment_count"),resultSet.getString("head_url")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blogs;
	}
	
	public ArrayList<Blog> getBlogsByHot(){
		String queryBlog = "select * from question left join user on question.user_id = user.id order by comment_count desc limit 0,5";
		ArrayList<Blog> blogs = new ArrayList<Blog>();
		connection = DateBase.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryBlog);
			while (resultSet.next()) {
				blogs.add(new Blog(resultSet.getString("id"),resultSet.getString("title"),resultSet.getString("content"),resultSet.getString("name"),resultSet.getString("created_date"),resultSet.getString("comment_count"),resultSet.getString("head_url")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blogs;
	}
	
	public ArrayList<Blog> getBlogsByNow(){
		String queryBlog = "select * from question left join user on question.user_id = user.id order by created_date asc limit 0,5";
		ArrayList<Blog> blogs = new ArrayList<Blog>();
		connection = DateBase.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryBlog);
			while (resultSet.next()) {
				blogs.add(new Blog(resultSet.getString("id"),resultSet.getString("title"),resultSet.getString("content"),resultSet.getString("name"),resultSet.getString("created_date"),resultSet.getString("comment_count"),resultSet.getString("head_url")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blogs;
	}
	
	public Blog getBlogsByID(String id){
		String queryBlog = "select * from question left join user on question.user_id = user.id where question.id = '"+id+"'";
		Blog blogs = null;
		connection = DateBase.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryBlog);
			while (resultSet.next()) {
				blogs = new Blog(resultSet.getString("id"),resultSet.getString("title"),resultSet.getString("content"),resultSet.getString("name"),resultSet.getString("created_date"),resultSet.getString("comment_count"),resultSet.getString("head_url"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blogs;
	}
	
	public ArrayList<Comments> getCommentsByID(String id){
		String queryComments = "select * from comment left join user on comment.user_id = user.id left join question on comment.entity_id = question.id where question.id = '"+id+"'";
		ArrayList<Comments> comments = new ArrayList<Comments>();
		connection = DateBase.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryComments);
			while (resultSet.next()) {
				comments.add(new Comments(resultSet.getString("id"), resultSet.getString("content"),  resultSet.getString("name"), resultSet.getString("created_date"), resultSet.getString("entity_id")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}
	
	public void deleteCommentsByID(String id){
		String queryComment = "select * from comment where id = '"+id+"'" ;
		String updateComments = "update question  set comment_count = ?  where id = ?" ;
		
		connection = DateBase.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryComment);
			String blogid = null;
			if(resultSet.next()){
				blogid = resultSet.getString("entity_id");
			}
			
			String queryBlog = "select * from question where id = '"+blogid+"'" ;
			resultSet = statement.executeQuery(queryBlog);
			int count = 0;
			if(resultSet.next()){
				count = resultSet.getInt("comment_count");
				preparedStatement = connection.prepareStatement(updateComments);
				preparedStatement.setInt(1, count-1);
				preparedStatement.setString(2, blogid);
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String deleteComments = "delete from comment where id = '"+id+"'";
		connection = DateBase.getConnection();
		try {
			preparedStatement = connection.prepareStatement(deleteComments);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertMessage(Message message){
		String insertMessage = "insert into message values(NULL , ? , ? , ? , ? , ? , ?)" ;
		connection = DateBase.getConnection();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			preparedStatement = connection.prepareStatement(insertMessage);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, Integer.parseInt(message.getToid()));
			preparedStatement.setString(3, message.getContent());
			preparedStatement.setString(4, df.format(new Date()));
			preparedStatement.setString(5, "0");
			preparedStatement.setString(6, message.getToid()+"_0");
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public void deleteUserByID(String id){
		String deleteUser = "delete from user where id = '"+id+"'";
		connection = DateBase.getConnection();
		try {
			preparedStatement = connection.prepareStatement(deleteUser);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBlogByID(String id){
		String deleteBlog = "delete from question where id = '"+id+"'";
		connection = DateBase.getConnection();
		try {
			preparedStatement = connection.prepareStatement(deleteBlog);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
