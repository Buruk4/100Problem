class IntegerPalindrome {









    /*
         give integer x return true if it is palindrome

         e.g -->  121 
             output : true

            -->   -121 
               output : false     (121-)
    
    
    */
    public boolean isPalindrome(int x) {

        int result = 0;
        int or = x;

        if (x < 0) {
            return false;
        }
        while (x != 0) {
            int rem = x % 10;

            result = result * 10 + rem;

            x = x / 10;
        }

        if (result == or) {
            return true;
        }
        return false;

    }
}
