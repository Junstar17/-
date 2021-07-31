package 백준;
import java.util.Scanner;

public class 이친수_2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number= sc.nextInt();
		long d[] = new long[number+1];
		d[0]=1;
		d[1]=1;
		for(int i=2 ; i<number ;i++) {
			d[i]=d[i-1]+d[i-2];
		}
		System.out.println(d[number-1]);
	}

}
