package leetCode;
import java.util.Arrays;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] height = new int[] {1,2,1};
		System.out.println(maxArea(height));
	}
	public static int maxArea(int[] height) {
        
		int front =0;
		int rear = height.length-1;
		int max = 0;
		while(front < rear) {
			int height_front = height[front];
			int height_rear = height[rear];
			int weight=0;
			
			if(height_front< height_rear) {
				weight = (rear - front) * height_front;
				front++;
			}else {
				weight = (rear - front) * height_rear;
				rear--;
			}
			if(max < weight) {
				max = weight;
			}
		}
		return max;
    }

}
