package com.giffgaff.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;


@Repository
public class MysqlConnection {   //This method will create connection to database

	Connection conn;
	public Connection getConnection() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		conn=DriverManager.getConnection(  
		"jdbc:mysql://localhost/student","root","root"); 
		}
		catch(Exception e){ 
			System.out.println(e);
		} 
		return conn;
		
	}
	
	public void closeConnection() {  //This method will close connection to database
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  
}
