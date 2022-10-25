import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node copyHead = head.next;
        while (cur != null) {
            Node next = cur.next.next;
            Node copy = cur.next;
            cur.next = next;
            if (next != null)
                copy.next = next.next;
            cur = next;
        }
        return copyHead;
    }
}
