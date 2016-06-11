package db;

import java.sql.*;
import java.util.Properties;
import java.io.*;

public class DBUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static Properties pros = new Properties();
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	//读取配置文件
	static { // 静态代码块，只加载一次
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = pros.getProperty("driver");
		url = pros.getProperty("url");
		user = pros.getProperty("user");
		pwd = pros.getProperty("pwd");
	}
	
	public static Connection open(){
		String DB = pros.getProperty("db");
		if (DB.equals("sqlite")) {
			return open1();
		} else if (DB.equals("mysql")) {
			return open2();
		} else {
			return null;
		}
		
	}
	private static Connection open1() {
		try {
			Class.forName(driver);
			try {
				return DriverManager.getConnection(url);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Connection open2() {
		try {
			Class.forName(driver);
			try {
				return DriverManager.getConnection(url,user,pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection Conn) {
		if (Conn != null) {
			try {
				Conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
