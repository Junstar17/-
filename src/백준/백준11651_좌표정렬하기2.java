package 백준;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 백준11651_좌표정렬하기2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		좌표[] 리스트  = new 좌표[N];
		for(int i=0; i< N ; i++) {
			리스트[i] =new 좌표(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(리스트);
		
		for(int i=0; i<N ;i ++) {
			System.out.println(리스트[i].x+" "+리스트[i].y);
		}
	}

}

class 좌표 implements Comparable<좌표>{
	int x;
	int y;
	public 좌표(int x, int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public int compareTo(좌표 arg0) {
		if(arg0.y == this.y) {
			return  this.x - arg0.x;
		}
		return  this.y - arg0.y ;
	}
}