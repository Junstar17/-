package 프로그래머스.스택큐;

import java.util.ArrayList;

public class 기능개발 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(new int[] {93, 90,99,99,80,99},new int[] {1,1,1,1,1,1});
	}
	public static int[] solution(int[] progresses, int[] speeds) {
       
        int[] lefts = new int[progresses.length];
        
        for(int i=0; i< progresses.length ; i++) {
        	int left = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        	lefts[i]= left;
        }
      
        ArrayList<Integer> list = new ArrayList();
        for(int i=0; i <lefts.length ; i++) {
        	 
              int works = 0;
        	for(int j=i+1; j< lefts.length ; j++) {
        		if(lefts[i] >= lefts[j]) {
            		works ++;
            	}else {
            		break;
            	}
        	}
        	i +=works;
        	list.add(works+1);
        }
        int[] answer = list.stream().mapToInt(i ->i).toArray();
        
        return answer;
    }

}
// Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
// 7 3 9
// 5 10 1 1 20 1
