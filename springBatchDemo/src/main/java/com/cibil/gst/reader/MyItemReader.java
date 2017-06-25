/*package com.cibil.gst.reader;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;

import com.cibil.gst.model.User;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class MyItemReader extends FlatFileItemReader<String>{
//	static{
//		System.out.println("reader start time:: " + System.currentTimeMillis());
//	}
	

	private List pojos;

	private Iterator iterator;

	@Override
	public  String read()  {

		if (getIterator().hasNext()) {
			return getIterator().next();
		}
		return null;

	}



	
	
}
*/