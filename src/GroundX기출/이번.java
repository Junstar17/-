package GroundX기출;

public class 이번 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 15;
		int[] mark = new int[] {1,7,6,5,0,4,3,2};
		solution(num,mark);
	}
	
	 public static int solution(int num, int[] mark) {
	     
		 int result=-1;
		 boolean[] visited = new boolean[mark.length];
		 
		 int cnt = 0;
		 int idx =0;
		 int stopValue = -1;
		 int lastValue =-1;
		 visited[0] = true;
		 while(cnt<num) {
			 int pointed = mark[idx];
			 idx = pointed;
			 cnt ++;
			 if (!visited[pointed]) {
				 visited[pointed] = true;	 
				 lastValue = pointed;
			 }else {
				 stopValue = pointed;
				 break;
			 }
		 }
		 
		 if(stopValue <0) {
			 result = lastValue;
		 }
		 else {
			 int start = -1;
			 int end = -1;
			 for(int i=0; i<mark.length; i++) {
				 if(mark[i] == stopValue) {
					 if(stopValue ==0) {
						 start = 0;
						 end = i + 1;
						 break;
					 } else {
						 if(start <0) {
							 start =i;	 
						 }else {
							 end =i;
							 break;
						 }
					 }
				 }
			 }
			 
			 int 차감된횟수 = num -1 -start;
			 int 사이클 = end -start;
			 
			 int 나머지 = 차감된횟수 % 사이클;
			 
			 result = mark[start +나머지];
		 }
		System.out.println(result);
		 return result;
		 
		 
//		 int answer = point(mark[0],mark,1,num);
//	        System.out.println(answer);
//	        return answer;
	    }
	 public static int point(int num,int[] mark, int cnt,int target) {
		 
		 if(target == cnt) {
			 return num;
		 } else {
			 return point(mark[num],mark, cnt+1,target);
		 }
		 
	 }
}
