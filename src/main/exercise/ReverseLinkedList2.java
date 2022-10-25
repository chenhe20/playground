/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedList2 {


    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) return head;

        int ptr = 1;
        ListNode cur = head;

        if (left == 1) {
        return reverse(cur, ptr, right, cur);
        }


        while (ptr + 1 < left) {
            cur = cur.next;
            ptr ++;
        }


        ListNode subEnd = cur.next;
        ListNode subHead  = reverse(cur.next, ptr+1, right, subEnd);

        cur.next = subHead;
        return head;
    }

    ListNode reverse(ListNode cur, int ptr, int right, ListNode subEnd) {
        ListNode temp = subEnd.next;
        if (ptr == right) {

            return cur;
        } else {
            ListNode node = reverse(cur.next, ptr + 1, right, subEnd);

            if (cur == subEnd) {
                temp.next = subEnd;
            } else {
                cur.next.next = cur;
                cur.next = null;

            }


            return node;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);

        new ReverseLinkedList2().reverseBetween(n1, 2,4);

    }
}
