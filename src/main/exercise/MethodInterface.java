/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public interface MethodInterface<T> {
    default void doSomeThings() {
        System.out.println("aa");
    }

    T doOther();

    public static void main(String[] args) {
        new MethodInterface<Integer>() {

            @Override
            public Integer doOther() {
                return null;
            }
        };
    }
}
