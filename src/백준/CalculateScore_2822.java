package 백준;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CalculateScore_2822 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr= new int[8];
		for(int i=0 ; i <8 ; i++) {
			arr[i] = sc.nextInt();
		}
		int[] idx=new int[8];
		int sum=0;
		int[] maxArr = new int[5];
		
		int max=0;
		int maxVal=151;
		for(int j =0 ; j < 5 ; j++) {
			max=0;
			for(int i=0 ; i <8 ;i++) {
				if(max<arr[i] && arr[i] < maxVal) {
					max=arr[i];
					maxArr[j]=i;
				}
			}
			maxVal=max;
		}
		for(int i=0 ; i < 5 ; i++) {
			sum+=arr[maxArr[i]];
		}
		System.out.println(sum);
		Arrays.sort(maxArr);
		for(int i=0 ; i < 5 ; i++) {
			System.out.print(maxArr[i]+1+" ");
		}
	}

}
