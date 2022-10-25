import java.util.HashMap;
import java.util.HashSet;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class lengthOfLongestSubString {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {

            // slides until no repeating char exists
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));
            }
            maxLength = Math.max(maxLength, set.size());
        }

        return maxLength;
    }

}
