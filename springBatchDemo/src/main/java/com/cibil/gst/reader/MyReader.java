package com.cibil.gst.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.cibil.gst.batch.entity.Service;
import com.cibil.gst.batch.entity.ServiceImpl;

public class MyReader implements ItemReader<String> {
	private String resource;
	
	
	public String getResource() {
		return resource;
	}


	public void setResource(String resource) {
		this.resource = resource;
	}


	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
	
		boolean batchJobState = true;
		
		String wholeContent = "";
		File file = new File(resource);
		BufferedReader in = new BufferedReader(new FileReader(file));
		if (batchJobState) {
			while ((wholeContent = in.readLine()) != null) {
				batchJobState = false;
				return wholeContent;

			}
		}
		return null;
	}
  }
