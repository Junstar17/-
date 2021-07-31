package 백준;
import java.util.Scanner;

public class nextint_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr=new int[100];
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		for(int i=0; i < N ; i++)
			arr[i]=sc.nextInt();
		
		for(int i=0; i < N ; i++)
			System.out.println(arr[i]);
		}

}
