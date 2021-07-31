package 카카오기출.카카오엔터;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 삼번 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minOperations(156));
	}
	 static HashSet<String> visited;
	   static class Binary {
	      String binary;
	      long count;
	      
	      public Binary(String binary, long count) {
	         this.binary = binary;
	         this.count = count;
	      }
	   }
	   public static long minOperations(long n) {
		      long answer = 0;
		      visited = new HashSet<>();
		      Queue<Binary> binaryQueue = new LinkedList<>();
		      visited.add(Long.toBinaryString(n));
		      binaryQueue.add(new Binary(Long.toBinaryString(n), 0));
		      Binary binary = binaryQueue.poll();
		      String binaryStr=binary.binary;
		      System.out.println(binaryStr);
		      long result1 = minOperations_change(binaryStr);
		      long result2 = minOperations_right(binaryStr);
		      return Math.min(result1, result2);
		 }
	   public static long minOperations_change(String binaryStr) {
		   long answer = 0 ;   
		   do{
		         for(int i = binaryStr.length() - 1; i > 0; i--) {
		            if(binaryStr.charAt(i) == '1') {
		            	binaryStr= changeBinary(binaryStr, i - 1);
		            	 answer += 1;
		            	 break;
		            }
		         }
		         binaryStr = changeBinary(binaryStr, binaryStr.length() - 1);
		         answer += 1;
		      }while(!isZero(binaryStr));
		      return answer;
		 }
	   public static long minOperations_right(String binaryStr) {
		      long answer = 0;
		      do{
		    	  binaryStr = changeBinary(binaryStr, binaryStr.length() - 1);
			       answer += 1;
			       
		         for(int i = binaryStr.length() - 1; i > 0; i--) {
		            if(binaryStr.charAt(i) == '1') {
		            	binaryStr= changeBinary(binaryStr, i - 1);
		            	 answer += 1;
		            	 break;
		            }
		         }
		         
		      }while(!isZero(binaryStr));
		      return answer;
		 }

	   public static long minOperations2(long n) {
	      long answer = 0;
	      visited = new HashSet<>();
	      Queue<Binary> binaryQueue = new LinkedList<>();
	      visited.add(Long.toBinaryString(n));
	      binaryQueue.add(new Binary(Long.toBinaryString(n), 0));
	      
	      while(!binaryQueue.isEmpty()) {
	         Binary binary = binaryQueue.poll();
	         String binaryStr = binary.binary;
	         long count = binary.count;
	         
	         for(int i = binaryStr.length() - 1; i > 0; i--) {
	            if(binaryStr.charAt(i) == '1') {
	               String nextBinary = changeBinary(binaryStr, i - 1);
	               
	               if(!alreadyVisited(nextBinary)) {
	                  if(isZero(nextBinary)) {
	                     answer = count + 1;
	                     break;
	                  }
	                  visited.add(nextBinary);
	                  binaryQueue.add(new Binary(nextBinary, count + 1));
	               }
	               
	               break;
	            }
	         }
	         
	         String rightmostBinary = changeBinary(binaryStr, binaryStr.length() - 1);
	         if(!alreadyVisited(rightmostBinary)) {
	            if(isZero(rightmostBinary)) {
	               answer = count + 1;
	               break;
	            }
	            visited.add(rightmostBinary);
	            binaryQueue.add(new Binary(rightmostBinary, count + 1));
	         }
	      }
	      
	      return answer;
	   }

	   private static boolean isZero(String binary) {
	      return !binary.contains("1");
	   }

	   private static boolean alreadyVisited(String binary) {
	      return visited.contains(binary);
	   }

	   private static String changeBinary(String binary, int index) {
	      StringBuilder sb = new StringBuilder(binary);
	      if(binary.charAt(index) == '1') {
	         sb.setCharAt(index, '0');
	      } else {
	         sb.setCharAt(index, '1');
	      }
	      
	      return sb.toString();
	   }
	   private static int reduceNumber(String binary) {
		   
		   int sign = 1;
		   int result = 0;
		   for(int i=0; i<binary.length(); i++) {
			   if(binary.charAt(i)=='')
		   }
		   
	   }
}
