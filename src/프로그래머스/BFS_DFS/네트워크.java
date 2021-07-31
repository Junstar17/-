package 프로그래머스.BFS_DFS;

public class 네트워크 {

	static int cnt;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(3,new int[][] {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}});
		//solution(5,new int[][] {{1, 1, 1,1,0}, {1, 1, 0,0,0}, {1, 0, 1,0,0}, {1, 0, 0,1,0}, {0, 0,0,0, 1}});
		//solution(3,new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
		System.out.println(cnt);
	}
	 public static int solution(int n, int[][] computers) {
	        visited= new boolean[computers.length];
	        cnt = n;
	        for(int i=0; i<n ;i ++) {
	        	dfs(n,computers,i);	
	        }
	        
	        return cnt;
	    }
	 public static void dfs(int target , int[][] computers, int idx) {
		 
		 if(idx == computers.length) {
			 return ;
		 }else {
			 for(int i=0; i<computers.length ; i++) {
				 visited[idx] = true;
				 if(!visited[i] && idx != i && computers[idx][i] == 1) {
					 cnt --;
					 dfs(target, computers, i);
					 
				 }
			 }
		 }
	 }

}
