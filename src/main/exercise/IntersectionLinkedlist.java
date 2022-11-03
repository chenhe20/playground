/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class IntersectionLinkedlist {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = 0, lengthB = 0;
        ListNode ptrA = new ListNode(0), ptrB = new ListNode(0);
        ptrA.next = headA;
        ptrB.next = headB;

        while (null != ptrA.next) {
            ++ lengthA;
            ptrA = ptrA.next;
        }


        while (null != ptrB.next) {
            ++ lengthB;
            ptrB = ptrB.next;
        }


        ptrA = new ListNode(0);
        ptrB = new ListNode(0);
        ptrA.next = headA;
        ptrB.next = headB;
        // Aligns
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++, ptrA = ptrA.next);
        } else if (lengthA < lengthB) {
            for (int i = 0; i < lengthB - lengthA; i++, ptrB = ptrB.next);
        }

        for (int i = 0; i < Math.min(lengthA, lengthB); i++) {
            if (ptrA.next == ptrB.next) {
                return ptrA.next;
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode d = new ListNode(4);
        ListNode a = new ListNode(1);
        a.next = d;
        ListNode c = new ListNode(3);
        c.next = d;
        ListNode b = new ListNode(2);
        b.next = c;

        new IntersectionLinkedlist().getIntersectionNode(a, b);
    }
}
