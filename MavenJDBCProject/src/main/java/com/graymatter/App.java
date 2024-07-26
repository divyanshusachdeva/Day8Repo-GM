package com.graymatter;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		
		String url = "jdbc:mysql://localhost:3306/graymatterdb";
		String username = "root";
		String password = "password";
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection established!");
		
		
		// Viewing the countries table
		Statement st = con.createStatement();
		String query1 = "SELECT * FROM countries";
		ResultSet rs = st.executeQuery(query1);
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
		}
		
		
		// Updating countries table
		String query2 = "UPDATE countries SET country_name = ? WHERE country_id = ?";
		PreparedStatement ps = con.prepareStatement(query2);
		
		ps.setString(1, "Bharat");
		ps.setString(2, "IN");
		
		ps.executeUpdate();
		
		
		st = con.createStatement();
		query1 = "SELECT * FROM countries";
		rs = st.executeQuery(query1);
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
		}	
			
		
		// Inserting values in countries table
		String query3 = "INSERT INTO countries(country_id,country_name,region_id) VALUES (?,?,?)";
		PreparedStatement ps2 = con.prepareStatement(query3);
		
		ps2.setString(1, "BH");
		ps2.setString(2, "Bharat");
		ps2.setInt(3, 3);
    
		
		st = con.createStatement();
		query1 = "SELECT * FROM countries";
		rs = st.executeQuery(query1);
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
			
		}	
		
		// Deleting values from countries table
		String query4 = "DELECT FROM regions WHERE country_id = ?";
		PreparedStatement ps3 = con.prepareStatement(query4);
		
		ps3.setString(1, "BH");
		
		
		st = con.createStatement();
		query1 = "SELECT * FROM countries";
		rs = st.executeQuery(query1);
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
		}

		ps.close();
		rs.close();
		st.close();
		con.close();
		
	}
}
		
    
    