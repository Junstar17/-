package 프로그래머스.정렬;
import java.util.Arrays;

public class H_index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] question = new int[] {3, 0, 6, 1, 5};
		System.out.println(solution(question));
	}
	 public static int solution_오답(int[] citations) {
	        int answer = 0;
	        int max = citations.length;
	        int cnt = 0;
	        for(int i=max ; i>0 ; i--) {
	        	cnt = 0;
	        	for(int value : citations) {
		        	if(value >= i) {
		        		cnt++;
		        	}
		        }	
	        	if(i <= cnt) {
	        		answer = cnt;
	        		break;
	        	}
	        }
	        
	        return answer;
	    }
	 public static int solution(int[] citations) {
	        Arrays.sort(citations);
	        
	        for(int i =0 ; i< citations.length ; i++) {
	        	if(citations[i] >= citations.length - i) return citations.length - i;
	        }
	        
	        return 0;
	    }

}
