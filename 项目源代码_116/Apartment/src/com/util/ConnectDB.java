package com.util;
import java.util.*;

import com.bean.UserLogin;

import java.sql.*;

public class ConnectDB {
	private static final String URL = "jdbc:mysql://localhost:3306/apartment?useUnicode=true&characterEncoding=utf-8";
	private static final String SqlName = "root";
	private static final String SqlPassword = "123456";
	private static final String JDBC = "org.gjt.mm.mysql.Driver";
	private  Connection conn;
	public Connection getConn() {
		return conn;
	}
	public ConnectDB() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(JDBC);
			conn = DriverManager.getConnection(URL,SqlName,SqlPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
