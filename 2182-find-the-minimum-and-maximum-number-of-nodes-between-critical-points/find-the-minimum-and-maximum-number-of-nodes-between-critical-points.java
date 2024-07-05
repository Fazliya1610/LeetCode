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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) {
            return new int[]{-1, -1};
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        int index = 1;
        List<Integer> crit = new ArrayList<>();
        while(next!=null) {
            if((curr.val>prev.val&&curr.val>next.val)||(curr.val<prev.val&&curr.val<next.val)) {
                crit.add(index);
            }
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }
        if(crit.size()<2) {
            return new int[]{-1, -1};
        }
        int min = Integer.MAX_VALUE;
        int max =crit.get(crit.size()-1)-crit.get(0);
        for(int i=1;i<crit.size();i++) {
            min = Math.min(min, crit.get(i)-crit.get(i-1));
        }
        return new int[]{min, max};
    }
}