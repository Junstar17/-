package 프로그래머스.BFS_DFS;

public class 타겟넘버 {

	static int R;
	static boolean[] visited;
	static int[] result;
	static int[] number;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1, 1,1,1,1},3));
	}
	
	  public static int solution(int[] numbers, int target) {
	        int answer = DFS(numbers,0,0,target);
	        return answer;
	    }
	  
	public static int DFS(int[] numbers, int index, int sum, int target) {
		if(index == numbers.length) {
			return sum == target ? 1 : 0;
		}else {
			return DFS(numbers,index+1,sum + numbers[index],target)+DFS(numbers,index+1,sum - numbers[index],target);
		}
	}

}
