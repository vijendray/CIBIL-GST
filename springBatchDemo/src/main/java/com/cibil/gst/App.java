package com.cibil.gst;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cibil.gst.dao.CustomerDao;
import com.cibil.gst.dao.impl.CustomerDaoImpl;
import com.cibil.gst.processor.UserProcessor;
import com.cibil.gst.service.impl.CustomerServiceImpl;

/**
 * @author vijyadav
 *
 */
public class App {

	long start_time = 0;
	long end_time = 0;
	CustomerServiceImpl cimpl = new CustomerServiceImpl();
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		
  
		App obj = new App();
		obj.run();
		obj.getSummary();
	}

	public void run() {
		
//		String[] springConfig = { "spring/batch/jobs/job-partitioner.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext("job-partitioner.xml");
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("partitionJob");

		try {

			//JobParameters param = new JobParametersBuilder().addString("age", "20").toJobParameters();

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus()+"job End time"+System.currentTimeMillis());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());
			
			
//			File file=new File("C:\\Users\\siva.m\\Desktop\\Jun13");
//			     for(String str:file.list()){
//			     System.out.println(str);
//			     }
//			     File file1=new File("C:\\Users\\siva.m\\Desktop\\Jun13\\domain-1.csv");
//			     Path filePath = file1.toPath();
//			     BasicFileAttributes attributes = null;
//			     try
//			        {
//			    	 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//			            attributes =
//			                    Files.readAttributes(filePath, BasicFileAttributes.class);
//			            System.out.println("Creation date: " +  attributes.creationTime());
//			           
//			            
//			          
//			            System.out.println("Size::" + file1.length());
//			            
//			            System.out.println("Before Format : " + file1.lastModified());
//
//			        	System.out.println("After Format : " + sdf.format(file1.lastModified()));
//			        	
//			        	FileTime fileCreationTime = attributes.creationTime();
//			        	String creationTime = String.valueOf(fileCreationTime);
//			        	String fileLength =  String.valueOf(file1.length());
//			        	String lastmodifiedDate = String.valueOf(sdf.format(file1.lastModified()));
//			        	System.out.println("lastmodifiedDate:::" + lastmodifiedDate);
//			        	Date date = new Date();
//			        	String sys_date = String.valueOf(date);
			        	// Stored to table
//			        	CustomerDao customer = new CustomerDaoImpl();
//			    		customer.postFileDetails("FileName",fileLength,creationTime,lastmodifiedDate,sys_date,"Siva");

			            
//			        }
//			     catch (IOException exception)
//			        {
//			            System.out.println("Exception handled when trying to get file " +
//			                    "attributes: " + exception.getMessage());
//			        }
//
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");
		

	}
	
	public void getSummary()
	 {
	  UserProcessor upr = new UserProcessor();
	  float lapTime = end_time-upr.start_time;
	  
	  System.out.println("********Summary *******");
	  
	  System.out.println("Number of Records in the Input File : "+upr.overallInputCount);
	  System.out.println("Number of Records Processed : "+(upr.overallInputCount-upr.nonProcessedRecord)); 
	  System.out.println("Number of Records Non Processed :"+ upr.nonProcessedRecord);
	  System.out.println(("Total Elapsed time (in minutes): " + (lapTime/6000)));
	  System.out.println("***************");
	  
	 }
	
}
