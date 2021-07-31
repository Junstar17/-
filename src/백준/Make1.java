package 백준;
import java.awt.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Pair<Integer1,Integer2> {
    public Integer1 first;
	public Integer2 second;
    public Pair(Integer1 first,Integer2 second) {
    	this.first=first;
    	this.second=second;
    	
    }
}
public class Make1 {

	
	static boolean [] visited = new boolean[1000001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int count=0;

		Queue<Pair<Integer,Integer>> queue=new LinkedList();
		Pair<Integer,Integer> map = new Pair<Integer,Integer>(num,count);
		queue.offer(map);
		
		while(true) {
			
			if(num==1) {
				System.out.println(queue.poll().second);
				break;
			}
			
			if(!visited[num -1]) {
				queue.offer(new Pair<>(num-1,count+1));
			}
			if(!visited[num/2] && num%2 ==0 ) {
				queue.offer(new Pair<>(num/2,count+1));
			}
			if(!visited[num/3] && num %3 == 0) {
				queue.offer(new Pair<>(num/3,count+1));
			}
			
			visited[num]=true;
			queue.poll();
			num= queue.peek().first;
			count=queue.peek().second;
			
			
			
		}
		
		
	}

}
