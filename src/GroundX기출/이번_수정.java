package GroundX기출;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Node2 {
	int number;
	Node2 _next;
	int order;
	
	public Node2(int number) {
		this.number = number;
		this.order =-1;
	}
	
	public Node2(int number, int order) {
		this.number = number;
		this.order = order;
	}
	
	public void makeChildNode(Node2 child) {
        this._next = child;
     }
}
public class 이번_수정 {

	static boolean[] visitied;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 2000000000;
		int[] mark = new int[] {1,7,6,5,1,4,3,2};
		long beforeTime = System.currentTimeMillis(); 
		System.out.println(solution(num,mark));
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
	}

	public static int solution(int num, int[] mark) {
		visitied = new boolean[mark.length];
		int result = -1;
		Set<Integer> set = Arrays.stream(mark).boxed().collect(Collectors.toSet());
		
		if(set.size() == mark.length && !set.contains(0)) {
			System.out.println("no cycle");
			result = dfs(mark[0],mark,1,num);
		}else {
			result = findCycle2(num, mark);
		}
		return result;
	}
	 public static int dfs(int num,int[] mark, int cnt,int target) {
			 if(target == cnt) {
				 return num;
			 } else {
				 return dfs(mark[num],mark, cnt+1,target);
			 }
			 
	}
	 public static int findCycle2(int num, int[] mark) {
		 int result = -1;
		 HashMap<Integer,Node2> map = new HashMap<>();
		 boolean[] visited = new boolean[mark.length];
		 int i = 0;
		 int cnt =0;
		 map.put(i, new Node2(i,cnt++));
		 visited[i] = true;
		 Node2 cycleNode;
		 Node2 cycleBeforeNode;
		 while(true) {
			 int target = mark[i];
			 if(cnt == num) {
				 result = target;
				 System.out.println(result);
				 return result;
			 }
			 
			if(!map.containsKey(target)) {
				map.put(target, new Node2(target,cnt));
			}
			
			Node2 parentNode = map.get(i);
			Node2 childNode = map.get(target);
	        parentNode.makeChildNode(childNode);
	        if(visited[target]) {
	        	cycleNode = childNode;
	        	cycleBeforeNode= parentNode;
	        	break;
	        }else {
	        	visited[target] = true;	
	        }
	        
	        i = target;
	        cnt ++;
		 }
		 if(cycleNode != null) {
			 int start = cycleNode.order;
			 int cycleLength = cycleBeforeNode.order - start + 1;
			 
			 int target_idx = (num - start) % cycleLength ;
			 
			 Node2 resultNode = cycleNode;
			 for(int j=0; j<target_idx; j++) {
				 resultNode = resultNode._next;
			 }
			 result = resultNode.number;
			 System.out.println("사이클:"+result);
		 }
		 return result;
	 }
	 
	 
	 
	 public static int findCycle(int num, int[] mark) {
		 HashMap<Integer,Node2> map = new HashMap<>();
		 int result =-1;
		 System.out.println("cycle");
			int cycleIdx = 0;
			visitied[0] = true;
			for(int i=0; i<mark.length; i++) {
				if(!map.containsKey(i)) {
					map.put(i, new Node2(i));
				}
				if(!map.containsKey(mark[i])) {
					map.put(mark[i], new Node2(mark[i]));
				}
				
				Node2 parentNode = map.get(i);
				Node2 childNode = map.get(mark[i]);
		        parentNode.makeChildNode(childNode);
		         
				if(!visitied[mark[i]] ) {
					visitied[mark[i]] = true;
				}else {
					cycleIdx = mark[i];
				}
			}
			
			Node2 node = map.get(0);
			int cnt=0;
			int start =-1;
			int end =-1;
			HashMap<Integer,Node2> orderMap = new HashMap<>();
			int orderMapIdx =0;
			while(true) {
				if(node.number == cycleIdx) {
					if(node.order ==-1) {
						start =cnt;
						orderMap.put(orderMapIdx++, node);
						node.order = cnt;
						cnt ++;
						
						node = node._next;
						continue;
					}else {
						end = cnt;
						break;
					}
				}
				if(orderMapIdx>0) {
					orderMap.put(orderMapIdx++, node);
				}
				node.order = cnt;
				cnt ++;
				
				node = node._next;
				
				if(cnt == num) {
					result= node.number;
					return result;
				}
			}
			
			if(result>0) {
				return result;
			}
			 int 차감된횟수 = num -start;
			 int 사이클 = end -start;
			 
			 int 나머지 = 차감된횟수 % 사이클;
			 
			 return result = orderMap.get(나머지).number;
	 }
}
