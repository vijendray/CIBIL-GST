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


@Component("itemProcessor2")
@Scope(value = "step")
public class UserProcessor2 implements ItemProcessor<Advisor, Advisor>{



	public static long start_time = 0;

	@Value("#{stepExecutionContext[name]}")
	private String threadName2;

	public String getThreadName2() {
		System.out.println("get Thread name");
		return threadName2;
	}

	public void setThreadName2(String threadName2) {
		System.out.println("Set thread name");
		this.threadName2 = threadName2;
	}

	public static int overallInputCount = 0; // to get Overall Input Count
	public static int nonProcessedRecord = 0; // to get Overall Non Record
												// Processed Count.
	
	@Override
	public Advisor process(Advisor item) throws Exception {
		
		String start_date_value = item.getStart_date();
		String end_date_value = item.getEnd_date();
		String file_name = item.getFile_Name();
		String member_code = item.getMember_code();
		String record_id = item.getRecordID();

		List<String> list = CallLogics(item);

		if (list != null && list.size() != 0) {
			item.setSource("Mumbai");
			item.setDes(list.get(0));
			item.setFlag(list.get(1));

		} else {
			System.out.println("FILE NAME : "+item.getFile_Name());
			if (item.getFile_Name().equals("File Name")) {
				item.setSource("Source");
				item.setDes("Destination");
				item.setFlag("Flag");
			} else {
				System.out.println("This Record with ticket id :" + item.getRecordID()
						+ " was not Processed because of no record found for this User : " + item.getMember_code());
				nonProcessedRecord = nonProcessedRecord + 1;

			}

		}

		return item;
	}

	private List<String> CallLogics(Advisor item) {
		CustomerService customerService = new CustomerServiceImpl();
		List<String> list1 = new ArrayList<String>();
		list1 = customerService.getDestinationLogic5(item.getFile_Name(), item.getMember_code(), item.getStart_date());
		
		if (list1 != null && list1.size() != 0) {
			return list1;
		}

		list1 = customerService.getDestinationLogic2(item.getMember_code(),item.getFile_Name(), item.getStart_date());

		if (list1 != null && list1.size() != 0) {
			return list1;
		}

		list1 = customerService.getDestinationLogic4(item.getMember_code(), item.getFile_Name(), item.getStart_date());
		if (list1 != null && list1.size() != 0) {
			return list1;
		}

		return null;
	}
}
