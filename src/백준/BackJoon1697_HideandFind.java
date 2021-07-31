package 백준;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;

import javafx.scene.shape.CullFace;

public class BackJoon1697_HideandFind {

	static int min=Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int my_position = sc.nextInt();
		int his_position = sc.nextInt();
		if(my_position==his_position) {

			System.out.println(0);

			System.exit(0);

		}
		int[] visit = new int[200001];
		BFS(my_position,his_position ,visit);
	}
	public static void BFS(int my, int his , int[] visit) {
		
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(my,1));
		while(!queue.isEmpty()) {
			
			Info curInfo=queue.poll();
			
			if(curInfo.pos+1 >=0 && curInfo.pos+1 <= 100000 && visit[curInfo.pos+1] !=1) {
				if(curInfo.pos+1 == his) {
					System.out.println(curInfo.cnt);
					break;
				}
				queue.add(new Info(curInfo.pos+1,curInfo.cnt+1));
				visit[curInfo.pos+1]=1;
			}
			if(curInfo.pos-1 >=0 && curInfo.pos-1 <= 100000 && visit[curInfo.pos-1] !=1) {
				if(curInfo.pos-1 == his) {
					System.out.println(curInfo.cnt);
					break;
				}
				queue.add(new Info(curInfo.pos-1,curInfo.cnt+1));
				visit[curInfo.pos-1]=1;
			}
			if(curInfo.pos*2 >=0 && curInfo.pos*2 <= 100000 && visit[curInfo.pos*2] !=1) {
				if(curInfo.pos*2 == his) {
					System.out.println(curInfo.cnt);
					break;
				}
				queue.add(new Info(curInfo.pos*2,curInfo.cnt+1));
				visit[curInfo.pos*2]=1;
			}
		}
	}
}
class Info{
	int pos;
	int cnt;
	public Info(int pos , int cnt) {
		this.pos=pos;
		this.cnt=cnt;
	}
	
}
