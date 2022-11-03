/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class SwapStringOccurrence {

    public String swap(String s) {

        int[] map = new int[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < 26; i++) {
            map[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (map[idx] == -1) {
                map[idx] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (map[i] != -1) {

                int minIndex = map[i];
                int charOfMinIndex = i;

                for (int j = i+1; j < 26; j++) {
                    if (map[j] != -1 && map[j] < minIndex) {
                        minIndex = map[j];
                        charOfMinIndex = j;
                        }
                    }

                if (minIndex != map[i]) {
                    // exchange chars

                    int temp = map[i];
                    map[i] = map[charOfMinIndex];
                    map[charOfMinIndex] = temp;

                    for (int j = 0; j < chars.length; j++) {

                        char char1 = (char)('a'+i);
                        char char2 = (char)('a'+charOfMinIndex);

                        if (chars[j] == char1) {
                            chars[j] = char2;
                        } else if (chars[j] == char2) {
                            chars[j] = char1;
                        }
                    }


                }

                }
            }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new SwapStringOccurrence().swap("efeedca"));
    }
}
