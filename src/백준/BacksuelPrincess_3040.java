package 백준;
import java.util.Scanner;

public class BacksuelPrincess_3040 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int idx=6;
		int moveidx=6;
		
		for(int i=0 ; i < 9 ; i++) {
			arr[i]=sc.nextInt();
		}
		while(true) {
			int sum=0;
			for(int i=0 ; i<=idx ; i++) {
				sum+=arr[i];
			}
			if(idx!=moveidx) {
				for(int j = idx ; j<moveidx ; j++) {
					
				}
			}
			if(sum==100)
				break;
			else
				moveidx++;
			
			if(moveidx==9) {
				idx--;
<<<<<<< HEAD
=======
				//moveidx=
>>>>>>> c3ff89e147081eb330cab8c8126fc04627a80b05
			}
		}
	}

}
