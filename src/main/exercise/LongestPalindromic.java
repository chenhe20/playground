/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class LongestPalindromic {



    public String longestPalindrome(String s) {

        String res = new String("");
        boolean[][] table = new boolean[s.length()][s.length()];


        for (int i = s.length()-1; i >= 0 ; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {

                    table[i][j] = true;
                } else if (j == i+1) {

                    if (s.charAt(i) == s.charAt(j)) {
                        table[i][j] = true;
                    }
                } else {

                    if (table[i+1][j-1] == true && s.charAt(i) == s.charAt(j)) {
                        table[i][j] = true;
                    }
                }

                if (table[i][j] == true && j-i > res.length()) {
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }
}
