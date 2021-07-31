package leetCode;
import java.math.BigDecimal;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		ListNode node0 = new ListNode();
		node0.val = 9;
		
		
		ListNode node9 = new ListNode();
		node9.val = 9;
		
		ListNode node8 = new ListNode();
		node8.val = 9;
		node8.next =node9;
		ListNode node7 = new ListNode();
		node7.val = 9;
		node7.next =node8;
		ListNode node6 = new ListNode();
		node6.val = 9;
		node6.next =node7;
		ListNode node5 = new ListNode();
		node5.val = 9;
		node5.next =node6;
		
		ListNode node4 = new ListNode();
		node4.val = 9;
		node4.next =node5;
		
		ListNode node3 = new ListNode();
		node3.val = 9;
		node3.next =node4;
		
		ListNode node2 = new ListNode();
		node2.val = 9;
		node2.next =node3;
		
		ListNode node1 = new ListNode();
		node1.val = 1;
		node1.next =node2;
		
		
		
		ListNode node =  addTwoNumbers(node0,node1);
	}
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode node  =new ListNode();
		 if(l1 != null || l2 != null) {
			 node = createNode(l1,l2,0);
		 }else {
			 node = new ListNode(0);
		 }
		 return node;
	 }
	 public static ListNode createNode(ListNode l1, ListNode l2, int carry) {
		 if(l1 == null && l2 ==null) {
			 if(carry ==1) {
				 return new ListNode(1);
			 }else {
				 return null;		 
			 }
		 }
		 ListNode node  =new ListNode();
		int digit =0;
		int v1 =0;
		int v2=0;
		 if(l1 != null) {
			 v1 = l1.val;
		 }
		 
		 if(l2 != null) {
				v2 = l2.val;
		 }
		 digit = v1+v2 + carry;
		 int carry_temp = digit/10;
		 node.val = digit%10;
		 node.next=createNode(l1 !=null && l1.next != null? l1.next : null, l2 !=null && l2.next != null ? l2.next : null , carry_temp);
		 return node;
	 }
	 
	 /*
	 public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
	    
		 int 자리수 = 0;
		 long firstNum=0L;
		 long seondNum =0L;
		 while(l1 != null) {
			 firstNum += l1.val * Math.pow(10, 자리수); 
			 자리수 ++;
			 l1 = l1.next;
		 }
		 자리수 =0;
		 while(l2 != null) {
			 seondNum += l2.val * Math.pow(10, 자리수); 
			 자리수 ++;
			 l2 = l2.next;
		 }
		 long result = (long)(firstNum +seondNum) ;
		 ListNode resultNode ;
		 if(result ==0 ) {
			 resultNode = new ListNode(0);
		 }else {
			 resultNode = createNode2(result);
		 }
		 
		 return resultNode;
    }
	 
	 public static ListNode createNode2(long result) {
		 ListNode node  =new ListNode();
		 if(result/10 >0 || result %10 !=0 ) {
			 long digit = result % 10 ;
			 result = result/10;
			 node.val = (int)digit;
			 node.next=createNode2(result);
		 }else {
			 node =null;
		 }
		 return node;
	 }
	 */

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}