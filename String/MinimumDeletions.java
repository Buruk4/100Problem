package String;

/*
Minimum Deletions to Make String Balanced Medium

You are given a string s consisting only of characters 'a' and 'b'​​​​.

You can delete any number of characters in s to make s balanced. 
s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.

*/

class MinimumDeletions {
    public int minimumDeletions(String s) {
        int count = 0;
        int countB = 0;

        for (char c : s.toCharArray()) {

            if (c == 'b') {
                countB++; // Safe to keep
            } else {
                count = Math.min(count + 1, countB); // delete min
            }
        }
        return count;
    }
}