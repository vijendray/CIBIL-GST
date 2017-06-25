package com.cibil.gst.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cibil.gst.dao.CustomerDao;
import com.cibil.gst.dao.impl.CustomerDaoImpl;
import com.cibil.gst.service.Constant;
import com.cibil.gst.service.CustomerService;

import org.apache.log4j.Logger;

public class CustomerServiceImpl implements CustomerService {
 /*
  * @Autowired private CustomerDao customerDao;
  */

	private Logger logger = Logger.getLogger(CustomerServiceImpl.class);

	 Map<String, String> defaultCodeMap = null;
	 Map<String, String> consumer_login_map = null;
	 Map<String, String> commercial_login_map = null;
	 Map<Integer, List<String>> consumer_login_map_uniquekey = null;
	 List<Map<String, String>> myList = null;
	 
	 private CustomerDao customerDao = new CustomerDaoImpl(); 
	 
	 
	 //= new CustomerDaoImpl();
	 
	 List<String> list = null;
	 
	 int count = 0;

 // Logic1 check for TicketId and UserId
 @Override
 public List<String> getDestinationLogic1(String userId, String requestDate, String memberName) {
	 
		 logger.debug("CIBIL_GST CustomerServiceImpl Logic 1 Enter :");
		 
		 String des;
		 String userIdUpperCase = userId.toUpperCase();
		 String memberNameUpperCase = memberName.toUpperCase();
		 
		 List<String> list1 = new ArrayList<String>();
	  
		  String sql1 = "SELECT "
		    + " user_id,member_name,gst_state_code from consumer_login_id where upper(user_id) = '" + userIdUpperCase
		    + "'and upper(member_name)= '" + memberNameUpperCase + "'";
		  
		  consumer_login_map_uniquekey = customerDao.getDestinationForLogic1(sql1, "member_name", "user_id",
		    "gst_state_code");
		  
		   list = new ArrayList<String>();
		   
		  if (!consumer_login_map_uniquekey.isEmpty()) {
		   for (Integer key : consumer_login_map_uniquekey.keySet()) {
		    list1 = consumer_login_map_uniquekey.get(key);
		       
		   }
		   des = list1.get(2);
		   //String des1 = des.substring((des.length()-2, des.substring(des.length()));
		   String code = list1.get(2).substring(Math.max(des.length() - 2, 0));
		   list.add(code);
		   list.add(Constant.Logic1_flag);

	  } 
		  logger.debug("CIBIL_GST CustomerDaoImpl Logic 1 Exits.");
		  
		  return list;
 }

 
 // Logic2 check it for userId
 @Override
 public List<String> getDestinationLogic2(String userId, String requestDate, String memberName) {
	
	 logger.debug("CIBIL_GST CustomerServiceImpl Logic 2 Enter");
	 
	  String des;
	
	  String userIdUpperCase = userId.toUpperCase().trim();
	  if(userIdUpperCase.length() >= 10)
	  {
		  userIdUpperCase = userIdUpperCase.substring(0, 10);
	  }
	  
	  list = new ArrayList<String>();
	
	  String sql1 = "SELECT user_id,gst_state_code from commercial_login_id_new where upper(user_id) = '" + userIdUpperCase + "'";
	  consumer_login_map = customerDao.getDestination(sql1, "user_id", "gst_state_code");
	
	  
	  if (!consumer_login_map.isEmpty()) {
				  
		 // Convert all key values to uppercase
		  
		  for (Map.Entry<String, String> entry : consumer_login_map.entrySet()) {
			  consumer_login_map.put(entry.getKey().toUpperCase(), entry.getValue());
			}
		  
	   des = consumer_login_map.get(userIdUpperCase);
	 	   
	   String code = des.substring(Math.max(des.length() - 2, 0));
	   list.add(code);
	   list.add(Constant.Logic2_flag);
	
	   logger.debug("CIBIL_GST CustomerServiceImpl Logic 2 Exits.");
	   
	  } 
	  return list;

 }

 // Logic3 check it for userId first 10 digit
 @Override
 public List<String> getDestinationLogic3(String userId, String requestDate, String memberName) {
	 
	 logger.debug("CIBIL_GST CustomerServiceImpl Logic 3 Enter");
	 
	  String des;
	  String userIdUpperCase = userId.toUpperCase();
	  list = new ArrayList<String>();
	
	  String sql1 = "SELECT user_id,gst_state_code from commercial_login_id_new where upper(user_id) = '" + userIdUpperCase + "'";
	  consumer_login_map = customerDao.getDestination(sql1, "user_id", "gst_state_code");
	
	  if (!consumer_login_map.isEmpty()) {
	
	   des = consumer_login_map.get(userIdUpperCase);
	   String code = des.substring(Math.max(des.length() - 2, 0));
	   list.add(code);
	   list.add(Constant.Logic3_flag);

	   logger.debug("CIBIL_GST CustomerServiceImpl Logic 3 Exits.");
	   
	  }

  return list;

 }

 // Logic4 check it for userId first 6 digit
 @Override
 public List<String> getDestinationLogic4(String userId, String requestDate, String memberName) {
 
	 logger.debug("CIBIL_GST CustomerServiceImpl Logic 4 Enter");
	 
	 String des;
	 String userIdUpperCase = userId.toUpperCase().trim();
	 list = new ArrayList<String>();

	 userIdUpperCase = userId.substring(0, 6).toUpperCase();

	  String sql1 = "SELECT user_id,gst_state_code from default_code where upper(user_id) = '"+userIdUpperCase +"'";
	  
	  consumer_login_map = customerDao.getDestination(sql1, "user_id", "gst_state_code");
	
	  if (!consumer_login_map.isEmpty()) {
	   
	  
	   des = consumer_login_map.get(userIdUpperCase);
	   String code = des.substring(Math.max(des.length() - 2, 0));
	   list.add(code);
	   list.add(Constant.Logic4_flag);
	
	   logger.debug("CIBIL_GST CustomerServiceImpl Logic 4 Exits.");
	   
	  } 

  return list;
 }

 // Logic5 check it for File name
 @Override
 public List<String> getDestinationLogic5(String file_name, String member_code, String start_date_value) {
  
	 logger.debug("CIBIL_GST CustomerServiceImpl Logic 5 Enter");
	 
	  String des;
	  String fileNameUpperCase = file_name.toUpperCase().trim();
	  String memberCOdeUpperCase = member_code.toUpperCase().trim();
	  
	  List<String> list1 = new ArrayList<String>();
	  
	  String sql1 = "SELECT "
	    + " file_name,start_date,gst_state_code from advisor_billing where upper(file_name) = '" + fileNameUpperCase
	    + "'and upper(member_code)= '" + memberCOdeUpperCase + "'";
	  
	  consumer_login_map_uniquekey = customerDao.getDestinationForLogic1(sql1, "file_name", "start_date",
	    "gst_state_code");
	  
	  	  
	  list = new ArrayList<String>();
	  
	  if (!consumer_login_map_uniquekey.isEmpty()) {
	   for (Integer key : consumer_login_map_uniquekey.keySet()) {
	    list1 = consumer_login_map_uniquekey.get(key);
	       
	   }
	   des = list1.get(2);
	   String code = des.substring(Math.max(des.length() - 2, 0));
	   list.add(code);
	   list.add(Constant.Logic5_flag);

	   logger.debug("CIBIL_GST CustomerServiceImpl Logic 5 Exits.");
	   
 	 } 
  return list;
 }


}