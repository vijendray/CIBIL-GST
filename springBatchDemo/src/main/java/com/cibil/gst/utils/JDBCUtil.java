package com.cibil.gst.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	private static Connection con=null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(String  url,String user,String password){
		try{
			con=DriverManager.getConnection(url,user,password);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			/*try{
				if(con!=null){
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}*/
		}
		return con;
	}
	
}
