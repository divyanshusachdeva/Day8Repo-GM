package com.graymatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyQuery {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/graymatterdb";
		String username = "root";
		String password = "password";
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection established.");
		
		
		String query = "UPDATE regions SET region_name = ? WHERE region_id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, "Oceania");
		ps.setInt(2, 6);
		
		ps.executeUpdate();
		
		Statement st = con.createStatement();
		String query1 = "SELECT * FROM regions";
		ResultSet rs = st.executeQuery(query1);
		
		while(rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		

		query = "DELETE FROM regions WHERE region_id = ?";
		ps = con.prepareStatement(query);
		
	
		ps.setInt(1, 7);
		
		ps.executeUpdate();
		
		st = con.createStatement();
		query1 = "SELECT * FROM regions";
		rs = st.executeQuery(query1);
		
		while(rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		
		
		
		
		
	}

}
