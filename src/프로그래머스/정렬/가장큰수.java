package 프로그래머스.정렬;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 가장큰수 {

	static int R;
	static boolean[] visited;
	static int[] result;
	static List<Integer> textArray;
	static double max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {3,30,34,5};
		R= array.length;
		visited=new boolean[R];
		result = new int[R];
		textArray = new ArrayList();
		System.out.println(solution(array));
	}
	 public static String solution_오답(int[] numbers) {
	        String answer = "";
	        
	        순열(0,numbers);
	        return ""+(int)max;
    }
	 
	 public static void 순열(int idx,int[] list) {
		 if(idx == R) {
			 double result_int= Double.parseDouble(Arrays.toString(result).replaceAll("\\[|\\]|,|\\s", ""));
			 if(result_int > max)
				 max= result_int;
	       return;
		 }
			
		 for(int i=0 ; i<R ; i++) {
			 if(visited[i])
				 continue;
			 result[idx] = list[i];
			 visited[i] =true;
			 순열(idx+1,list);
			 visited[i]=false;
		 }
	 }
	 
	 public static String solution(int[] numbers) {
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
