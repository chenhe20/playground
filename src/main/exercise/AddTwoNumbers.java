/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * x y z
 * m n p
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();

        recursiveAdd(l1, l2, res, 0);

        return res;
    }

    public void recursiveAdd (ListNode l1, ListNode l2, ListNode res, int inc) {

        int val1 = l1.val;
        int val2 = l2.val;

        int sum = val1 + val2 + inc;
        if (sum >= 10) {
            res.val = sum - 10;
            inc = sum/10;
        } else {
            res.val = sum;
            inc = 0;
        }

        if (null == l1.next && null == l2.next) {
            endRec(inc, res);
        }
        else if (null == l1.next && null != l2.next) {
            res.next = new ListNode();
            singleRecursiveAdd(l2.next, res.next, inc);
        }
        else if (null != l1.next && null == l2.next) {
            res.next = new ListNode();
            singleRecursiveAdd(l1.next, res.next, inc);
        } else {
            res.next = new ListNode();
            recursiveAdd(l1.next, l2.next, res.next, inc);
        }

    }

    public void singleRecursiveAdd(ListNode l, ListNode res, int inc) {
       int sum = l.val + inc;
        if (sum >= 10) {
            inc = sum/10;
            res.val = sum - 10;
        } else{
            inc = 0;
            res.val = sum;
        }

        if (null == l.next) {
            endRec(inc, res);
        }
        else {
            res.next = new ListNode();
            singleRecursiveAdd(l.next, res.next, inc);
        }
    }

    public void endRec(int inc, ListNode res) {
        if (inc > 0) {
            res.next = new ListNode(inc);
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode res = addTwoNumbers.addTwoNumbers(l1, l2);

        while (res!= null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
