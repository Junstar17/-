package leetCode;
import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}
	public static  int removeDuplicates(int[] nums) {
        
		Arrays.sort(nums);
		int cnt =0;
		int storeIdx = 0;
		int searchIdx = 1;
		while(searchIdx<nums.length) {
			if(nums[storeIdx] == nums[searchIdx]) {
				searchIdx++;
			}else {
				nums[++storeIdx] = nums[searchIdx++];
			}
		}
		return storeIdx+1;
    }

}
