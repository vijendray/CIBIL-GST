package com.cibil.gst.service;

import java.util.List;

public interface CustomerService {
	
	public List<String> getDestinationLogic1(String userId, String requestDate, String memberName);
	
	public List<String> getDestinationLogic2(String userId, String requestDate, String memberName);
	
	public List<String> getDestinationLogic3(String userId, String requestDate, String memberName);
	
	public List<String> getDestinationLogic4(String userId, String requestDate, String memberName);
	
	public List<String> getDestinationLogic5(String userId, String requestDate, String memberName);

//	List<String> getDestinationLogic1(String userId, String requestDate, String memberName);

}
