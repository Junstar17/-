package 백준;
import java.util.Arrays;
import java.util.Scanner;

public class 백준2309_일곱난장이 {

	static boolean[] isVisited;
	static int[] result;
	static boolean isFinish;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		isVisited = new boolean[9];
		result = new int[7];
		Scanner sc =new Scanner(System.in);
		int [] arr = new int[9];
		for(int i=0; i<9 ; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		DFS(0,0,0,arr);
		for(int i=0;i < result.length ; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void DFS(int idx , int sum, int cnt,int[] arr) {
		
		if(sum >= 100 || cnt == 7 ) {
			if(sum == 100 && !isFinish) {
				int k =0;
				for(int i=0; i<arr.length ; i++) {
					if(isVisited[i]) {
						result[k++] = arr[i];
					}
				}
				isFinish = true;
			}
			return;
		}else {
			for(int i = idx ; i<arr.length ; i++) {
				if(!isVisited[i]) {
					isVisited[i] = true;
					sum += arr[i];
					DFS(idx+1, sum, cnt +1, arr);
					isVisited[i] = false;
					sum -= arr[i];
					cnt -= 1;
				}
			}
		}
	}

}
