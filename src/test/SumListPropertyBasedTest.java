import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.Before;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class SumListPropertyBasedTest {



@Property
    public boolean sumGreaterThanZero(@ForAll int[] list) {

    SumList sumList = new SumList();
    return sumList.sum(list) > 0;
}

}
