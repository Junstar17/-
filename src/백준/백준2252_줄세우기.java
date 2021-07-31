package 백준;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/*
class Node implements Cloneable{
	Node next;
	Node prev;
	int number;
	boolean isHeader;
	
	public Node(int number) {
		this.number = number;
		this.isHeader = true;
	}
	public void connect(Node n1, Node n2) throws CloneNotSupportedException {
		if(n1.prev == n2 && n2.next == n1) {
			switchNode(n1,n2);
		}else {
			if(n1.next == null) {
				n1.next=n2;
				n2.isHeader= false;
			}else {
				n1.next.next=n2;
				n2.prev = n1.next;
				n2.isHeader = false;
			}
			
			if(n2.prev == null) {
				n2.prev = n1;
				n2.isHeader = false;
			}else {
				n2.prev.prev = n1;
				n1.next = n2.prev;
				n2.prev.isHeader = false;
			}
		}
		
	}
	public void switchNode(Node n1, Node n2) throws CloneNotSupportedException {
	
		Node tempNode = (Node)n2.clone();
		
		n2.next = n1.next;
		n2.prev = n1;
		n2.isHeader = n1.isHeader;
		
		n1.next = n2;
		n1.prev = tempNode.prev;
		n1.isHeader = tempNode.isHeader;
		
		
	}
}
*/
public class 백준2252_줄세우기 {

	public static void 위상정렬(List<List<Integer>> list,int[] indegree) {
		Queue<Integer> queue= new LinkedList<>();
		Queue<Integer> result= new LinkedList<>();
		for(int i=0;i<indegree.length ; i++) {
			if(indegree[i] ==0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int node = queue.poll();
			result.add(node);
			
			for(int i=0; i<list.get(node).size() ; i++) {
				int n = list.get(node).get(i);
				indegree[n] --;
				
				if(indegree[n] ==0) {
					queue.add(n);
				}
			}
		}
		int size = result.size();
		for(int i=0; i<size;i++) {
			System.out.print(result.poll()+1+" ");	
		}
		
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int[] indegree = new int[N];
		for(int i=0; i<N ; i++) {
			list.add(new ArrayList());
		}
		
		for(int i=0; i<M ; i++) {
			int front = sc.nextInt()-1;
			int back = sc.nextInt()-1;
			list.get(front).add(back);
			indegree[back]++;
		}
		위상정렬(list,indegree);
		/*
		List<Node> list = new ArrayList<>();
		for(int i=1; i <=N ; i++) {
			list.add(new Node(i));
		}
		for(int i=0 ; i< M ;i++) {
			int front = sc.nextInt();
			int back = sc.nextInt();
			Node frontNode = list.get(front-1);
			Node backNode = list.get(back-1);
			frontNode.connect(frontNode, backNode);
		}
		List<Node> answer = new ArrayList();
		for(int i=0; i <N ; i++) {
			Node n = list.get(i);
			if(n.isHeader) {
				StringBuilder sb = new StringBuilder();
				sb.append(n.number+" ");
				while(n.next != null) {
					n = n.next;
					sb.append(n.number+" ");
				}
				System.out.println(sb);
			}
//			Node n = list.get(i);
//			if(!answer.contains(n)) {
//				if(answer.contains(n.next)) {
//					answer.add(answer.indexOf(n.next), n);
//				}else if(answer.contains(n.prev)) {
//					answer.add(answer.indexOf(n.prev)+1, n);
//				}else {
//					answer.add(n);
//				}
//				
//				if(n.next != null && !answer.contains(n.next)) {
//					answer.add(n.next);
//				}
//				if(n.prev != null && !answer.contains(n.prev)) {
//					answer.add(answer.indexOf(n), n.prev);
//				}
//			}
		}
		for(int i=0 ; i<answer.size() ; i++) {
			System.out.print(answer.get(i).number+" ");
		}
		*/
	}

}
