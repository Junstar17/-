package 백준;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DFS_BFS_Algorithm {
	
	static int vertex;
	static int line;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt();
		line = sc.nextInt();
		int start = sc.nextInt();
		
		boolean[] a=new boolean[vertex+3];
		boolean[] b=new boolean[vertex+3];
		
		int[][] V = new int[vertex+1][vertex+1];
		
		for(int i =0;  i<line ; i++) {
			
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			
			V[a1][a2]=1;
			V[a2][a1]=1;
		}
		
		//SearchByDFS(arrayList,a,start);
		dfs(V,a,start);
		System.out.println("");
		SearchByBFS(V,b,start);
	}
	public static void SearchByDFS(ArrayList<Integer>[] arrayList , boolean[] a , int v ) { 
		
		Stack<Integer> stack = new Stack();
		// 초기스택에 처음값을 넣어주고 지나갔다는 의미의 true 값을 넣어준다.
		stack.push(v);
		a[v]=true;
		System.out.print(v+" ");
		while(!stack.empty()) {
			int curVertext=stack.peek();
			int n= arrayList[curVertext].size();
			boolean exist=true;
			Collections.sort(arrayList[curVertext]);
			for(int i = 0 ; i< n ; i++) {
				if(a[arrayList[curVertext].get(i)] != true) {
					stack.push(arrayList[curVertext].get(i));
					System.out.print(arrayList[curVertext].get(i)+" ");
					a[arrayList[curVertext].get(i)]=true;
					exist=false;
					break;
				}
			}
			if(exist) {
				if(!stack.empty())
					stack.pop();
			}
		}
		System.out.println("");
	}
	public static void dfs(int[][] arrayList , boolean[] visit,int n){
		visit[n]=true;
		System.out.print(n+" ");
		for(int i=1; i<=vertex ;i++){
			if(visit[i]==false && arrayList[n][i]==1){
				dfs(arrayList,visit,i);
			}
		}
	}
	public static void SearchByBFS(int[][] arrayList , boolean[] a , int v ) {
		
		Queue<Integer> queue = new LinkedList();
		
		queue.add(v);
		a[v]=true;
		System.out.print(v+" ");
		while(!queue.isEmpty()) {
			int curVertex=queue.poll();
			
			for(int i=1 ; i<=vertex ; i++) {
				if(a[i] == false && arrayList[curVertex][i]==1) {
					queue.add(i);
					a[i]=true;
					System.out.print(i+" ");
				}
			}
		}
		System.out.println("");
	}
}
/*
 *
 6 8 1
 1 2
 1 5
 2 3
 2 4
 2 5
 3 
 
 
 */
