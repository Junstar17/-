package 카카오기출.커머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 일번문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(solve(1, new String[] {"1 fracta", "1 sina","1 hana","1 robel","1 abc", "1 sina", "1 lynn"}));
		System.out.println(solve(4, new String[] {"1 a","1 b","1 abc","3 b","3 a","1 abcd","1 abc","1 aaa","1 a","1 z","1 q", "3 k", "3 q", "3 z", "3 m", "3 b"}));
	}
	public static List<String> solve(int n, String[] array){
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		for(int i=0; i<array.length ; i++) {
			String data = array[i];
			int key = Integer.parseInt(data.split(" ")[0]);
			String value = data.split(" ")[1];
			List<String > list = map.get(key);
			if(list == null) {
				List<String> subList = new ArrayList();
				subList.add(value);
				map.put(key, subList);
			}else if(list.size()==5) {
				if(!list.contains(value)) {
					list.remove(0);
					list.add(value);
				}
			}
			else {
				if(!list.contains(value)) {
					list.add(value);
				}
			}
		}
		List<String> result = new ArrayList();
		for(List<String> list : map.values()) {
			result.addAll(list);
		}
		return result;
	}
	

}
