package 프로그래머스.정렬;
import java.util.Arrays;

public class K번째수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = new int[][] { {2,5,3},{4,4,1},{1,7,3}};
		
		int[] answer = solution(array,commands);
		
		for(int i : answer) {
			System.out.println(i);	
		}
		
	}
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length ];
        
        for(int i=0 ; i<commands.length ; i++) {
        	int[] command = commands[i];
        	
        	int[] temp_array =new int[command[1]-command[0]+1];
        	int idx =0;
        	for(int j =command[0] -1 ; j<= command[1] -1 ; j++) {
        		temp_array[idx++]=array[j];
        	}
        	Arrays.sort(temp_array);
            answer[i] = temp_array[command[2]-1];
        }
        return answer;
    }

	// 모범 답안
	public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
