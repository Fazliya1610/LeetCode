/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l=new ListNode(-1);
        ListNode c=l;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                c.next=list1;
                list1=list1.next;
            }
            else{
                c.next=list2;
                list2=list2.next;
            }
            c=c.next;
        }
        if(list1!=null){
            c.next=list1;
        }
        else{
            c.next=list2;
        }
        return l.next;
    }
}