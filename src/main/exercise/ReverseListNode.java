/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class ReverseListNode {
    public ListNode reverseList(ListNode head) {

        if (head == null) return null;

        ListNode next = head.next;
        ListNode cur = head;
        cur.next = null;

        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }

        return cur;

    }

}
