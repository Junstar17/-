package 백준;
import java.util.Scanner;

public class YenaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();//1<=m<n<=10
        int n = scan.nextInt();
        int apple = scan.nextInt();//1<=j<=20
        int a_place = scan.nextInt();//line number
        int ans = 0;
        for(int i=1; i<apple; i++){
            int prev = a_place;
            a_place = scan.nextInt();//line number
            if(prev >= a_place){
                ans += prev-a_place;
            }
            else{
                ans += a_place-prev;
            }
        }
        System.out.println(ans);
	}

}
