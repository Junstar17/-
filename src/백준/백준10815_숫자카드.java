package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준10815_숫자카드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] myCards = new int[10000001];
		int[] myCardsMinus = new int[10000001];
		String[] numbers = br.readLine().split(" ");
		for(int i=0; i< N ;i++) {
			int number =Integer.valueOf(numbers[i]);
			if(number>=0) {
				myCards[number] += 1;
			}else {
				number *= -1;
				myCardsMinus[number] += 1;
			}
		}
		int M = Integer.valueOf(br.readLine());
		int[] answer = new int[M];
		 numbers = br.readLine().split(" ");
		for(int i=0; i<M ;i++) {
			int number =Integer.valueOf(numbers[i]);
			if(number>=0) {
				if(myCards[number] == 0 ) {
					answer[i] = 0;
				}else {
					answer[i] = 1;	
				}
			}else {
				number *= -1;
				if(myCardsMinus[number] == 0 ) {
					answer[i] = 0;
				}else {
					answer[i] = 1;	
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb);
	}

}
