package 백준;
import java.util.Scanner;

public class BackJoon1912_continualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int arr[]= new int [num];

		for (int i = 0 ; i< num ; i ++) {
			arr[i]=sc.nextInt();
		}
		
		int[] dp=new int[num];
		for(int i=0 ; i< num ; i++) {
			
			if( i<1) {
				dp[i]=arr[i];
			}else {
				if(arr[i]<dp[i-1]+arr[i])
					dp[i]=dp[i-1]+arr[i];
				else
					dp[i]=arr[i];
			}
		}
		int max=-1000;
		for(int i=0 ; i< num ; i++) {
			if(max<dp[i]) {
				max=dp[i];
			}
		}
		System.out.println(max);
	}

}
