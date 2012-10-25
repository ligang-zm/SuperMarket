package com.lg.common;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBTool {
	private static DBTool instance;
	private DBTool() //单例 Singleton
	{
		
	}
	public static synchronized DBTool getInstance()
	{
		if(instance == null)
		{
			instance = new DBTool();
		}
		return instance;
	}
	public Connection getConnection()
	{
		Connection conn = null;
		try
		{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
			conn=ds.getConnection();//直接从连接池数据源中取得一个连接
			
//			// 1、注册驱动
//			Class.forName("com.mysql.jdbc.Driver");
//			// 2、创建连接指定连接字符串
//			String url = "jdbc:mysql://192.168.11.39:3306/mydb";
//			// 2、创建连接对象，根据连接字符串
//			conn = DriverManager.getConnection(url, "wxniit", "1234");
		}
	catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return (Connection) conn;
	}

	public static void closeAll( Statement stmt, ResultSet rs)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
				rs = null;
			}
			if (stmt != null)
			{
				stmt.close();
				stmt = null;
			}
			 
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




