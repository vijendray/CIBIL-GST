package com.cibil.gst.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class MyWriter implements ItemWriter<String>{
	
	private String resource;

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	@Override
	public void write(List<? extends String> content) throws Exception {
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(resource))) {
			String string=content.get(0);
			
			System.out.println("string" + string);
			System.out.println("content.get(0)" + content.get(0));
			bw.write(string);
			bw.write("\n");
			System.out.println("Done");
			
		} catch (IOException e) {

			e.printStackTrace();

		}
		
	}

}





