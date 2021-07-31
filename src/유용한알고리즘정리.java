import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 유용한알고리즘정리 {
/*
	// 2차원리스트
	List<List<Integer>> arrayLists = new ArrayList((new ArrayList()));
	
	// 큰값을 문자화
	char[] numbers = String.valueOf(Math.abs(x)).toCharArray();
	
	// 2차원 배열에서 0번째 인덱스를 기준으로 정렬하기
	Arrays.sort(intervals, (t1, t2)-> {
		return Integer.compare(t1[0], t2[0]);
	});
	
	// 더 큰값으로 갱신해나가는 과정
	 max = Math.max(next_unit,Math.max(min_new, max_new));
	 min = Math.min(next_unit,Math.min(max_new, min_new));
	 unit = Math.max(max,unit);
	 
	 // 여러 숫자 배열중 가장 큰 숫자의 조합을 찾아나가는 소팅 방법(LargestNumber)
	 Collections.sort(list,(a,b) -> {
		 String as = a.toString() , bs = b.toString();
		 return -Long.compare(Long.parseLong(as+bs), Long.parseLong(bs+as));
	 });
	 
	 // 트리형으로 빠르게 타겟넘버를 찾아나가는 DFS유형
		public static int DFS(int[] numbers, int index, int sum, int target) {
			if(index == numbers.length) {
				return sum == target ? 1 : 0;
			}else {
				return DFS(numbers,index+1,sum + numbers[index],target)+DFS(numbers,index+1,sum - numbers[index],target);
			}
		}
		
		// ArrayList 를 int[] 로 변환
		int[] answer = list.stream().mapToInt(i ->i).toArray();
		
		// char 비교
		 if(answer.charAt(0) == '0' ) {}
		 
		 // 배열복사 array 의 from,to (K번째 수)
		 int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			 
		 // 소수찾기  - 문자열을 문자단위로 쪼갠후 int[]배열에 삽입
		 String numbers = "011";
		 int[] array = Arrays.stream(numbers.split("")).mapToInt(Integer::valueOf).toArray();
		 
		 // char[] -> String
		  * char[] result = new char[indices.length];
		  new String(result);
		 
		 // 완전탐색
		  * public static int sumSubarrayMins(int[] arr) {
		visited = new boolean[arr.length];
		list = new ArrayList<>();
		dfs(0,new ArrayList<>(), arr,arr.length);
		return 0;
    	}

			public static void dfs(int idx , ArrayList arrayList , int[] arr, int target) {
				if(idx >= target) {
					return;
				}else {
					for(int i=idx ; i< arr.length ; i++) {
						if(!visited[i]) {
							visited[i] = true;
							arrayList.add(arr[i]);
							list.add(new ArrayList(arrayList));
							dfs(i+1, arrayList,arr,target);
							arrayList.remove(arrayList.size()-1);
							visited[i] = false;
						}
					}
				}
			}
			
			// 인접한 완전탐색
		 public static int sumSubarrayMins(int[] arr) {
		visited = new boolean[arr.length];
		list = new ArrayList<>();
		for(int i=0; i<arr.length ; i++) {
			dfs(i,new ArrayList<>(), arr,arr.length);
		}
		
		int minValue = 0;
		for(List<Integer> subList : list) {
			int min =Collections.min(subList);
			minValue += min;
		}
		return minValue;
    }

	public static void dfs(int idx , ArrayList arrayList , int[] arr, int target) {
		if(idx >= target) {
			return;
		}else {
			if(!visited[idx]) {
				visited[idx] = true;
				arrayList.add(arr[idx]);
				list.add(new ArrayList(arrayList));
				dfs(idx+1, arrayList,arr,target);
				arrayList.remove(arrayList.size()-1);
				visited[idx] = false;
			}
		}
	}
	// 배열 복사
	 * 	 int[] A_array = A.clone();
		 int[] B_array = B.clone();
		 
		 Arrays.sort(A_array);
		 Arrays.sort(B_array,Collections.reverseOrder());
		 
		*/
	
	// 입력,출력 소요시간 단축하기
	/*
	BufferedReader reader= new BufferedReader( new InputStreamReader(System.in));
	int N= Integer.parseInt(reader.readLine());
	
	StringBuilder sb = new StringBuilder();
	for(int i=0; i<N; i++) {
		sb.append(arr[i]).append("\n");
	}
	*/
}
