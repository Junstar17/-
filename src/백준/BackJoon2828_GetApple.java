package 백준;
import java.util.Scanner;

public class BackJoon2828_GetApple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M= scan.nextInt();
		int numOfApple = scan.nextInt();
		int[] arr = new int[numOfApple];
		for(int i=0 ; i<numOfApple ; i++) {
			arr[i]=scan.nextInt();
		}
		
		int start=1;
		int end =M;
		int mov=0;
		
		for(int i=0;  i <numOfApple ; i++) {
			int applePosition=arr[i];
			if(start<= applePosition && end>=applePosition)
				continue;
			if(start>applePosition) {
				mov += start-applePosition;
				end -=  start-applePosition;
				start= applePosition;
				
			}
			else {
				mov +=applePosition - end;
				start +=  applePosition - end;
				end = applePosition;
				
			}
		}
		System.out.println(mov);
	}

}
