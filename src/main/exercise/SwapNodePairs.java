/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class SwapNodePairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode nxt = head.next;
        head.next = swapPairs(nxt.next);
        nxt.next = head;
        return nxt;
    }
}
