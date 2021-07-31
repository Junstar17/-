package 프로그래머스.탐색;

import java.util.ArrayList;
import java.util.Arrays;

public class 소수찾기 {

	static int R;
	static int[] array;
	static int[] result;
	static boolean[] visited;
	static int cnt;
	static ArrayList<Integer> comb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("011"));
	}
	 public static int solution(String numbers) {
		 
		 array = Arrays.stream(numbers.split("")).mapToInt(Integer::valueOf).toArray();
		 
		 R = array.length;
		 visited = new boolean[R];
		 result = new int[R];
		 comb = new ArrayList();
		 순열(0);
		 int answer = cnt;
	        return answer;
	 }
	 
	 public static void 순열(int idx) {
		 if(idx == R) {
			
			 return;
		 }
		 
		 for(int i=0; i<R ; i++) {
			 
			 if(visited[i]) {
				 continue;
			 }
			 result[idx] = array[i];
			 StringBuilder builder = new StringBuilder();
			 for(int j=0 ; j<= idx ; j++) {
				 builder.append(result[j]);
			 }
			 int result = Integer.parseInt(builder.toString());
			 if(!comb.contains(result)) {
				comb.add(result); 
				 if(is_prime(result)) {
					 cnt ++;
				 }
			 }
			
			 visited[i] = true;
			 순열(idx+1);
			 visited[i] = false;
		 }
		
	 }
	 public static boolean is_prime(int number) {
		 
			// 0 과 1 은 소수가 아니다
			if(number < 2) {
				return false;
			}
			
			// 2 는 소수다
			if(number == 2) {
				return true;
			}
			
			// 제곱근 함수 : Math.sqrt()
			for(int i = 2; i <= Math.sqrt(number); i++) {
	        
				// 소수가 아닐경우
				if(number % i == 0) {
					return false;
				}
			}
			// 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
			return true;
		}

}
