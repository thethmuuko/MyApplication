package com.samuel.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MyConnection {
	
	private MyConnection() {}
	
	public static Connection getConnection() {
		try {
			 return DriverManager.getConnection("jdbc:mysql://localhost:3306/testDb", "mosaka", "$mosaka#");
			//return DriverManager.getConnection("jdbc:mysql://localhost:3306/testDb?user=mosaka&password=$mosaka#");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
