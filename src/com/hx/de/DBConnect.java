package com.hx.de;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {
	String DBDriver="com.mysql.jdbc.Driver";
	Connection connection=null;
	
	public DBConnect(){
		try {
			Class.forName(DBDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动未找到");
		}
	}
	public  Connection getConnection(){
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}	
}
