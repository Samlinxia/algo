/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3,head;
        if(l1==null && l2 ==null){
            return null;
        }else if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        int value = l1.val+l2.val;
        head = l3 = new ListNode(value%10);
        int carry = value >= 10 ? 1: 0;
        l1 = l1.next;
        l2 = l2.next;
        while(l1!=null && l2!=null){
            value = l1.val + l2.val + carry;
            ListNode newNode = new ListNode(value%10);
            l3 = l3.next = newNode; 
            carry = value >= 10? 1: 0;
            l1 = l1.next;
            l2 = l2.next; 
        }
        while(l1!=null){
            value = l1.val + carry;
            l3 = l3.next = new ListNode(value%10);
            carry = value >= 10 ? 1: 0;
            l1 = l1.next;
        }
        while(l2!=null){
            value = l2.val + carry;
            l3 = l3.next = new ListNode(value%10);
            carry = value >= 10 ? 1: 0;
            l2 = l2.next;
        }
        if(carry == 1){
            l3 = l3.next = new ListNode(carry);
        }
        
        return head;
        
    }
}
