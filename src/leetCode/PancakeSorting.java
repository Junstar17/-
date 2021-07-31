package leetCode;
import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(pancakeSort(new int[] {3,2,4,1}).toString());
		
	}
	  public static List<Integer> pancakeSort(int[] arr) {
	        
		  int lastIdx = arr.length-1;
		  int firstIdx = 0;
		  int k =0;
		  List<Integer> answer = new ArrayList();
		  while(firstIdx <arr.length-1) {
			  while(firstIdx< lastIdx) {
				  int first = arr[firstIdx];
				  int last = arr[lastIdx];
				  if(first > last) {
					  k = lastIdx +1;
					  int k_value = firstIdx ==0 ? k : firstIdx+1; 
					  answer.add(k_value);
					 
					  reverse(0,k_value-1,arr);
					  lastIdx = arr.length-1;
					  firstIdx=0;
					  continue;
				  }else {
					  lastIdx --;
				  }
			  }
			  firstIdx++;
			  lastIdx= arr.length-1;
		  }
		  return answer;
    }
	  
	  public static void reverse(int first, int last, int[] arr) {
		  while(first< last) {
			  int temp = arr[first];
			  arr[first] = arr[last];
			  arr[last] = temp;
			  first ++;
			  last --;
		  }
	  }
}
