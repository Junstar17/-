package 백준;
import java.util.Scanner;

public class 백준1065_한수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		
		System.out.println(solution(N));
	}
	
	public static  int solution(String N) {
		
		int n =Integer.parseInt(N);
		if(n <100) {
			return n;
		}else {
			int cnt =99;
			for(int i=100; i<=n ; i++) {
				int 백의자리 = i/100;
				int 십의자리 = i%100 / 10;
				int 일의자리 = i % 10;
				
				if((백의자리-십의자리) == (십의자리-일의자리)) {
					cnt++;
				}
			}
			return cnt;
		}
	}
}
