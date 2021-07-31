package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf3Closet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSumClosest(new int[] {-100,-98,-2,-1}, -101));
	}
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        int result =0;
        List<List<Integer>> arrayLists = new ArrayList((new ArrayList()));
		for(int i=0; i< nums.length-2 ; i++) {
			int selectedIdx = i;
			int firstIdx = selectedIdx+1;
			int lastIdx = nums.length-1;
			
			while(firstIdx < lastIdx) {
				int sum =nums[selectedIdx] + nums[firstIdx] + nums[lastIdx];
				int gap =sum - target;
				int gap_abs = Math.abs(gap);
				
				if(min> gap_abs) {
					min = gap_abs;
					result = sum;
				}
				if( gap ==0) {
					return target;
					  
				}else if(gap >0) {
					lastIdx--;
					while(nums[lastIdx] == nums[lastIdx+1] && firstIdx < lastIdx) {
						  lastIdx--;
					  }
				}else {
					 firstIdx++;
					 while(nums[firstIdx] == nums[firstIdx-1] && firstIdx < lastIdx) {
						  firstIdx++;
					  }
				}
			}
			
		}
		
		return result;
    }

}
