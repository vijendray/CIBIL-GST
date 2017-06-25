package com.cibil.gst.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cibil.gst.model.Advisor;
import com.cibil.gst.model.User;
import com.cibil.gst.service.CustomerService;
import com.cibil.gst.service.impl.CustomerServiceImpl;


@Component("itemProcessor")
@Scope(value = "step")
public class UserProcessor implements ItemProcessor<User, User> {

	public static long start_time = 0;

	@Value("#{stepExecutionContext[name]}")
	private String threadName;

	public static int overallInputCount = 0; // to get Overall Input Count
	public static int nonProcessedRecord = 0; // to get Overall Non Record
												// Processed Count.

	/*
	 * @Autowired private CustomerService customerService;
	 */

	@Override
	public User process(User item) throws Exception {

		String userId = item.getUSER_ID();
		String requestDate = item.getREQUEST_DATE();
		String memberName = item.getMember_Name();
		String ticket_id = item.getTICKET_ID();
		
		List<String> list = CallLogics(item);
		
		if (list != null && list.size() != 0) {
			item.setSource("Mumbai");
			item.setDes(list.get(0));
			item.setFlag(list.get(1));

		} else {
			if (item.getMember_Id().equals("Member_Id")) {
				item.setSource("Source");
				item.setDes("Destination");
				item.setFlag("Flag");
			} else {
				System.out.println("This Record with ticket id :" + item.getMember_Id()
						+ " was not Processed because of no record found for this User : " + item.getUSER_ID());
				nonProcessedRecord = nonProcessedRecord + 1;

			}

		}

		return item;
	}
	
		
	CustomerService customerService = new CustomerServiceImpl();

	public String getThreadName() {
		System.out.println("Threadname" + getThreadName());
		return threadName;
	}

	public void setThreadName(String threadName) {
		System.out.println("Threadname");
		this.threadName = threadName;
	}

	static {
		System.out.println("processor start time: " + System.currentTimeMillis());
	}


	
	

	private List<String> CallLogics(User item) {
		CustomerService customerService = new CustomerServiceImpl();
		List<String> list1 = new ArrayList<String>();
		

		list1 = customerService.getDestinationLogic1(item.getUSER_ID(), item.getREQUEST_DATE(), item.getMember_Name());
		if (list1 != null && list1.size() != 0) {
			return list1;
		}

		
		list1 = customerService.getDestinationLogic2(item.getUSER_ID(), item.getREQUEST_DATE(), item.getMember_Name());
		if (list1 != null && list1.size() != 0) {
			return list1;
		}
		
		list1 = customerService.getDestinationLogic4(item.getUSER_ID(), item.getREQUEST_DATE(), item.getMember_Name());
		if (list1 != null && list1.size() != 0) {
			return list1;
		}
		
//		list1 = customerService.getDestinationLogic2(item.getUSER_ID(), item.getREQUEST_DATE(), item.getMember_Name());
//		if (list1 != null && list1.size() != 0) {
//			return list1;
//		}

		return null;
	} 

}