package 백준;
import java.util.Scanner;

public class GoUpStairV2 {

	public static int MAX(int i,int j) {
		return i> j ? i: j;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numOfAttr = sc.nextInt();
		int[] stair=new int[305];
		int[] DP=new int[305];
		for (int i = 1; i <= numOfAttr; i++) {
			stair[i]=sc.nextInt();
		}
		
		for(int i=1 ; i<=3 && i<=numOfAttr ; i++) {
			if(i!=3)
				DP[i] = stair[i]+DP[i-1];
			else
				DP[i] = MAX(stair[i]+stair[i-1], stair[i] + stair[i-2]);
		}
		
		for(int i=4 ; i <= numOfAttr ; i ++) {
			DP[i] = MAX(stair[i]+stair[i-1]+DP[i-3] , stair[i]+DP[i-2]);
		}
		
		System.out.println(DP[numOfAttr]);
	}

}
