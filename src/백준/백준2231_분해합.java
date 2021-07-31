package 백준;
import java.util.Scanner;

public class 백준2231_분해합 {

	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String M_str = sc.nextLine();
		int M = Integer.parseInt(M_str);
		//solution(M);
		fastSolution(M,M_str);
		System.out.println(result);
	}
	public static void solution(int M) {
	
		boolean 존재 = false;
		for(int i=1; i <M ; i++) {
			int[] arr = new int[10];
			int 자연수 = M- i;
			int 초기값  = 자연수;
			int idx =0;
			do {
				int 나머지 = 자연수 % 10;
				자연수 = 자연수  / 10;
				arr[idx++] = 나머지;
			}while(자연수 !=0);
			
			int sum = 초기값 ;
			for(int j=0; j<idx ; j++) {
				sum += arr[j];
			}
			
			if(sum  == M && 초기값 < result ) {
				result = 초기값;
				존재 = true;
			}
		}
		if(!존재) {
			result = 0;
		}
	}
	
	public static void fastSolution(int M,String M_str) {
			
		int init = M - (9* M_str.length());
		boolean 존재 = false;
		for(int i=init; i <M ; i++) {
			int 자연수 = i;
			int sum = i ;
			do {
				int 나머지 = 자연수 % 10;
				자연수 = 자연수  / 10;
				sum += 나머지;
			}while(자연수 !=0);
			
			if(sum  == M  ) {
				result = i;
				존재 = true;
				break;
			}
		}
		if(!존재) {
			result = 0;
		}
	}

}
