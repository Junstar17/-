package 카카오기출.커머스;

public class 이번문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(solve(4,new int[] {2,3,1}));
		System.out.println(solve(4,new int[] {3,2,3,1,2,1}));
	}
	public static int solve(int m, int[] v) {
		int result =0;
		
		int[] left = new int[v.length];
		for(int i=0 ; i<v.length ; i++) {
			left[i]= m;
		}
		int 층 =0; 
		int 만석 =0; 
		
		for(int i=0; i <v.length ; i++) {
			int 현재층 = 층;
			int left_unit = left[현재층];
			
			if(v[i] <= left_unit) {
				while(현재층 > 0 && v[i] <= left[현재층-1]){
					현재층--;
				}
				left[현재층] -= v[i];
				
			}else {
				left[++층] -= v[i];
				if(left[층] == 0 ) {
					만석++;
				}
			}
		}
		return 층+1;
	}
}
