package String;

public class GCDofString {
    /*
     * For two strings s and t, we say "t divides s" if and only if s = t + t + t +
     * ... + t + t
     * (i.e., t is concatenated with itself one or more times).
     * Given two strings str1 and str2, return the largest string
     * x such that x divides both str1 and str2.
     * 
     * 
     * 
     * Example 1:
     * Input: str1 = "ABCABC", str2 = "ABC"
     * Output: "ABC"
     * Example 2:
     * Input: str1 = "ABABAB", str2 = "ABAB"
     * Output: "AB"
     * Example 3:
     * Input: str1 = "LEET", str2 = "CODE"
     * Output: ""
     * Example 4:
     * Input: str1 = "AAAAAB", str2 = "AAA"
     * Output: ""
     */

    public String gcdOfStrings(String str1, String str2) {

        int len1 = str1.length();
        int len2 = str2.length();

        for (int i = Math.min(len1, len2); i >= 1; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String candidate = str1.substring(0, i);

                if (divides(str1, candidate) && divides(str2, candidate)) {
                    return candidate;
                }
            }

        }
        return "";
    }

    private boolean divides(String str, String pattern)

    {
        int len = str.length();
        int patternLen = pattern.length();

        if (len % patternLen != 0) {
            return false;
        }
        for (int i = 0; i < len; i += patternLen) {
            if (!str.substring(i, i + patternLen).equals(pattern)) {
                return false;
            }
        }
        return true;
    }

}