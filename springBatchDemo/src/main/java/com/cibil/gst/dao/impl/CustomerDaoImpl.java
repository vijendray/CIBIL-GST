package com.cibil.gst.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cibil.gst.dao.CustomerDao;
import com.cibil.gst.utils.JDBCUtil;
import com.mysql.jdbc.PreparedStatement;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	private Logger logger = Logger.getLogger(CustomerDaoImpl.class);
	
	Map<String, String> defaultCodeMap=null;
	Map<Integer, List<String>> consumer_login_map_values = null;
	List<String> myList=null;
	
	/*private Connection con = JDBCUtil.getConnection("jdbc:mysql://localhost:3306/cibil_gst", "root", "admin");*/
	private Connection con = JDBCUtil.getConnection("jdbc:mysql://192.168.79.14:3306/cibil_db", "root", "SacSoft@123");
/*	private JDBCUtil jdbcUtil = new JDBCUtil();	
	private Connection connection = jdbcUtil.getConnection();*/
   	    
	@Override
	public Map<String, String> getDestination(String sql,String col1,String col2) {
		try {
			
			 
			logger.debug("CIBIL_GST CustomerDaoImpl  Enter into getDestination Methods");
			defaultCodeMap=new HashMap<String, String>();
			
			// connection=new JDBCUtil().getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String str1=rs.getString(col1);
				String str2=rs.getString(col2);
				defaultCodeMap.put(str1, str2);
				
			}
			logger.debug("CIBIL_GST CustomerDaoImpl Exits");
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return defaultCodeMap;
	}
	

	
	public void postFileDetails(String file_name, String file_size, String file_creation_date, String file_modified_date, String processed_date,String processed_by)  {
		String sql = "INSERT INTO input_file_details " +
                "VALUES ('"+file_name+"', '"+file_size+"', '"+file_creation_date+"', '"+file_modified_date+"', '"+processed_date+"', '"+processed_by+"')";
		try {
			
			logger.debug("CIBIL_GST CustomerDaoImpl getDestination Enter : postFileDetails Method");
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			int saveStatus = ps.executeUpdate(sql);
			System.out.println("Save Status "+saveStatus);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Map<Integer, List<String>> getDestinationForLogic1(String sql, String col1, String col2, String col3) {
		
		try{
			Integer index=0;
			
		consumer_login_map_values=new HashMap<Integer, List<String>>();
		
		List<String> list = new ArrayList<String>();
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			String str1=rs.getString(col1);
			String str2=rs.getString(col2);
			String str3 = rs.getString(col3);
			list.add(str1);
			list.add(str2);
			list.add(str3);			
			consumer_login_map_values.put(index, list);
			index++;			
		}
	} catch (Exception e) {
		logger.error(e.getMessage());
		e.printStackTrace();
	}		return consumer_login_map_values;
	}


}
