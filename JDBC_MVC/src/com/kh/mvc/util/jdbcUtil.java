/**
 * 
 */
package com.kh.mvc.util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtil {
	

	/* 
	 * JDBC API 사용 중 중복 코드가 너무 많음
	 * 중복된 코드를 메소드로 분리하여 필요할 때 마다 재사용 하자
	 */
	
	public static Connection getConnection() {

		final String URL = "jdbc:oracle:thin:@192.168.130.17:1521:xe";
		final String USERNAME = "KH09_KHS";
		final String PASSWORD = "KH1234";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (SQLException e) {	
			e.printStackTrace();
		
		}
		return conn;
	}
	
	public static void  close(Statement stmt) {
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("PreparedStatement 이상");
		}
	}
	
}

