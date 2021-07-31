package 프로그래머스.탐색;
import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] q = new int[] {1,3,2,4,2};
		int [] answer =solution(q);
		for(int i : answer) {
			System.out.print(i);
		}
	}
	 public static int[] solution(int[] answers) {
	        
	        int[] a = new int[answers.length];
	        int[] b = new int[answers.length];
	        int[] c = new int[answers.length];
	        for(int i=0 ; i<a.length ; i++) {
	        	a[i] = i%5 +1;
	        }
	        int[] sample = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
	        for(int i=0; i<b.length ; i++) {
	        	b[i] = sample[i%8];
	        }
	        int[] sample2 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	        for(int i=0; i<c.length ; i++) {
	        	c[i] = sample2[i%10];
	        }
	        int a_score=0;
	        int b_score=0;
	        int c_score=0;
	        for(int i=0; i<answers.length ; i++) {
	        	int select = answers[i];
	        	if(select == a[i] ) {
	        		a_score++;
	        	}
	        	if(select == b[i] ) {
	        		b_score++;
	        	}
	        	if(select == c[i] ) {
	        		c_score++;
	        	}
	        }
	        int max =0;
	        int [] answerarray = new int[] {a_score,b_score,c_score};
	        for(int i=0; i<answerarray.length ; i++) {
	        	if(max < answerarray[i]) {
	        		max = answerarray[i];
	        	}
	        }
	        int[] tt = new int[3];
	        int cnt =0;
	        for(int i=0; i<answerarray.length ; i++) {
	        	if(max  ==  answerarray[i]) {
	        		tt[cnt++] = i;
	        	}
	        }
	        int[] answer =new int[cnt];
	        for(int i=0 ; i<cnt ;i++) {
	        	answer[i] = tt[i]+1;
	        }
	        ArrayList<Integer> list = new ArrayList();
	        int[] test = list.stream().mapToInt(i -> i.intValue()).toArray();
	        return answer;
	    }

}
