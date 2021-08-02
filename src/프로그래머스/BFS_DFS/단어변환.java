package 프로그래머스.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

class Data {
	 String word;
	 int oldWordIdx;
	 int newWordIdx;
	 int cnt;
	 
	 public Data(String word,int oldWordIdx,int newWordIdx, int cnt) {
		 this.word = word;
		 this.oldWordIdx= oldWordIdx;
		 this.newWordIdx= newWordIdx;
		 this.cnt = cnt;
	 }
}

public class 단어변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
//		String[] words= new String[] {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words= new String[] {"hot", "dot", "dog", "lot", "log"};
		solution(begin,target,words);
	}

	 public static int solution(String begin, String target, String[] words) {
		 
		 int answer = BFS(begin,target,words);
		 System.out.println(answer);
        return answer;
    }
	 
	
	 public static int BFS(String begin, String target, String[] words) {
	 
		 int cnt = 0;
		 Queue<Data> queue = new LinkedList();
		 queue.add(new Data(begin,-1,-1, 0));
		 
		 while(!queue.isEmpty() ) {
			 Data data = queue.poll();
			 String currentWord = data.word;
			 
			 if(currentWord.equals(target)) {
				 return data.cnt;
			 }
			 else {
				 for(int j = 0; j<words.length ; j ++) {
					 String word = words[j];
					 if(data.oldWordIdx == j || data.newWordIdx == j) {
						 continue;
					 }
					 for(int i=0; i< currentWord.length() ; i++) {
						 boolean match = true;
						 for(int k=0; k< currentWord.length() ; k++) {
							 if(i == k) {
								 continue;
							 }
							 if (currentWord.charAt(k) != word.charAt(k)) {
								 match = false;
								 break;
							 }
						 }
						 
						 if(match) {
							 queue.add(new Data(word, data.newWordIdx, j, data.cnt+1));
						 }
						
					 }
				 }
			 }
		 }
		 
		 return 0;
	 }
}
