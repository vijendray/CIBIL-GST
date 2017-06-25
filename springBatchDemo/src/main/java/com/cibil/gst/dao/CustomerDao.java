package com.cibil.gst.dao;

import java.util.List;
import java.util.Map;

public interface CustomerDao {

	public Map<String, String> getDestination(String sql,String col1,String col2);
	public void postFileDetails(String file_name, String file_size, String file_creation_date, String file_modified_date, String processed_date, String processed_by);
	// public List<Map<String, String>> getDestinationForLogic1(String sql, String col1, String col2, String col3);
	
	public Map<Integer, List<String>> getDestinationForLogic1(String sql, String col1, String col2, String col3);
}
