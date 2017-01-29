package com.howtodoinjava.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlSample {

	public static final String DBURL = "jdbc:mysql://localhost:3306/practical";
	public static final String DBUSER = "practical";
	public static final String DBPASS = "practical";

	public static void main(String[] args) throws SQLException {

		// Load Oracle JDBC Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		// Connect to Oracle Database
		Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

		Statement statement = con.createStatement();

		// Execute a SELECT query on Oracle Dummy DUAL Table. Useful for
		// retrieving system values
		// Enables us to retrieve values as if querying from a table
		ResultSet rs = statement.executeQuery("SELECT count(*) FROM MY_EMPLOYEE");

		if (rs.next()) {
			//Date currentDate = rs.getDate(1); // get first column returned
			System.out.println("Current Date from MySql is : " + rs.getInt(1));
		}
		rs.close();
		statement.close();
		con.close();
	}
}
