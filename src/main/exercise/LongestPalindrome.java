/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * Given a string s, return the longest palindromic substring in s.
 * input: babad
 * output bab
 *
 */
public class LongestPalindrome {

    int start;
    int maxlen = 0;

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 1) {
            return s;
        }

        for (int i = 1; i < s.length() - 1; i++) {
            expand(i, 1);
        }

        return s.substring(start, start + maxlen);

    }

    public void expand(int centreIdx, int itr) {
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

