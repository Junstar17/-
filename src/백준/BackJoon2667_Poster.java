package 백준;
import java.beans.Visibility;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BackJoon2667_Poster {

	static int[] x_move= {-1,0,1,0};
	static int[] y_move= {0,-1,0,1};
	static int[][] visit;
	static int V[][];
	static int[] numOfHouse ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		V = new int[num+3][num+3];
		visit = new int[num+3][num+3];
		
		for(int i= 1 ; i<=num ; i++) {
			String str = sc.nextLine();
            for (int j = 1; j <=num ; j++) {
                V[i][j] = str.charAt(j-1)-'0';
            }
		}
		numOfHouse =new  int[num*num];
		int idx = 0;
		for(int i= 1 ; i<=num ; i++) {
            for (int j = 1; j <=num ; j++) {
            	if(V[i][j] != 0 && visit[i][j]==0) {
            		numOfHouse[idx]=1;
            		DFS(i,j,idx);
            		idx++;
            	}
            }
		}
		System.out.println(idx);
		// 정렬할때 배열이 전체 꽉 차있지않고 idx개만 데이터고 나머지는 0이 섞여있다면 다음과 같이 정렬한다
		Arrays.sort(numOfHouse,0,idx);
		for(int i = 0 ; i<idx ; i++)
			System.out.println(numOfHouse[i]);
	}
	public static void DFS(int i , int j,int idx) {
		Stack<Point> stack  = new Stack();
		stack.add(new Point(i,j));
		visit[i][j]=1;
		
		while(!stack.empty()) {
			Point point = stack.peek();
			boolean exist=false;
			for(int k = 0 ; k <4 ; k++) {
				int x = point.x +x_move[k];
				int y = point.y +y_move[k];
				
				if(V[x][y] == 0 || visit[x][y] != 0)
					continue;
				stack.add(new Point(x,y));
				visit[x][y] = visit[point.x][point.y]+1;
				numOfHouse[idx]=numOfHouse[idx]+1;
//				if(numOfHouse[idx]<visit[x][y]) {
//					numOfHouse[idx]=visit[x][y];
//					System.out.println("방문횟수"+visit[x][y]);
//				}
				exist=true;
				break;
			}
			if(!exist)
				stack.pop();
		}
	}
}
class Point{
	int x;
	int y;
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
}