package GroundX기출;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

class Node_person{
	int number;
	Node_person _nextPerson;
	int order;
	
	public Node_person(int number,int order) {
		this.number= number;
		this.order=order;
	}
	public void makeChildNode(Node_person child) {
		_nextPerson = child;
	}
}
public class 이번_코드정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 2000000000;
		int[] mark = new int[] {1,7,6,5,1,4,3,2};
		long beforeTime = System.currentTimeMillis(); 
		System.out.println(solution(num,mark));
		long afterTime = System.currentTimeMillis(); 
		long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
	}
	public static int solution(int num, int[] mark) {
		int result = -1;
		
		// 우선, 중복된 숫자가 있거나 0이 존재하는지 확인 => 사이클 존재
		Set<Integer> set = Arrays.stream(mark).boxed().collect(Collectors.toSet());
		// 중복이 없거나, 0이 없는경우 => 반복으로 찾아야함
		if(set.size() == mark.length && !set.contains(0)) {
			int next = 0;
			for(int i=0; i<num ;i++) {
				next = mark[next];
			}
			result = next;
			System.out.println("노사이클");
			return result;
		}
		System.out.println("사이클");
		result = findCycle(num,mark);
		return result;
	}
	
	 public static int findCycle(int num, int[] mark) {
		 
		 HashMap<Integer, Node_person> makeNodes = new HashMap(); // 노드 테이블 생성
		 HashMap<Integer, Node_person> orderNodes = new HashMap(); // 노드 테이블 생성
		 boolean[] visited = new boolean[mark.length]; // 사이클여부검사
		 int cnt = 0;		 // 지목횟수
		 int i = 0;		 // 현재 차례
		 Node_person cycleNode;
		 Node_person cycleBeforeNode;
		 // 0번의 첫 지목을 삽입 후 시작
		 Node_person initNode = new Node_person(i,cnt);
		 makeNodes.put(i, initNode);
		 orderNodes.put(cnt, initNode);
		 cnt++;
		 visited[i] =true;
		 // 조건이 만족될때까지(타겟을만나거나 사이클을찾거나) 반복 & 노드들 연결
		 while(true) {
			 int nextNodeNum = mark[i];
			 // 만약 타겟넘버 횟수에 도달했다면 지목된사람 리턴
			 if(cnt == num) {
				 return nextNodeNum;
			 }
			 
			 //노드를 추가해주고 순서값과 저장
			 if(!makeNodes.containsKey(nextNodeNum)) {
				 makeNodes.put(nextNodeNum, new Node_person(nextNodeNum, cnt)); 
			 }
			 
			 //노드를 추가해주고 순서값과 저장
			 if(!orderNodes.containsKey(cnt)) {
				 orderNodes.put(cnt, new Node_person(nextNodeNum, cnt)); 
			 }
			 
			 // 노드 연결
			 Node_person parentNode = makeNodes.get(i);
			 Node_person childNode = makeNodes.get(nextNodeNum);
			 parentNode.makeChildNode(childNode);
			 
			 // 방문했는지 체크 -> 사이클 노드찾기
			 if(!visited[nextNodeNum]) {
				 visited[nextNodeNum] = true;
			 }else {
				 cycleNode = childNode;
				 cycleBeforeNode = parentNode;
				 break;
			 }
			 i = nextNodeNum;
			 cnt++;
		 }
		 
		 int result = -1;
		 // 사이클 존재시
		 if(cycleNode != null) {
			 
			 int startIdx = cycleNode.order;  // 사이클발생지점의 순서
			 int cycleLen = cycleBeforeNode.order - startIdx +1; // 사이클길이계산
			 int target_number = (num - startIdx) % cycleLen; // 사이클내에서 타겟인덱스구하기
			 
			 result = orderNodes.get(startIdx+target_number).number;
//			 Node_person targetNode =cycleNode ;
//			 for(int j=0; j<target_number ; j++) {
//				 targetNode = targetNode._nextPerson;
//			 }
//			 result = targetNode.number;
		 }
		 return result;
	 }
}
