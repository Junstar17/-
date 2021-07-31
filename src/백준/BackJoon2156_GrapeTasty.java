package 백준;
import java.util.Scanner;

public class BackJoon2156_GrapeTasty {
	public static int MAX(int i, int j,int k) {
		if(i > j) 
			return i > k ? i : k;
		else 
			return j > k ? j : k;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] dp = new int[num + 5];
		int[] array = new int[num + 5];
		for (int i = 1; i <= num; i++) {
			array[i] = sc.nextInt();
		}
		for (int i = 1; i <= num; i++) {
			if (i < 4) {
				if (i != 3)
					dp[i] = array[i] + dp[i - 1];
				else
					dp[i] = MAX(array[i - 1] + array[i], array[i - 2] + array[i], dp[i-1]);
			}else {
				dp[i]=MAX(dp[i-3]+array[i-1]+array[i] , dp[i-2]+array[i], dp[i-1]);
			}
		}
		System.out.println(dp[num]);
	}
}
