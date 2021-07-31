package leetCode;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));
	}
	 public static int findPeakElement(int[] nums) {
	        
		 for(int i=0 ; i<nums.length-1 ; i++) {
			 if(nums[i] > nums[i+1]) {
				 return i;
			 }
		 }
		 return nums.length-1;
    }

}
