package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	static List<List<Integer>> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		combinationSum(new int[] {2,3,6,7} , 7);
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
		list =new ArrayList();
 		Arrays.sort(candidates);
 		dfs(candidates,new ArrayList(),target,0,0);
 		return list;
    }
	
	public static void dfs(int[] array ,ArrayList<Integer> stack, int target,int idx, int sum) {
		if(sum > target) return;
		else if(sum == target) {
			list.add(new ArrayList(stack));
		}
		else {
			for(int i=idx; i< array.length ; i++) {
				stack.add(array[i]);
				dfs(array,stack,target,i,sum + array[i]);
				stack.remove(stack.size()-1);
			}
		}
	}
	
	

}
