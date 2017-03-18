/**
 * https://leetcode.com/problems/add-two-numbers/
 */

/**
 * @author rakshith
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode((p1.val+p2.val)%10);
        ListNode temp = head;
        int carry = (p1.val+p2.val)/10;
        //System.out.println(head.val);
        
        p1 = p1.next;
        p2 = p2.next;
        int a,b;
        while(p1!=null || p2!=null){
            if(p1!=null){
                a = p1.val;
            }else{
                a = 0;
            }
            if(p2!=null){
                b = p2.val;
            }else{
                b = 0;
            }
            temp.next = new ListNode((a+b+carry)%10);
            temp = temp.next;
            carry = (a+b+carry)/10;
            if(p1!=null)p1 = p1.next;
            if(p2!=null)p2 = p2.next;
        }
        if(carry!=0){
            temp.next = new ListNode(carry);
        }
        return head;
    }
}
