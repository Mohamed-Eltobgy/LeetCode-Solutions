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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        left = head;
        while (n != 0) {
            head = head.next;
            n--;
        }
        right = head;

        ListNode dummy = new ListNode();
        dummy.next = left;
        head = dummy; // point to a dummy node connected to original list
        while (right != null) {
            right = right.next;
            dummy = left;
            left = left.next;
        }
        dummy.next = left.next;

        return head.next;
    }
}
