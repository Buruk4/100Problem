public class Flowerbed {

    /*
     * You have a long flowerbed in which some of the plots
     * are planted, and some are not. However, flowers cannot be planted in adjacent
     * plots.
     * Given an integer array flowerbed containing 0's and 1's,
     * where 0 means empty and 1 means not empty, and an integer n, return true if n
     * new flowers
     * can be planted in the flowerbed without violating the no-adjacent-flowers
     * rule and false otherwise.
     */

    // solution: using iterative method

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count = 0;
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {

                // check if right and left are empty

                boolean left = (i == 0) || (flowerbed[i - 1] == 0);
                boolean right = (flowerbed[i + 1] == 0) || (i == len - 1);

                if (left && right) {
                    flowerbed[i] = 1;
                    count++;
                }

                if (count >= n) {
                    return true;
                }
            }

        }

        return count >= n;
    }

    // solution two : using gredy method
    public boolean canPlaceFlowers(int[] flowerbed, int n, boolean op) {
        // the parameter is op is used only to overload method and is option if you need
        // to use this methed,

        if (n == 0) {
            return true;
        }
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {

                // check right and left if we can place

                boolean left = (i == 0) || (flowerbed[i - 1] == 0);
                boolean right = (i == n - 1) || (flowerbed[i + 1] == 0);

                if (left && right) {
                    flowerbed[i] = 1; // planted
                    n--; // one less flower to plant

                    if (n == 0) {
                        return true; // all planted;
                    }
                }

            }
        }

        return false;
    }

}
