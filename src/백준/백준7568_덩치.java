package 백준;
import java.util.Scanner;

public class 백준7568_덩치 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		덩치[] 덩치리스트 = new 덩치[N];
		for(int i=0; i<N ;i ++) {
			덩치리스트[i] = new 덩치(sc.nextInt(),sc.nextInt());
		}
		
		for(int i=0; i<N-1 ; i++) {
			for(int j= i +1 ; j< N ; j++) {
				덩치리스트[i].비교(덩치리스트[j]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N ; i++) {
			sb.append(덩치리스트[i].상대등수+" ");
		}
		System.out.println(sb);
	}

}
class 덩치 {
	int 키;
	int 몸무게;
	int 상대등수 ;
	
	public 덩치(int 키, int 몸무게) {
		this.키 = 키;
		this.몸무게 = 몸무게;
		this.상대등수 = 1;
	}
	public void 비교(덩치 상대) {
		if(this.키 > 상대.키 && this.몸무게 > 상대.몸무게) {
			상대.상대등수 += 1;
		}else if(this.키 < 상대.키 && this.몸무게 < 상대.몸무게) {
			this.상대등수 +=1;
		}
	}
}
