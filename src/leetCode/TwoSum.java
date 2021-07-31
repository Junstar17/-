package leetCode;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int[] solution(int[] nums, int target) {
	   	int answer1 = 0;
        int answer2 =0;
        for(int i=0; i<nums.length ; i++){
            for(int j=i+1 ; j<nums.length ; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
	}

}
