package String;

public class ReverseString {

    String vowels = "aeiouAEIOU";

    // two pointers approach
    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // move left pointer until we find a vowel

            while (left < right && !isVowels(chars[left])) {
                left++;
            }

            // move right pointer unitl we find a vowel
            while (left < right && !isVowels(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }

            left++;
            right--;

        }
        return new String(chars);
    }

    boolean isVowels(char a) {
        return vowels.indexOf(a) != -1 ? true : false;
    }

}
