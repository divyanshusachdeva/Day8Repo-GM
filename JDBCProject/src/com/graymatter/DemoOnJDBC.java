package com.graymatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoOnJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		
		String url = "jdbc:mysql://localhost:3306/graymatterdb";
		String username = "root";
		String password = "password";
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection established!");
		
//		Statement st = con.createStatement();							// THis is for retrieving the data
//		String query = "Select first_name, employee_id from employees";
//		ResultSet rs = st.executeQuery(query);
//		
//		while(rs.next()) {
//			
//			System.out.println(rs.getString(1)+ "	" + rs.getInt(2));
//
//		}

//		String query = "INSERT INTO regions(region_id,region_name) VALUES (?,?)";
//		PreparedStatement ps = con.prepareStatement(query);
//		ps.setInt(1, 6);
//		ps.setString(2, "Australia");
//		int row = ps.executeUpdate();
//		System.out.println("Row inserted: " + row);
//		
//		
//		
		
		Statement st = con.createStatement();							// This is for retrieving the data
		String query1 = "Select * from regions";
		ResultSet rs = st.executeQuery(query1);		// use MetaData for displaying the table headings as well

//		ResultSetMetaData rs = rs.getMetaData();
		
		while(rs.next()) {
		
			System.out.println(rs.getInt(1)+ "	" + rs.getString(2));

		}
		
		
		
//		ps.close();
//		rs.close();
//		st.close();
		con.close();
		
		
		
		
		
		
		
	}
}
