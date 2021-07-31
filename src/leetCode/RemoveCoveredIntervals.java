package leetCode;
import java.util.Arrays;

public class RemoveCoveredIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(removeCoveredIntervals(new int[][] {{1,4},{3,6},{2,8}}));
	}
	 public static int removeCoveredIntervals(int[][] intervals) {
		 int result= intervals.length;
		 int cnt =0;
		 Arrays.sort(intervals, (t1, t2)-> {
				return Integer.compare(t1[0], t2[0]);
		});
		 
		 int idx = 0;
		 
		 int start = intervals[idx][0];
		 int end = intervals[idx][1];
		 boolean empty = false;
		 while( idx< intervals.length-1) {
			 
			 if(empty) {
				 start = intervals[idx][0];
				 end = intervals[idx][1];
				 empty= false;
			 }
			 int next_start = intervals[idx+1][0];
			 int next_end = intervals[idx+1][1];
			 
			 if(start <= next_start && end >= next_end) {
				 cnt++;
			 }
			 else if(next_start<= start  && next_end >= end ) {
				 cnt++;
				 start =next_start;
				 end = next_end;
			 }else {
				 empty = true;
			 }
			 idx++;
		 }
		 return result - cnt;
		 
	 }
}
