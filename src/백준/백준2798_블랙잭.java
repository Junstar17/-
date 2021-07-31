package 백준;
import java.util.Scanner;

public class 백준2798_블랙잭 {

	static int N;
	static boolean[] visited;
	static int 차이 = Integer.MAX_VALUE;
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		visited=new boolean[N];
		int[] arr= new int[N];
		for(int i=0 ; i< N ; i++) {
			arr[i] = sc.nextInt();
		}
		//DFS(0,M,arr,0);
		int result = solution(arr, M);
		System.out.println(result);
	}
	
	public static void DFS(int idx, int M, int[] arr, int cnt) {
		
		if(cnt ==3) {
			int sum =0;
			for(int i=0 ; i< N ; i++) {
				if(visited[i]){
					sum += arr[i];
				}
			}
			if(sum <= M){
				int diff = M-sum;
				if(차이 >diff) {
					차이 = diff;
					result = sum;
				}
			}
			return;
		}else {
			for(int i=idx; i< N ; i++) {
				if(!visited[i]) {
					visited[i] = true;
					DFS(i+1,M,arr, cnt +1);
					visited[i] = false;
				}
			}
		}
	}
	public static int solution(int[] arr, int sum) {
		
		for(int i=0; i<N -2; i++) {
			for(int j =i+1 ; j<N - 1;  j++) {
				for(int k = j+1 ; k < N ; k++){{
					int 합산 = arr[i]+arr[j]+arr[k];
					if(합산 == sum) {
						return sum;
					}else if(합산 > sum){
						continue;
					}else {
						int 차 = sum - (합산);
						if(차이 > 차) {
							차이 = 차;
							result = 합산;
						}
					}
				}
				}
			}
		}
		return result;
	}
}
