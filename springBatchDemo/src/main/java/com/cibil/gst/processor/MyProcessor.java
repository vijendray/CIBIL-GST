package com.cibil.gst.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.cibil.gst.batch.entity.Service;
import com.cibil.gst.batch.entity.ServiceImpl;
import com.cibil.gst.model.FixedLenghtModel;
import com.cibil.gst.service.Constant;
import com.cibil.gst.service.CustomerService;
import com.cibil.gst.service.impl.CustomerServiceImpl;
import com.cibil.gst.utils.CommonUtil;


public class MyProcessor implements ItemProcessor<String, String> {

	
	private List<FixedLenghtModel> myList2;
	private String content="";
	private List<String> list_to_writer;
	private CommonUtil commonUtil;
	private List<String> listval;
	
	private  Service service;
	
	
	@Override
	public String process(String wholeContent) throws Exception {		
		
System.out.println("******************came to process*************");
		
		//Service service=new ServiceImpl();
		
		/*System.out.println(service);
		System.out.println(service.getUserEntity());*/
		
		
		
		
		myList2 = new ArrayList<FixedLenghtModel>();
		//commonUtil=new CommonUtil();
		
		
		myList2 = commonUtil.parser(wholeContent);
		
			for(FixedLenghtModel item:myList2){
			
			 listval = new ArrayList<String>();
			 listval = Calllogics(item);
			
			if (listval != null && listval.size() > 0) {
				String bruId = item.getBruId();
				String newBrue_id = bruId.substring(0, 2) + listval.get(0);
				item.setBruId(newBrue_id);
				
				if(listval!=null &&listval.size()>1){
					item.setReservedkey(listval.get(1));
				}
				
				content = content + item.getUserId() + item.getBruId() + item.getIgnore_digit()
						+ item.getControllNumber() + item.getReservedkey() + item.getDate() + item.getTimestamp()
						+ item.getRefNumber() + item.getCurrency1() + item.getLogic_identifier()
						+ item.getExtra_values();

			} else {

				content = content + item.getUserId() + item.getBruId() + item.getIgnore_digit()
						+ item.getControllNumber() + item.getReservedkey() + item.getDate() + item.getTimestamp()
						+ item.getRefNumber() + item.getCurrency1() + item.getLogic_identifier()
						+ item.getExtra_values();

			}

		}
		return content;
	}

	private List<String> Calllogics(FixedLenghtModel item) {
		List<String> list1 = new ArrayList<String>();
		CustomerService customerService = new CustomerServiceImpl();

		if (item.getLogic_identifier().equalsIgnoreCase(Constant.Logic_identifier_value1)
				&& item.getLogic_identifier().equalsIgnoreCase(Constant.Logic_identifier_value2)) {
			list1 = customerService.getDestinationLogic1(item.getUserId(), item.getBruId(), item.getDate());

			if (list1 != null && list1.size() > 0) {
				return list1;
			}

		}
		list1 = customerService.getDestinationLogic2(item.getUserId(), item.getCurrency1(), item.getDate());

		if (list1 != null && list1.size() > 0) {
			return list1;
		}
		
		list1 = customerService.getDestinationLogic3(item.getUserId(), item.getCurrency1(), item.getDate());

		if (list1 != null && list1.size() > 0) {
			return list1;
		}

		list1 = customerService.getDestinationLogic4(item.getUserId(), item.getCurrency1(), item.getDate());
		if (list1 != null && list1.size() > 0) {

			return list1;
		}

		return list1;
	}

	public CommonUtil getCommonUtil() {
		return commonUtil;
	}

	public void setCommonUtil(CommonUtil commonUtil) {
		this.commonUtil = commonUtil;
	}

	public  Service getService() {
		return service;
	}

	public  void setService(Service service) {
		this.service = service;
	}

}
