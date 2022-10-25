/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class ReverseOrder {

    static MyList nil() {
        return new MyList(new int[0]);
    }

    static int head(MyList l) {
        return l.head();
    }

    static MyList tail(MyList l) {
        return l.tail();
    }

    static MyList cons(int x, MyList l) {
        return l.cons(x);
    }

    static boolean isEmpty(MyList l) {
        return l.list.length == 0;
    }

//    static MyList reverse(MyList l) {
//        if (isEmpty(l)) return nil();
//        else return cons(last(l), reverse(cutLast(l)));
//    }

    static MyList reverse(MyList l) {
        return reverseHelper (l, nil());
    }

    static MyList reverseHelper(MyList l, MyList res) {
        if (isEmpty(l)) return res;
        else {
            res = cons(head(l), res);
            return reverseHelper(tail(l), res);
        }
    }

    // return the last element of the list
    static int last(MyList l) {
        if (isEmpty(tail(l))) return head(l);
        else return last(tail(l));
    }

    // return the original list except the last element
    static MyList cutLast(MyList l) {
        if (isEmpty(tail(l))) return nil();
        else return cons(head(l), cutLast(tail(l)));
    }

    static class MyList {

        MyList(int[] list) {
            this.list = list;
        }

        int[] list;

        int head() {
            return list[0];
        }

        MyList tail() {
            int[] res = new int[list.length-1];

            for (int i = 0; i < res.length; i++) {
                res[i] = list[i+1];
            }

            return new MyList(res);
        }

        MyList cons(int x) {
            int[] res = new int[list.length+1];

            res[0] = x;

            for (int i = 1; i < res.length; i++) {
                res[i] = list[i-1];
            }

            return new MyList(res);
        }
    }

    public static void main(String[] args) {
        MyList reverse = reverse(new MyList(new int[]{1, 2, 3, 4}));
        int[] list = reverse.list;
        for (int i:
             list) {
            System.out.println(i);
        }
    }
}
