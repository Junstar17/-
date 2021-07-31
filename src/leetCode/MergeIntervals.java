package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//merge2(new int[][] {{2,6},{1,3},{8,10},{15,18}});
		merge2(new int[][] {{1,10},{4,6},{3,5}});
	}

	public static int[][] merge(int[][] intervals) {
		ArrayList<int[]>list = new ArrayList<>();
        int idx =0;
        int start =intervals[0][0];
		while( idx < intervals.length) {
			if(idx == intervals.length -1) {
				list.add(new int[] {start,intervals[idx][1]});
				break;
			}
			if(intervals[idx][1] >= intervals[idx+1][0]) {
				start = intervals[idx][0] < intervals[idx+1][0]? intervals[idx][0] : intervals[idx+1][0]  ;
				idx++;
			}else {
				list.add(new int[] {start,intervals[idx][1]});
				idx++;
				start= intervals[idx][0];
			}
		}
		int[][] result =new int[list.size()][2];
		for(int i=0;i <list.size() ;i ++) {
			result[i] = list.get(i);
		}
		return result;
    }
	public static int[][] merge2(int[][] intervals) {
		ArrayList<int[]>list = new ArrayList<>();
		Arrays.sort(intervals, (t1, t2)-> {
			return Integer.compare(t1[0], t2[0]);
		});
		
        int idx =0;
        int start =intervals[0][0];
        int end = intervals[0][1];
		while( idx < intervals.length) {
			if(idx == intervals.length -1) {
				end = end > intervals[idx][1]? end : intervals[idx][1]  ;
				list.add(new int[] {start,end});
				break;
			}
			if(end >= intervals[idx+1][0]) {
				start = start < intervals[idx+1][0]?start : intervals[idx+1][0]  ;
				end = end > intervals[idx+1][1]? end : intervals[idx+1][1]  ;
				idx++;
			}else {
				list.add(new int[] {start,end});
				idx++;
				start= intervals[idx][0];
				end = intervals[idx][1];
			
			}
		}
		int[][] result =new int[list.size()][2];
		for(int i=0;i <list.size() ;i ++) {
			result[i] = list.get(i);
		}
		return result;
    }
}
