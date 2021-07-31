package 프로그래머스.BFS_DFS;

public class 타겟넘버2 {

	static boolean[] isVisited;
	static int answer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,1,1};
		
		solution(arr,3);
		
	}
	
	  public static int solution(int[] numbers, int target) {
	        
		  isVisited = new boolean[numbers.length];
//	        dfs(numbers,0,target,0);
		   int answer = find(0,numbers.length, numbers, 0, target);
	        
	        System.out.println(answer);
	        return answer;
    }	
	  // 조금더 효율적인 분기 방법
	  public static int find(int idx , int max, int[] numbers, int sum, int target) {
		  
		  if( idx == max) {
			  if( sum == target) {
				  return 1;
			  }
			  else {
				  return 0;
			  }
		  }
		  
		  return (find(idx +1, max, numbers, sum + numbers[idx], target) 
				  + find(idx +1, max,numbers,sum - numbers[idx], target));
	  }
	  // 일반적인 dfs 방법
	  public static void dfs(int[] arr, int idx, int target,int sum) {
		  if (idx == arr.length) {
			 
			  return;
		  } else {
			  for(int i=idx ; i<arr.length ; i++) {
				  if(!isVisited[i]) {
					  int sum_result = 0;
					  isVisited[i] = true;
					  for(int j=0; j<arr.length; j++) {
						  if(isVisited[j]) {
							  sum_result += (arr[j] * -1);
						  } else {
							  sum_result += arr[j];
						  }
					  }
					  if(sum_result == target) {
						  answer += 1;
					  }
					  
					  dfs(arr, i + 1, target,sum_result);
					  isVisited[i] = false;
				  }
			  }
		  }
	  }

}
