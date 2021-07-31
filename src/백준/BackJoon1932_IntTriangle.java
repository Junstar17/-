package 백준;
import java.util.Scanner;

public class BackJoon1932_IntTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int num= sc.nextInt();
		sc.nextLine();
		int arr[][] = new int[num][num];
		for (int i=0 ; i < num ; i++) {
			
			String str=sc.nextLine();
			String[] str_arr = str.split(" ");
			for(int j= 0 ; j <= i ; j++) {
				arr[i][j]=Integer.parseInt( str_arr[j]);
			}
		}
		int[][] dp = new int[num][num];
		for(int i= 0 ; i<num ; i++) {
			
			if(i <1) {
				dp[0][0]=arr[0][0];
			}else {
				for(int k= 0 ; k<i ; k++) {
					for(int m=0 ; m <2 ; m++) {
						int temp=dp[i-1][k]+arr[i][k+m];
						if(dp[i][k+m]!=0) {
							if(temp>dp[i][k])
								dp[i][k+m]=temp;
						}else {
							dp[i][k+m]=temp;
						}
					}
				}
			}
		}
		int max=0;
		for (int i= 0 ; i<num ; i++) {
			if(max < dp[num-1][i]) {
				max=dp[num-1][i];
			}
		}
		System.out.println(max);
	}

}
