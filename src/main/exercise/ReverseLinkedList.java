/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if (head == null) return null;

        ListNode cur = head;
        ListNode nxt = head.next;
        head.next = null;

        while (nxt != null) {
            ListNode nnxt = nxt.next;
            nxt.next = cur;
            cur = nxt;
            nxt = nnxt;
        }

        return cur;
    }

    public ListNode reverseRecursive(ListNode head) {
        if (head == null) return null;
        ListNode newHead = reverseRHelper(head);
        head.next = null;
        return newHead;
    }

    public ListNode reverseRHelper(ListNode n) {
        if (n.next == null) {
            return n;
        } else {
            ListNode next = n.next;
            ListNode newHead = reverseRHelper(n.next);
            next.next = n;
            return newHead;

        }
    }
}
