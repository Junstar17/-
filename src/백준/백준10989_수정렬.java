package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준10989_수정렬 {

	static BufferedReader reader;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		reader = new BufferedReader( new InputStreamReader(System.in));
		int N= Integer.parseInt(reader.readLine());
		solution2(N);
//		int[] arr =new int[10001];
//		
//		
//		for(int i=0; i<N ; i++) {
//			int number = Integer.parseInt(reader.readLine());
//			arr[number] += 1;
//		}
//		reader.close();
//	 	StringBuilder sb = new StringBuilder();
//		
//		for(int i=1; i<10001 ; i++) {
//			if(arr[i] !=0) {
//				for(int j=0; j< arr[i] ; j++) {
//					sb.append(i).append("\n");
//				}
//			}
//		}
//		System.out.println(sb);
	}
	public static void solution2(int N) throws NumberFormatException, IOException {
		int[] arr = new int[N];
		for(int i=0; i<N ; i++) {
			int number = Integer.parseInt(reader.readLine());
			arr[i] = number;
		}
		reader.close();
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
