package GroundX기출;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Node3 {
    int data;
    Node3 parent;
    List<Node3> _childNodes;
    
    public Node3(int data) {
    	_childNodes = new ArrayList();
       parent = null;
       this.data = data;
    }
    
    public void makeChildNode(Node3 child) {
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
        
		HashMap<Integer, Node3> madeNodes = new HashMap<>();
		
		 for(int[] edge : relation) {
	         int[] vertices = edge;
	         for(int vertex : vertices) {
	            if(!madeNodes.containsKey(vertex)) {
	               madeNodes.put(vertex, new Node3(vertex));
	            }
	         }
	         Node3 parentNode = madeNodes.get(vertices[0]);
	         Node3 childNode = madeNodes.get(vertices[1]);
	         
	         parentNode.makeChildNode(childNode);
	      }
		 
		 makePath(madeNodes.get(1),new StringBuilder(),dirname);
		System.out.println(maxPath);
		
        return 0;
    }
	
	private static void makePath(Node3 node,StringBuilder path,String[] dirname) {
		path.append(dirname[node.data-1]);
		if(node._childNodes.size() >0) {
			
			for(Node3 childNode : node._childNodes) {
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
