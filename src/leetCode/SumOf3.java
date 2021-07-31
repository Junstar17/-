package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[] {-1,0,1,2,-1,-4};
		// -4 -1 -1 0 1 2
		threeSum(array);
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);
		List<List<Integer>> arrayLists = new ArrayList((new ArrayList()));
		for(int i=0; i< nums.length-2 ; i++) {
			int selectedIdx = i;
			int firstIdx = selectedIdx+1;
			int lastIdx = nums.length-1;
			
			if(nums[selectedIdx] >0) {
				break;
			}
			if(selectedIdx>0 && nums[selectedIdx] == nums[selectedIdx-1]) continue;
			while(firstIdx < lastIdx) {
				int sum =nums[selectedIdx] + nums[firstIdx] + nums[lastIdx];
				if(sum ==0) {
					 ArrayList<Integer> list = new ArrayList();
					  list.add(nums[selectedIdx]);
					  list.add(nums[firstIdx]);
					  list.add(nums[lastIdx]);
					  arrayLists.add(list);
					  firstIdx++;
					  lastIdx--;
					  while(nums[firstIdx] == nums[firstIdx-1] && firstIdx < lastIdx) {
						  firstIdx++;
					  }
					  while(nums[lastIdx] == nums[lastIdx+1] && firstIdx < lastIdx) {
						  lastIdx--;
					  }
				}else if(sum >0) {
					lastIdx--;
				}else {
					firstIdx++;
				}
			}
		}
		
		return arrayLists;
	}
	  public static List<List<Integer>> threeSum2(int[] nums) {
	
			List<List<Integer>> arrayLists = new ArrayList((new ArrayList()));
			boolean isZeroSet  = false;
		  for(int i=0; i<nums.length-2 ; i++) {
			  for(int j=i+1; j<nums.length-1 ; j++) {
				  for(int k=j+1; k<nums.length ; k++) {
					 
					  if(!isZeroSet && nums[i] == 0 && nums[j] == 0 && nums[k]==0) {
						  ArrayList<Integer> list = new ArrayList();
						  list.add(nums[i]);
						  list.add(nums[j]);
						  list.add(nums[k]);
						  arrayLists.add(list);
						  isZeroSet=true;
					  } else if(nums[i] + nums[j] + nums[k] ==0) {
						  
						  ArrayList<Integer> list = new ArrayList();
						  list.add(nums[i]);
						  list.add(nums[j]);
						  list.add(nums[k]);
						  boolean isExist =false;
						  for(List<Integer> list_temp : arrayLists) {
							  if(list_temp.contains(nums[i]) &&list_temp.contains(nums[j]) &&list_temp.contains(nums[k])) {
								  isExist= true;
								  break;
							  }
						  }
						  if(!isExist) {
							  arrayLists.add(list);
						  }
					  }
				  }
			  }
		  }
		  return arrayLists;
    }
	 

}
