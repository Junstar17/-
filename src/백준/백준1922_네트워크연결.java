package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	int start;
	int end;
	int cost;
	
	public Node(int start,int end,int cost) {
		this.start=start;
		this.end=end;
		this.cost=cost;
		
	}

	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		return this.cost >= arg0.cost ? 1 : -1;
	}
}
public class 백준1922_네트워크연결 {

	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result=0;
		int N = Integer.valueOf(br.readLine());
		int M = Integer.valueOf(br.readLine());
		PriorityQueue<Node> queue = new PriorityQueue();
		parent = new int[N+1];
		String[] temp;
		for(int i=0; i<M ; i++) {
			temp= br.readLine().split(" ");
			queue.add(new Node(Integer.valueOf(temp[0]),Integer.valueOf(temp[1]),Integer.valueOf(temp[2])));
		}
		for(int i=1 ; i <=N ;i++) {
			parent[i] = i;
		}
		
		for(int i=0; i <M; i++) {
			Node node = queue.poll();
			int start = node.start;
			int end = node.end;
			int cost =node.cost;
			
			int a = find(start);
			int b = find(end);
			if(a==b)
				continue;
			result += cost;
			union(start,end);
		}
		System.out.println(result);
	}
	public static void union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parent[aRoot] = b;
		}else {
			return;
		}
	}
    public static int find(int n) {
		if( n == parent[n])
			return n;
		parent[n] =find(parent[n]);
		return parent[n];
	}
}
