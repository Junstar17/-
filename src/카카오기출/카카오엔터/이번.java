package 카카오기출.카카오엔터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 이번 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList();
		/*
		File file = new File("C:\\Users\\j9310\\eclipse-workspace\\example.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       list.add(line);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		*/
		/*
		list.add("121.18.19.20");
		list.add("121.18.19.20.");
		list.add(".121.18.19.20");
		list.add("121.012.19.20");
		list.add("121.012.19.20");
		*/
		//list.add("2001:0db8:0:0:0:ff00:42:8329");
		//list.add("::1");
		//list.add("2001:db8::ff00:42:8329");
		//list.add("10.113.205.123");
		list.add("1::1::1");
		List<String> result = validateAddresses(list);
		System.out.println(result.toString());
		/*
		File file2 = new File("C:\\\\Users\\\\j9310\\\\eclipse-workspace\\\\example2.csv");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
			for(String str : result) {
				
			    writer.write(str+"\n");
			  
			}
			  writer.close();
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		*/
	}
	 public static List<String> validateAddresses(List<String> addresses) {
		    // Write your code here

		 List<String> result = new ArrayList();
		 for(int i=0; i<addresses.size() ; i++) {
			 String address = addresses.get(i);
			 if(address.contains(".")) {
				 String answer = checkIPV4(address);
				 result.add(answer);
			 }else if(address.contains(":")) {
				 String answer = checkIPV6(address);
				 result.add(answer);
			 }
		 }
		 return result;
	 }

	 public static String checkIPV4(String address) {
		 String[] digits = address.split("\\.");
		 String result = "IPv4";
		 if(digits.length != 4 || address.charAt(address.length()-1) =='.') {
			 result= "Neither";
		 }else {
			 for(String digit : digits) {
				 if(digit.length()>3 || digit.length() ==0) {
					 result= "Neither";
					 break;
				 }else {
					 int digit_num = Integer.parseInt(digit);
					 if(digit_num>255 || digit_num<0) {
						 result= "Neither";
						 break;
					 }else {
						 if(digit.charAt(0)=='0') {
							 if(digit_num >7) {
								 result= "Neither";
								 break;
							 }
						 }
					 }
				 }
			 }
		 }
		 return result;
	 }
	 public static String checkIPV6(String address) {
		 String[] digits = address.split(":");
		 String result = "IPv6";
		 if(address.split("::").length>2) {
			 result= "Neither";
		 }
		 else if((digits.length != 8 && !address.contains("::"))) {
			 result= "Neither";
		 }else {
			 for(String digit : digits) {
				 if(digit.length()>4) {
					 result= "Neither";
	                	return result;
				 }
					 for(int i = 0; i < digit.length(); i++)
			                if(Character.digit(digit.charAt(i), 16) == -1) {
			                	result= "Neither";
			                	return result;
	                }
				 
			 }
			 
		 }
		 return result;
		 
	 }
 	
}
