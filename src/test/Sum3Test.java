import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class Sum3Test {

    int testArray[] = {-1,-2, 1, 0, 2, 3};

    @Before
    public void init() {

    }

    @Test
    public void sum3Test() {

        FirstMissingPositiveNumber firstMissingPositiveNumber = new FirstMissingPositiveNumber();
        System.out.println(firstMissingPositiveNumber.firstMissingPositive(testArray));

    }

    @Test
    public void sftTest() {
        SFT sft = new SFT();
        System.out.println(sft.sft(1,2));

    }
}
