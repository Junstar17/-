package 백준;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pairs<Integer1, Integer2, Integer3> {
	Integer1 curIdx;
	Integer2 sum;
	Integer3 beforeIdx;

	public Pairs(Integer1 curIdx, Integer2 sum, Integer3 beforeIdx) {
		this.curIdx = curIdx;
		this.sum = sum;
		this.beforeIdx = beforeIdx;
	}
}

public class GoUpStair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int numOfAttr = sc.nextInt();
		int[] arr=new int[305];
		/*ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < numOfAttr; i++) {
			list.add(sc.nextInt());
		}*/
		for (int i = 0; i < numOfAttr; i++) {
			arr[i]=sc.nextInt();
		}
		
		
		Queue<Pairs<Integer, Integer, Integer>> queue = new LinkedList<>();
		int curIdx = 0;
		int beforeIdx = -2;
		//int sum = list.get(curIdx);
		int sum=arr[curIdx];
		int maxSum = 0;
		// queue.offer(new Pairs<>(curIdx,sum,beforeIdx));
		while (true) {

			if (beforeIdx == curIdx - 1) {
				if (curIdx + 2 < numOfAttr)
					queue.offer(new Pairs<>(curIdx + 2, sum, curIdx));

			}
			if (beforeIdx == curIdx - 2) {
				if (curIdx + 1 < numOfAttr)
					queue.offer(new Pairs<>(curIdx + 1, sum, curIdx));
				if (curIdx + 2 < numOfAttr)
					queue.offer(new Pairs<>(curIdx + 2, sum, curIdx));
			}

			Pairs<Integer, Integer, Integer> temp_pair = queue.poll();

			//sum = list.get(temp_pair.curIdx) + temp_pair.sum;
			sum = arr[temp_pair.curIdx] + temp_pair.sum;
			beforeIdx = temp_pair.beforeIdx;
			curIdx = temp_pair.curIdx;

			if (curIdx == numOfAttr - 1) {
				if (maxSum <sum)
					maxSum = sum;
			}

			if (queue.isEmpty())
				break;
		}
		System.out.println(maxSum);
	}

}
