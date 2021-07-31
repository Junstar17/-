package leetCode;
import java.util.ArrayList;
import java.util.Collections;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		largestNumber(new int[] {3,30,34,5,9});
	}
	 public static String largestNumber(int[] numbers) {
		 String answer= "";
		 ArrayList list = new ArrayList<>();
		 for(int i=0; i<numbers.length ; i++) {
			 list.add(numbers[i]);
		 }
		 Collections.sort(list,(a,b) -> {
			 String as = a.toString() , bs = b.toString();
			 return -Long.compare(Long.parseLong(as+bs), Long.parseLong(bs+as));
		 });
		 StringBuilder builder =new StringBuilder();
		 for(int i =0; i<list.size() ; i++) {
			 
			 builder.append(list.get(i));
		 }
		 answer = builder.toString();
		 if(answer.charAt(0) == '0' ) {
			 return "0";
		 }
		 
		 return answer;
    }

}
