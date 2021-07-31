package 카카오기출.카카오엔터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node implements Comparable<Node>{
	String value;
	String child_value;
	String origin_value;
	List<Node> _childNode;
	Node _parentNode;
	boolean visitied;
	boolean drawed;
	
	public Node(String value, String child_value) {
		this.value = value;
		this.child_value=child_value;
		this._childNode = new ArrayList<>();
	}
	
	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		int comp = this.value.charAt(0) - node.value.charAt(0);
		if(comp ==0) {
			comp = this.child_value.charAt(0) - node.child_value.charAt(0);
		}
		return comp;
	}
	
}
public class 사번 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(solution("(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)"));
		System.out.println(solution("(A,B) (A,C) (B,D) (D,C)"));
	}
	public static String solution(String test) {
		String[] node_array_str = test.split(" ");
		Node[] node_array = new Node[node_array_str.length];
		for(int i=0; i< node_array_str.length ; i++) {
			String node = node_array_str[i];
			node_array[i] = new Node(node.charAt(1)+"", node.charAt(3)+"");
		}
		Arrays.sort(node_array);
		
		for(int i=0 ; i<node_array.length-1 ; i++) {
			for(int j=i+1 ; j<node_array.length ; j ++) {
				if(connectChild(node_array[i], node_array[j])) {
					return "E3";
				}
			}
		}
	
		for(int i=0 ; i<node_array.length ; i++) {
			String errorType = validateError(node_array[i]);
			if(!errorType.equals("")) {
				return errorType;
			}
			
		}
		StringBuilder stringbuilder= new StringBuilder();
		stringbuilder.append("(");
		int rootCnt=0;
		for(int i=0 ; i<node_array.length; i++) {
			StringBuilder subString = new StringBuilder();
			if(!node_array[i].visitied) {
				if(rootCnt ==0) {
					subString.append(node_array[i].value);
				}
				createNode(node_array[i] ,subString);		
				rootCnt++;
			}
			stringbuilder.append(subString);
		}
		stringbuilder.append(")");
		return stringbuilder.toString();
	}
	public static void createNode(Node node,StringBuilder stringbuilder) {
		
		for(int i=0; i<node._childNode.size(); i++) {
			Node childNode = node._childNode.get(i);
			stringbuilder.append("(");
			stringbuilder.append(childNode.value);
			createNode(childNode, stringbuilder);
		}
		if(node._childNode == null || node._childNode.size()==0) {
			stringbuilder.append("(");
			stringbuilder.append(node.child_value);
		}
		stringbuilder.append(")");
	}
	public static boolean connectChild(Node node1, Node node2) {
		boolean isError =false;
		if(node1.child_value.equals(node2.value)) {
				node1._childNode.add(node2);
				node2._parentNode = node1;
				
				if(!node2.visitied) {
					node2.origin_value = node1.value;
					node2.visitied = true;
				}else {
					if(node2.origin_value != null) {
						if(node2.origin_value.equals(node1.origin_value)){
							return isError=true;
						}
					}else {
						node2.origin_value = node1.origin_value;	
					}
				}
			}
		return isError;
	}
	public static String validateError(Node node) {
		if(node._childNode.size()>2) {
			return "E1";
		}
		else if(node._childNode.size() == 2) {
			Node node1 = node._childNode.get(0)._parentNode;
			Node node2 = node._childNode.get(1)._parentNode;
			
			if(node1.value.equals(node2.value)) {
				return "E2";
			}
			else if(!node1.visitied && !node2.visitied) {
				return "E4";
			}
		}
		return "";
	}
		
}
