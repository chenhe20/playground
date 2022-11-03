/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start, slow = start;

        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }
}
