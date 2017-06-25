package com.cibil.gst.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cibil.gst.dao.impl.CustomerDaoImpl;
import com.cibil.gst.model.FixedLenghtModel;
import com.cibil.gst.service.Constant;
import com.mysql.jdbc.RowData;



public class CommonUtil {
	
	private Logger logger = Logger.getLogger(CommonUtil.class);
	
	private List<FixedLenghtModel> myList;
	FixedLenghtModel fixedLenghtModel = null;
	
	public List<FixedLenghtModel> parser(String wholeContent) throws IOException {
				
		myList = new ArrayList<FixedLenghtModel>();		
		
		if (wholeContent != null && wholeContent.length()%119==0) {
			System.out.println(wholeContent.length());
			String str = wholeContent;
		
			System.err.println(str.length());
			for (int i = 0; i < str.length(); i = i + 119) {
				fixedLenghtModel = new FixedLenghtModel();
			
				String rowData = str.substring(i, i + 119);
				fixedLenghtModel
						.setUserId(rowData.substring(Constant.User_id_start_position, Constant.User_id_end_position));
				fixedLenghtModel
						.setBruId(rowData.substring(Constant.User_id_end_position, Constant.Bureo_id_end_position));
				fixedLenghtModel.setIgnore_digit(
						rowData.substring(Constant.Bureo_id_end_position, Constant.Ignore_digit_end_position));
				fixedLenghtModel.setControllNumber(
						rowData.substring(Constant.Ignore_digit_end_position, Constant.Control_no_end_position));
				fixedLenghtModel.setReservedkey(
						rowData.substring(Constant.Control_no_end_position, Constant.Reserved_end_position));
				fixedLenghtModel.setDate(rowData.substring(Constant.Reserved_end_position, Constant.Date_end_position));
				fixedLenghtModel
						.setTimestamp(rowData.substring(Constant.Date_end_position, Constant.TimeStamp_end_position));
				fixedLenghtModel.setRefNumber(
						rowData.substring(Constant.TimeStamp_end_position, Constant.Reference_no_end_position));
				fixedLenghtModel
						.setCurrency1(rowData.substring(Constant.Reference_no_end_position, Constant.In_end_position));
				fixedLenghtModel.setLogic_identifier(
						rowData.substring(Constant.In_end_position, Constant.Logic_identifier_end_position));
				fixedLenghtModel.setExtra_values(
						rowData.substring(Constant.Logic_identifier_end_position, Constant.Extra_end_position));
				
				myList.add(fixedLenghtModel);
				
			}
		}else{
			logger.error("Invalid File ");
		}

		return myList;

	}
}
