package 카카오기출.카카오엔터;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 사번2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sExpression("(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)"));
		//System.out.println(sExpression("(A,B) (A,C) (B,D) (D,C)"));
	}
	   static class Node {
		      String data;
		      Node parent;
		      Node left;
		      Node right;
		      
		      public Node(String data) {
		         left = null;
		         right = null;
		         parent = null;
		         this.data = data;
		      }
		      
		      public boolean canMakeSubTree(Node sub) {
		         boolean canMake = true;
		         
		         if(this.left == null) {
		            this.left = sub;
		         } else if(this.right == null) {
		            this.right = sub;
		         } else {
		            canMake = false;
		         }
		         
		         return canMake;
		      }
		      
		      public void makeParentNode(Node parent) {
		         this.parent = parent;
		      }
		   }
		   
		   static HashMap<String, Boolean> visited;
		   
		   public static String sExpression(String nodes) {
		      String answer = "E5";
		      nodes = nodes.replace("(", "").replace(")", "");
		      HashMap<String, Node> madeNodes = new HashMap<>();
		      String[] edges = nodes.split(" ");
		      List<String> errors = new ArrayList<>();
		      visited = new HashMap<>();
		      
		      for(String edge : edges) {
		         String[] vertices = edge.split(",");
		         for(String vertex : vertices) {
		            if(!madeNodes.containsKey(vertex)) {
		               visited.put(vertex, false);
		               madeNodes.put(vertex, new Node(vertex));
		            }
		         }
		         
		         Node parentNode = madeNodes.get(vertices[0]);
		         Node childNode = madeNodes.get(vertices[1]);
		         
		         if(parentNode.left == childNode || parentNode.right == childNode) {
		            errors.add("E2");
		         }
		         
		         if(parentNode.canMakeSubTree(childNode)) {
		            childNode.makeParentNode(parentNode);
		         } else {
		            errors.add("E1");
		         }
		      }
		      
		      Node rootNode = null;
		      int rootCnt = 0;
		      for(String key : madeNodes.keySet()) {
		         Node node = madeNodes.get(key);
		         
		         if(node.parent == null) {
		            rootNode = node;
		            rootCnt++;
		         }
		      }
		      
		      boolean hasCycle = false;
		      /*
		      if(isCycle(rootNode, new Node("root"))) {
		         hasCycle = true;
		      }*/
		      
		      if(isCycle2(rootNode)) {
			         hasCycle = true;
		      }
		      
		      if(hasCycle) {
		         errors.add("E3");
		      }
		      if(rootCnt > 1) {
		         errors.add("E4");
		      }
		      
		      if(errors.size() > 0) {
		         Collections.sort(errors);
		         answer = errors.get(0);
		      } else {
		         answer = getSExpression(new StringBuilder(), rootNode);
		      }
		      
		      return answer;
		   }

		   private static String getSExpression(StringBuilder expression, Node node) {
		      
		      expression.append('(').append(node.data);
		      if(node.left != null) {
		         getSExpression(expression, node.left);
		      }
		      if(node.right != null) {
		         getSExpression(expression, node.right);
		      }

		      expression.append(')');
		      return expression.toString();
		   }

		   private static boolean isCycle(Node node, Node parent) {
		      visited.put(node.data, true);
		      if(node.left == parent || node.right == parent) {
		         return true;
		      }
		      if(node.left != null) {
		         if(!visited.get(node.left.data) && isCycle(node.left, node)) {
		            return true;
		         }
		      }
		      if(node.right != null) {
		         if(!visited.get(node.right.data) && isCycle(node.right, node)) {
		            return true;
		         }
		      }
		      return false;
		   }
		   private static boolean isCycle2(Node node) {
			      visited.put(node.data, true);
			      if(node.left != null) {
			         if(!visited.get(node.left.data) ) {
			            isCycle2(node.left);
			         }else {
			        	 return true;
			         }
			      }
			      if(node.right != null) {
			    	  if(!visited.get(node.right.data) ) {
				           isCycle2(node.right);
				         }else {
				        	 return true;
				         }
			      }
			      return false;
			   }

}
