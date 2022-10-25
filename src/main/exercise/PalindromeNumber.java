/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int rev  = 0;
        while (x > rev) {
            rev = rev*10 + x%10;
            x /= 10;
        }

        return (x == rev || x == rev/10);

    }

    public static void main(String[] args) {
        new PalindromeNumber().isPalindrome(10);
    }

}
