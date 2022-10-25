import java.util.List;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        if (head.next == null)
            return;

        ListNode start = head;
        ListNode backNode = head.next;
        rightward(head, head.next);
    }

    public void rightward(ListNode start, ListNode backNode) {
        if (backNode.next == null) {
            return;
        }

        ListNode cur = backNode;
        ListNode curFormer = start;
        while (cur.next != null) {
            curFormer = cur;
            cur = cur.next;
        }
        curFormer.next = null;
        start.next = cur;
        cur.next = backNode;
        if (backNode.next != null) {
            rightward(backNode, backNode.next);
        } else {
            return;
        }

    }
}
