package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class K_diffPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findPairs(new int[] {1,3,1,5,4}, 0));
	}

public static int findPairs(int[] nums, int k) {
        
	Arrays.sort(nums);
	int cnt = 0;
	List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
	int lastvalue = nums[nums.length-1];
	for(int i=0; i<nums.length; i++) {
		int value = nums[i];
		if(lastvalue == value) {
			lastvalue = value;
			continue;
		}else {
			if(list.contains(value+k)) {
				if(k ==0 ) {
					if(i != list.lastIndexOf(value)) {
						cnt++;
					}
				}else {
					cnt++;	
				}
			}
			lastvalue = value;
		}
	}
	return cnt;
    }
}
