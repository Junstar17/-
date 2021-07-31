package leetCode;
import java.util.Arrays;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING",3));
	}
	 public static String convert(String s, int numRows) {
		 if(numRows ==1) {
			 return s;
		 }else {
			 StringBuilder builder = new StringBuilder();
			 int total = 2*(numRows-1);
			 for(int i=0; i< numRows ; i++) {
				int term =  2*(numRows-1 -i);
				int idx=i;
				while(idx<s.length()) {
					
					builder.append(s.charAt(idx));	
					idx += term;
					if(term != total) {
						term = total -term;
					    if(term == total) {
					    	idx+= term;
					    }
							
					}
				}
			}
			 return builder.toString();
		 }
	 }
	 public static String convert2(String s, int numRows) {
	        
		 char[][] result = new char[numRows+1][1000];
		 int i=0;
		 int x = 0;
		 int y =0;
		 boolean isDown =true;
		 result[x++][y] = s.charAt(i++);
		 if(numRows ==1) {
			 return s;
		 }else {
			 while(i < s.length()) {
				 if(i % (numRows-1) == 0) {
					 isDown = !isDown;
					 
					 result[x][y] = s.charAt(i++);
					 if(isDown) {
						 x +=1 ;
					 }else {
						
						 y +=1;
						 x -= 1;
					 }
					 continue;
				 }
				 
				 if(isDown) {
					 result[x++][y] = s.charAt(i++);
				 }else {
					 result[x--][y++] = s.charAt(i++);
				 }
			 }
		 }
		
		 
		 StringBuilder builder = new StringBuilder();
		 
		 for(int j=0; j<numRows ; j++) {
			 String text = String.valueOf(result[j]).replace("\u0000","");
			 builder.append(text);
		 }
		 
		 return builder.toString();
    }

}
