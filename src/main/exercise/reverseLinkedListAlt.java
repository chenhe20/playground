/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class reverseLinkedListAlt {
    ListNode successor;

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }

        if (left == 1) {
            return reverseN(head, right);
        } else {
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }

    }


   // Reverses first n elements
    ListNode reverseN (ListNode head, int n) {
        if (n == 0) {
            successor = head.next;
            return head;
        } else {
            ListNode newHead = reverseN(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return newHead;
        }
    }
}
