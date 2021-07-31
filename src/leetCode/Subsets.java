package leetCode;
import java.util.ArrayList;
import java.util.List;

public class Subsets {

	static boolean[] visited;
	static List<List<Integer>> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		subsets(new int[] {1,2,3});
	}

    public static List<List<Integer>> subsets(int[] nums) {
        
    	list = new ArrayList();
    	visited = new boolean[nums.length];
    	list.add(new ArrayList());
    	dfs(nums,0,nums.length,new ArrayList());
    	return list;
    }
    
    public static void dfs(int[] nums,int idx,  int target,List<Integer> sublist) {
    	if(idx == target) {
    		return;
    	}else {
    		
    		for(int i=idx; i < nums.length ; i++) {
    			if(visited[i])
    				continue;
    			visited[i] = true;
    			sublist.add(nums[i]);
    			list.add(new ArrayList(sublist));
    			dfs(nums,i+1,target,sublist);
    			sublist.remove(sublist.size()-1);
    			visited[i] = false;
    		}
    		
    	}
    }
}
