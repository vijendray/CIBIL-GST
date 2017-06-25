package com.cibil.gst.actions;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map myMap=new HashMap();
		myMap.put("ABC", 101);
		myMap.put("ABC", 102);
		
		System.out.println(myMap.get("abc"));
	}
}
