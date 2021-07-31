package 백준;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon13460_EscapeBead {
	
	static int red_x;
	static int red_y;
	static int hole_x;
	static int hole_y;
	static int blue_x;
	static int blue_y;
	
	static int[]  x_move = {-1,0,1,0};
	static int[] y_move = {0,-1,0,1};
	static int[][] visit ;
	static char[][] map;
	public static ArrayList<Integer> sortestWay=new ArrayList();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x= sc.nextInt();
		int y= sc.nextInt();
		sc.nextLine();
		
		map= new char [x+1][y+1];
		visit = new int[x+1][y+1];
		
		for(int i = 0 ; i<x ; i++) {
			String str = sc.nextLine();
			for(int j=  0 ; j<y ; j++) {
				map[i][j]=str.charAt(j);
				if(str.charAt(j)=='B') {
					blue_x=i;
					blue_y=j;
				}
				else if(str.charAt(j)=='O') {
					hole_x=i;
					hole_y=j;
				}
				else if(str.charAt(j)=='R') {
					red_x=i;
					red_y=j;
				}
				
			}
		}
		BFS();
		int min=Integer.MAX_VALUE;
		int exist=0;
		for(int i=0; i<sortestWay.size() ; i++) {
			if(sortestWay.get(i)<=min && sortestWay.get(i)>=0) {
				min=sortestWay.get(i);
				exist=1;
			}
		}
		if(exist==1)
			System.out.println(min);
		else
			System.out.println("-1");
	}
	public static void BFS() {

		Queue<Points> queue=new LinkedList();
		Queue<Points> blue_queue=new LinkedList();
		Queue<Points> map_queue=new LinkedList();
		Queue<Points> visit_queue=new LinkedList();
		queue.add(new Points(red_x,red_y));
		blue_queue.add(new Points(blue_x,blue_y));
		map_queue.add(new Points(map));
		visit[red_x][red_y]=1;
		visit_queue.add(new Points(visit));
		boolean isCorrect=false;
		
		while(!queue.isEmpty()) {
			Points curPoint = queue.poll();
			Points bluePoint = blue_queue.poll();
			char[][] curMap = map_queue.poll().map;
			int[][] curVisit = visit_queue.poll().visit;
			
			for(int i=0 ; i<4 ; i++) {
				
				int x= curPoint.x+x_move[i];
				int y = curPoint.y + y_move[i];
				
				int blue_x= bluePoint.x+x_move[i];
				int blue_y = bluePoint.y + y_move[i];
				
				boolean isBlueInHole=false;
				
				while(curMap[x][y]=='.' || curMap[x][y]=='O' ) {
					
					if(x==hole_x && y ==hole_y) {
						isCorrect=true;
						break;
					}
					else {
						x+=x_move[i];
						y +=y_move[i];
					}
				}
				
				if(!isCorrect) {
				curMap[x-x_move[i]][y-y_move[i]]='R';
				curMap[curPoint.x][curPoint.y]='.';
				}
				else {
					curMap[x-x_move[i]][y-y_move[i]]='O';
					curMap[curPoint.x][curPoint.y]='.';
				}
				
				while(curMap[blue_x][blue_y] =='.' || curMap[blue_x][blue_y] =='O'  ) {
					if(blue_x==hole_x && blue_y ==hole_y) {
						isBlueInHole=true;
						break;
					}
					else {
						blue_x+=x_move[i];
						blue_y +=y_move[i];
						
					}
				}
				
				if(isBlueInHole) {
					if(isCorrect)
					{
						sortestWay.add(-1);
						break;
					}else
						continue;
				}else if(isCorrect) {
					//System.out.println(curVisit[curPoint.x][curPoint.y]);
					sortestWay.add(curVisit[curPoint.x][curPoint.y]);
					break;
				}
				
				if(curVisit[x -x_move[i]][y -y_move[i]]==0)
				{
					queue.add(new Points(x -x_move[i],y-y_move[i] ));
					curVisit[x -x_move[i]][y -y_move[i]]=curVisit[curPoint.x][curPoint.y]+1;
					
					blue_queue.add(new Points(blue_x -x_move[i],blue_y-y_move[i] ));
					//System.out.println("red 위치:"+(x -x_move[i])+","+(y-y_move[i] ));
					//System.out.println("blue 위치:"+(blue_x -x_move[i])+","+(blue_y-y_move[i] ));
					
					curMap[blue_x-x_move[i]][blue_y-y_move[i]]='B';
					curMap[bluePoint.x][bluePoint.y]='.';

					map_queue.add(new Points(curMap));
					visit_queue.add(new Points(curVisit));
					
				}
				else {
					curMap[x-x_move[i]][y-y_move[i]]='.';
					curMap[curPoint.x][curPoint.y]='R';
					curMap[blue_x-x_move[i]][blue_y-y_move[i]]='.';
					curMap[bluePoint.x][bluePoint.y]='B';
				}
			}
		}
		if(sortestWay.size()==0) {
			sortestWay.add(-1);
		}
	}
}
class Points{
	int x;
	int y;
	char[][] map;
	int[][] visit;
	public Points(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public Points(char[][] map) {
		this.map=map;
	}
	public Points(int[][] visit) {
		this.visit=visit;
	}
}
