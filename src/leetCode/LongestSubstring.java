package leetCode;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(lengthOfLongestSubstring(" "));
	}
	 public static int lengthOfLongestSubstring(String s) {
		 int n= s.length();
		 Set<Character> set = new HashSet();
		 int rear=0;
		 int front = 0;
		 
		 int max = 0;
		 if(s.length()>0) set.add(s.charAt(rear++));
		 while(rear < n) {
			 if(!set.contains(s.charAt(rear))) {
				 set.add(s.charAt(rear++));
			 }else {
				 set.remove(s.charAt(front));
				 front++;
			 }
			max= Math.max(max, rear-front);
		 }
		 max= Math.max(max, rear-front);
		 return max;
	 }
	   public static int lengthOfLongestSubstring2(String s) {
		   int max =0;
		   for(int i=0; i<s.length() - max ; i++) {
			   StringBuilder builder = new StringBuilder();
			   builder.append(s.substring(i,i+1));
			   for(int next = i+1 ; next < s.length() ; next ++) {
				   String 다음문자 = s.substring(next,next+1);
				   if(!builder.toString().contains(다음문자)) {
					   builder.append(다음문자);
				   }else {
					   break;
				   }
			   }
			   if(max< builder.toString().length()) {
				   max =builder.toString().length();
			   }
		   }
		   System.out.println(max);
		   return max;
	    }

}
