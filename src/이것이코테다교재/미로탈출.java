package 이것이코테다교재;

import java.util.LinkedList;
import java.util.Queue;


class Data {
	int x;
	int y;
	int length;
	int[][] miro;
	
	public Data (int x,int y, int length, int[][] miro) {
		this.x=x;
		this.y=y;
		this.length=length;
		this.miro=miro;
	}
}
public class 미로탈출 {

	static int x_length;
	static int y_length;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 5;
		int M = 6;
		int[][] miro = new int[][] {
			{1,0,1,0,1,0},
			{1,1,1,1,1,1},
			{0,0,0,0,0,1},
			{1,1,1,1,1,1},
			{1,1,1,1,1,1},
		};
		x_length = miro[0].length;
		y_length = miro.length;
		solution(N,M,miro);
	}
	
	public static int solution(int N,int M, int[][] miro) {
		
		check( M-1,N-1,0,0, miro);
		System.out.println(result);
		return 0;
	}
	
	public static void check(int x_target,int y_target,int x,int y, int[][] miro) {
		
		Queue<Data> queue =new LinkedList<>();
		queue.add(new Data(x,y,1,miro));
		
		while(!queue.isEmpty()) {
			Data data = queue.poll();
			
			if (data.x <0 || data.x > miro[0].length -1 || data.y <0 || data.y > miro.length-1) {
				continue;
			}
			if (data.x == x_target && data.y == y_target) {
				if (data.length < result) {
					result = data.length;
				}
				continue;
			}
			
			if(data.miro[data.y][data.x] == 1) {
				
				int[][] new_miro = new int[y_length][x_length];
				for(int i=0; i<y_length ; i++) {
					System.arraycopy(data.miro[i], 0, new_miro[i],0, data.miro[0].length);
				}
				new_miro[data.y][data.x] = 0;
				queue.add(new Data(data.x+1, data.y, data.length+1, new_miro));
				queue.add(new Data(data.x, data.y+1, data.length+1, new_miro));
				queue.add(new Data(data.x -1, data.y, data.length+1, new_miro));
				queue.add(new Data(data.x, data.y-1, data.length+1, new_miro));
			}
		}
		
	}

}
