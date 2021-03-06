package LeetcodePrograms;

import java.util.*;
public class
LetterCombinationPhoneNumber {
    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        String[] charmap = { "0", "1", "abc", "def", "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz" };
        res.add("");
        System.out.println(res.size());
        for (int i = 0; i < digits.length(); i++) {
            ArrayList<String> tempres = new ArrayList<>();
            String chars = charmap[digits.charAt(i) - '0'];
            for (int c = 0; c < chars.length(); c++)
                for (int j = 0; j < res.size(); j++)
                    tempres.add(res.get(j) + chars.charAt(c));
            res = tempres;
        }
        return res;
    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public static List<String> letterCombinations2(String digits) {
        if(digits.equals(""))
            return new ArrayList<String>();
        List<String> ret = new LinkedList<String>();
        combination2("", digits, 0, ret);
        return ret;
    }

    private static void combination2(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination2(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }

	public static void main(String[] args) {
        System.out.println(letterCombinations2("23"));

	}

}
