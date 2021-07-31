package 백준;
import java.util.Scanner;

public class BackJoon1932_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int size=0;
		for(int i=1; i<= height ; i++) {
			size += i ;
		}
		System.out.println(size);
	}

}
