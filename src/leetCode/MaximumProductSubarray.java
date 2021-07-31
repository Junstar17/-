package leetCode;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(maxProduct2(new int[] {2,3,-2,4}));
	}
	 public static int maxProduct(int[] nums) {
	        
		 int max = Integer.MIN_VALUE;
		 for(int i=0; i < nums.length ; i ++) {
			 
			 int product =nums[i];
			 for(int j= i ; j<nums.length ; j++) {
				 if(j!=i) {
					 product = product* nums[j];
				 }
				 if(max < product) {
					 max = product;
				 }
			 }
		 }
		 return max;
    }
	 
	 public static int maxProduct2(int[] nums) {
	        
		 int min = nums[0];
		 int max = nums[0];
		 int unit = nums[0];
		 for(int i=1; i < nums.length ; i ++) {
			 
			 int next_unit = nums[i];
			 
			 int max_new = max * next_unit;
			 int min_new = min * next_unit;
			 
			 max = Math.max(next_unit,Math.max(min_new, max_new));
			 min = Math.min(next_unit,Math.min(max_new, min_new));
			 unit = Math.max(max,unit);
			
		 }
		 return unit;
    }
}
