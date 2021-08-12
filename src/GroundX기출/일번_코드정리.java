package GroundX기출;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
	int number;
	List<Node> _child;
	StringBuilder path;
	
	public Node(int number, String path) {
		this.number = number;
		this.path = new StringBuilder();
		this.path.append(path);
		_child = new ArrayList<>();
	}
	
	public void makeChildNode(Node childNode) {
		_child.add(childNode);
		
		StringBuilder childPath = new StringBuilder(this.path.toString());
		childPath.append("/");
		childPath.append(childNode.path);
		childNode.path = childPath;
		
		if(childPath.length() >일번_코드정리.maxPath ) {
			일번_코드정리.maxPath = childPath.length();
		}
	}
}
public class 일번_코드정리 {

	static int maxPath = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		//int[][] relation_outer = new int[][] {{1,2},{2,5},{2,6},{1,3},{1,4},{3,7}};
		//String[] dirname = new String[] {"root","abcd","cs","hello","etc","hello","solution"};
		int[][] relation_outer = new int[][] {{1,2},{2,3},{3,4},{4,5},{1,6},{6,7}};
		String[] dirname = new String[] {"root","a","b","c","d","efghij","k"};
		
		solution(n,relation_outer,dirname);
	}
	public static int solution(int N, int[][] relation, String[] dirname) {
	
		int result =-1;
		
		//노드들을 저장하기 위한 맵 생성
		HashMap<Integer,Node> madeNodes = new HashMap<>();
		
		// relation 을 순환하며 맵에 노드들 생성
		for(int[] edge : relation) {
			int[] verticles = edge;
			for(int vertex : verticles) {
				if(!madeNodes.containsKey(vertex)) {
					madeNodes.put(vertex, new Node(vertex,dirname[vertex-1]));
				}
			}
			
			// 부모노드에 자식노드를 연결
			Node parentNode = madeNodes.get(verticles[0]);
			Node childNode = madeNodes.get(verticles[1]);
			
			parentNode.makeChildNode(childNode);
		}
		
		// 패스값들 연결시키기
		//makePath(madeNodes.get(1), new StringBuilder(), dirname);
		
		System.out.println(maxPath);
		return result;
	}

	private static void makePath(Node node, StringBuilder path , String[] dirname) {
		//자신 노드의 패스 추가
		path.append(dirname[node.number-1]);
		
		// 자식 노드가 존재할경우
		if(node._child.size() >0) {
			path.append("/");
			// 자식노드 각각의 새 패스를 생성 후 재귀 호출
			for(Node childNode : node._child) {
				StringBuilder newSb = new StringBuilder(path.toString());
				makePath(childNode , newSb,dirname);
			}
		}
		else {
			// 자식노드가 없다면 최종 패스의 길이 계산
			String finalPath = path.toString();
			if(finalPath.length() > maxPath) {
				maxPath = finalPath.length() ;
			}
		}
	}
}
