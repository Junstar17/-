package 카카오기출.커머스;

import java.util.ArrayList;
import java.util.List;

public class 삼번문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solve(new int[] {5, 9, 13, 1, 0, 0, 11, 1, 7, 12, 9, 9, 2}));
		//System.out.println(solve(new int[] {6, 10, 8, 5, 8, 10, 5, 1, 6, 7}));
	}

	public static int solve(int[] array) {
		int result = 0;
		
		int[] result_array= new int[array.length];
		for(int idx = 0; idx<array.length ; idx ++) {
			int cnt = 1 ;
			int next_student = array[idx];
			List<Integer> list = new ArrayList<>();
			list.add(idx+1);
			while(next_student != 0) {
				if(!list.contains(next_student)) {
					list.add(next_student);
					next_student = array[next_student-1];
					cnt++;
				}else {
					break;
				}
			}
			result_array[idx] = cnt;
		}
		
		int max = -1;
		int max_idx = 0;
		for(int i=0; i<array.length ; i++) {
			if(result_array[i] >= max) {
				max = result_array[i];
				max_idx = i;
			}
		}
		return max_idx+1;
	}
}
