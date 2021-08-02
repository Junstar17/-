package GroundX기출;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




//class Node implements Comparable<Node> {
//	
//	List<Node> _childNode;
//	int number;
//	int nextNumber;
//	String text;
//	boolean root;
//	List<String> pathList;
//	
//	public Node(int number,int nextNumber) {
//		_childNode= new ArrayList();
//		pathList = new ArrayList();
//		this.number= number;
//		this.nextNumber= nextNumber;
//	}
//	
//	@Override
//	public int compareTo(Node node) {
//		// TODO Auto-generated method stub
//		int comp = this.number - node.number;
//		if(comp ==0) {
//			comp = this.nextNumber - node.nextNumber;
//		}
//		return comp;
//	}
//}
class Node {
    int data;
    Node parent;
    List<Node> _childNodes;
    
    public Node(int data) {
    	_childNodes = new ArrayList();
       parent = null;
       this.data = data;
    }
    
    
    public void makeChildNode(Node child) {
        this._childNodes.add(child);
     }
 }
public class 일번 {

	static int maxPath =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[][] relation_outer = new int[][] {{1,2},{2,5},{2,6},{1,3},{1,4},{3,7}};
		String[] dirname = new String[] {"root","abcd","cs","hello","etc","hello","solution"};
		
		solution(n,relation_outer,dirname);
	}
	
	
	public static int solution(int N, int[][] relation, String[] dirname) {
        
		HashMap<Integer, Node> madeNodes = new HashMap<>();
		
		 for(int[] edge : relation) {
	         int[] vertices = edge;
	         for(int vertex : vertices) {
	            if(!madeNodes.containsKey(vertex)) {
	               madeNodes.put(vertex, new Node(vertex));
	            }
	         }
	         
	         Node parentNode = madeNodes.get(vertices[0]);
	         Node childNode = madeNodes.get(vertices[1]);
	         
	         parentNode.makeChildNode(childNode);
	      }
		 
		 makePath(madeNodes.get(1),new StringBuilder(),dirname);
		System.out.println(maxPath);
		
		
		
		
		
//		
//		
//		int answer = 0;
//        Node[] node_array = new Node[relation.length];
//        
//        for(int i=0 ; i < relation.length ; i++) {
//        	node_array[i] = new Node(relation[i][0], relation[i][1]);
//        }
//        
//        Arrays.sort(node_array);
//        
//        
//        for(int i=0 ; i<node_array.length-1 ; i++) {
//			Node node = node_array[i];
//			if(node_array.length > node.nextNumber -1) {
//				connectChild(node, node_array[node.nextNumber]);	
//			}else {
//				StringBuilder sb = new StringBuilder();
//				sb.append(dirname[i-1]);
//				sb.append("/");
//				sb.append(dirname[node.nextNumber-1]);
//			}
//			
//		}
//        for(int i=0 ; i<node_array.length-1 ; i++) {
//			for(int j=i+1 ; j<node_array.length ; j ++) {
//				if(connectChild(node_array[i], node_array[j])) {
//					return "E3";
//				}
//			}
//		}
        return 0;
    }
	
	private static void makePath(Node node,StringBuilder path,String[] dirname) {
		path.append(dirname[node.data-1]);
		if(node._childNodes.size() >0) {
			
			for(Node childNode : node._childNodes) {
				StringBuilder _newPath = new StringBuilder(path.toString());
				_newPath.append("/");
				makePath(childNode,_newPath,dirname);
			}
		}else {
			String finalPath = path.toString();
			if(finalPath.length() > maxPath) {
				maxPath = finalPath.length();
			}
		}
		
	}
	
}
