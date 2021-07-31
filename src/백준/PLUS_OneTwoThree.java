package 백준;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PLUS_OneTwoThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int num = 0;
		ArrayList list = new ArrayList();
		for (int i = 0; i < count; i++)
			list.add(sc.nextInt());

		for (int i = 0; i < count; i++) {
			num = (int) list.get(i);

			Queue<Integer> queue = new LinkedList<>();
			queue.offer(num);

			int total = 0;

			while (true) {

				if (num > 0) {
					queue.offer(num - 1);
				}
				if (num > 1) {
					queue.offer(num - 2);
				}
				if (num > 2) {
					queue.offer(num - 3);
				}

				queue.poll();
				if (queue.isEmpty()) {
					break;
				}
				num = queue.peek();
				if (num == 0)
					total++;

			}
			System.out.println(total);
		}
	}

}
