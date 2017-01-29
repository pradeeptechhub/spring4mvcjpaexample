package com.howtodoinjava.demo.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleSample {

	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String DBUSER = "practical";
	public static final String DBPASS = "oracle";

	public static void main(String[] args) throws SQLException {

		// Load Oracle JDBC Driver
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		// Connect to Oracle Database
		Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

		Statement statement = con.createStatement();

		// Execute a SELECT query on Oracle Dummy DUAL Table. Useful for
		// retrieving system values
		// Enables us to retrieve values as if querying from a table
		ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");

		if (rs.next()) {
			Date currentDate = rs.getDate(1); // get first column returned
			System.out.println("Current Date from Oracle is : " + currentDate);
		}
		rs.close();
		statement.close();
		con.close();
	}
}
