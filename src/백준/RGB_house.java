package 백준;
import java.util.Scanner;

public class RGB_house {

	public static int Min(int a,int b) {
		return a>b ? b : a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		sc.nextLine();
		
		int[][] house = new int[N+1][3];
		int[][] DP= new int[N+1][3]	;
		String[] arr= new String[3];
		for(int i=1 ; i <= N ;i++) {
			for(int j=0 ; j <3 ; j++) {
				house[i][j] = sc.nextInt();
			}
		}
		house[0][1]=house[0][1]=house[0][2] = DP[0][0]= DP[0][1]= DP[0][2]=0;
		for(int i=1 ; i<=N ; i++) {
			DP[i][0]=Min(DP[i-1][1], DP[i-1][2]) + house[i][0];
			DP[i][1]=Min(DP[i-1][0], DP[i-1][2]) + house[i][1];
			DP[i][2]=Min(DP[i-1][0], DP[i-1][1]) + house[i][2];
		}
		System.out.println(Min(Min(DP[N][0] , DP[N][1]), DP[N][2]));
		
		
	}

}
