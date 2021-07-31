package leetCode;

public class FindPivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
	}
	  public static int pivotIndex(int[] nums) {
	        
		  int leftSum = 0, rightSum =0;
		  int rightIdx = nums.length -1;
		  while(0 < rightIdx) {
			  rightSum += nums[rightIdx--];
		  }
		  for(int i=0; i<nums.length ; i++) {
			  if(leftSum == rightSum) {
				  return i;
			  }else {
				  leftSum += nums[i];
				  if(i+1 < nums.length )
					  rightSum -= nums[i+1];
			  }
		  }
		  return -1;
    }
}
