import java.util.HashMap;

public class StringProblems {

    /*
     * problem 1:
     * Given a string s, find the length of the
     * longest substring without duplicate characters.
     * 
     * 
     */

    // solution
    // lets go with sliding window

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxlen = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }

            map.put(currentChar, right);

            maxlen = Math.max(maxlen, right - left + 1);

        }

        return maxlen;
    }

}
