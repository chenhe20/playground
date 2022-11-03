/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) return null;
        if (k == 1) return head;

        // count how many reverses to be made
        int eleCount = 1;
        ListNode ptr = head;
        while (ptr.next != null) {
            ++eleCount;
            ptr = ptr.next;
        }
        int count = eleCount / k;

        // reverse k nodes recursively
        return reverse(head, k, count);
    }

    ListNode reverse(ListNode head, int k, int count) {

        if (head == null) return null;

        if (count < 1) return head;

        int length = k;
        ListNode cur = head, nxt = head.next;
        for (int i = 0; i < length-1; i++) {
            ListNode nnxt = nxt.next;
            nxt.next = cur;
            cur = nxt;
            nxt = nnxt;
        }



        head.next = reverse(nxt, k, count-1);
        return cur;
    }
}
