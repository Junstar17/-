package 프로그래머스.탐색;

public class 카펫 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(24,24);
	}
	
	 public static int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	        int x = 1;
	        int y =1;
	        
	        for(int i= yellow ; i>0 ; i--) {
	        	if(yellow % i != 0) {
	        		continue;
	        	}
	        	x= i;
	        	y = yellow / i;
	        	 int sum = (y+x + 2)*2; 
	        	 if(sum == brown) {
	        		 answer[0]=x+2;
	        		 answer[1]=y+2;
	        		 break;
	        	 }
	        }
	       
	        
	        return answer;
	    }

}
