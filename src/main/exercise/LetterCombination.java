import java.util.*;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class LetterCombination {

        LinkedList<String> res = new LinkedList<>();
        static Map letters = new HashMap<String, List<String>>();

        static {
            letters.put("2", Arrays.asList("a", "b", "c"));
            letters.put("3", Arrays.asList("d", "e", "f"));
            letters.put("4", Arrays.asList("g", "h", "i"));
            letters.put("5", Arrays.asList("j", "k", "l"));
            letters.put("6", Arrays.asList("m", "n", "o"));
            letters.put("7", Arrays.asList("p", "q", "r", "s"));
            letters.put("8", Arrays.asList("t", "u", "v"));
            letters.put("9", Arrays.asList("w", "x", "y", "z"));

        }

        public List<String> letterCombinations(String digits) {

            if (digits.length() == 0) {
                return res;
            }

            combine("", digits, res);

            return res;
        }

        public void combine(String temp, String remain, List res) {
            if (remain.length() == 0) {
                res.add(temp);
            } else {
                List<String> list = (List) letters.get(remain.substring(0, 1));
                for (String s:
                     list) {
                    combine(temp + s, remain.substring(1), res);
                }
            }
        }

    public static void main(String[] args) {
        List<String> strings = new LetterCombination().letterCombinations("");
        strings.forEach(System.out::println);
    }
}
