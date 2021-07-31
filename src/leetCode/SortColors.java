package leetCode;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 sortColors2(new int[] {2,2});
	}
	public static void sortColors(int[] nums) {
    
		for(int i=0 ; i< nums.length-1 ; i++) {
			
			int value = nums[i];
			
			if(value ==0) {
				int temp_idx = i;
				int temp ;
				while(temp_idx>1) {
					temp= nums[temp_idx-1] ;
					nums[temp_idx-1] = nums[temp_idx];
					nums[temp_idx] = temp;
					temp_idx--;
				}
			}else if( value ==2) {
				int temp_idx = i;
				int temp ;
				while(temp_idx<nums.length-1 ) {
					temp= nums[temp_idx+1] ;
					nums[temp_idx+1] = nums[temp_idx];
					nums[temp_idx] = temp;
					temp_idx++;
				}
			}else {
				int temp_idx = i;
				int temp ;
				while(temp_idx<nums.length-1 && nums[temp_idx] > nums[temp_idx+1]) {
					temp= nums[temp_idx+1] ;
					nums[temp_idx+1] = nums[temp_idx];
					nums[temp_idx] = temp;
					temp_idx++;
				}
				i --;
			}
		}
	
    }
	public static void sortColors2(int[] nums) {
		
		int redIdx = 0;
		int blueIdx = nums.length-1;
		
		for(int i=0 ; i < nums.length ; i++) {
			int color = nums[i];
			
			if(color == 0  ) {
				while(nums[redIdx] == 0) {
					if(redIdx < nums.length-1)
						redIdx++;
					else
						break;
				}
				if(i >redIdx) {
					nums[i] = nums[redIdx];
					if(nums[redIdx] ==2) {
						i--;
					}
					nums[redIdx] = color;
					redIdx ++;
				}
			
			}else if (color ==2) {
				while(nums[blueIdx] == 2) {
					if(blueIdx > 0)
						blueIdx--;
					else
						break;
				}
				if(blueIdx > i) {
					nums[i] = nums[blueIdx];
					if(nums[blueIdx] ==0) {
						i--;
					}
					nums[blueIdx] = color;
					blueIdx --;
				}
				
			}
		}
	}
	

}
