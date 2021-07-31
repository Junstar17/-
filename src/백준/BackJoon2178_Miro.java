package 백준;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon2178_Miro {

	static int[] x_move= {-1,0,1,0};
	static int[] y_move= {0,1,0,-1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		int y = sc.nextInt();
		sc.nextLine();
		
		int[][] V = new int[x+2][y+2];
		int size=y;
		boolean[][] visit=new boolean[x+2][y+2];
		for (int i = 0; i < x; i++) {
            String str = sc.nextLine();
            for (int j = 0; j <y; j++) {
                V[i+1][j+1] = str.charAt(j)-'0';
            }
        }
		bfs(V,visit,x,y);
	}
	public static void bfs(int[][] V , boolean[][] a , int ans_x , int ans_y ) {
		Queue<Dot> queue = new LinkedList();
		
		int x=1;
		int y=1;
		
		queue.offer(new Dot(x,y));
		a[x][y]=true;
		while(!queue.isEmpty()) {
			boolean exist=true;
			Dot dot=queue.poll();
			for(int i=0 ; i<4 ; i++) {
				x=dot.x+x_move[i];
				y = dot.y+y_move[i];
				
				if(V[x][y]==0 || a[x][y]==true) {
					continue;
				}
				queue.offer(new Dot(x,y));
				a[x][y]=true;
				V[x][y]=V[x-x_move[i]][y-y_move[i]]+1;
				if( (x == ans_x) && (y+1== ans_y)) {
					break;
				}
				
			}
		}
		System.out.println(V[ans_x][ans_y]);
	}
}
class Dot{
	int x;
	int y;
	public Dot(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
