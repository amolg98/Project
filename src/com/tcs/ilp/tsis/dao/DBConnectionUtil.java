package com.tcs.ilp.tsis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionUtil {
	private static final String USERNAME="PJ01Test_T166";
	private static final String PASSWORD="tcstvm100";
	private static final String URL="jdbc:oracle:thin:@172.26.48.80:1521:ORAJAVADB";
	private static Connection conn=null;
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("class not found");
			cnfe.printStackTrace();
		}
	}
	
	private static DataSource ds = null;
	
	public static Connection getConnection()throws NamingException, SQLException
	{
		//lookup the datasource resourse
		Connection conn = null;
		Context initContext = null;

			if(ds ==null){
				initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				ds = (DataSource) envContext.lookup("jdbc/mysqlds");
				conn = ds.getConnection();
			}
			else{
				conn = ds.getConnection();
			}	

		return conn;
	}	
	
	public static void closeConnection(Connection conn)
	{
		if(conn!=null)
		{
		   try
		   {
			   conn.close();
		   }
		   catch (Exception e) 
		   {
			   e.printStackTrace();
		   }
	   }
   }
}
