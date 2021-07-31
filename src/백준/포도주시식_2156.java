package 백준;
import java.util.Scanner;

public class 포도주시식_2156 {

	public static int MAX(int a, int b) {
		return a>b?a:b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int number= sc.nextInt();
		
		int[] grapeAmount= new int[number+5];
		int[] DP = new int[10005];
		for(int i= 1 ; i<=number; i++) {
			grapeAmount[i]=sc.nextInt();
		}
		for(int i = 1 ; i<=3 ; i++) {
			if(i!=3) {
				DP[i]=grapeAmount[i]+DP[i-1];
			}else {
				DP[i]=MAX(grapeAmount[i]+grapeAmount[i-1] , grapeAmount[i] +grapeAmount[i-2]);
			}
		}
		for(int i=4; i<= number ; i++) {
			DP[i]=MAX(grapeAmount[i]+grapeAmount[i-1]+DP[i-3] , grapeAmount[i] + DP[i-2]);
		}
		int max = 0;
		for(int i=1 ; i<=number ; i++) {
			if(max<DP[i])
				max=DP[i];
			
		}
		System.out.println(max);
	}

}
