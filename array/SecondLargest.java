package array;

import java.util.Arrays;

public class SecondLargest {

    public int getSecondLargest(int[] arr) {
        // code here
        int result = 0;
        Arrays.sort(arr);
        for (int i = arr.length - 1; i > 0; i--) {

            if (arr[i] > arr[i - 1]) {
                result = arr[i - 1];
                return result;
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = { 12, 35, 1, 10, 34, 1 };
        SecondLargest sl = new SecondLargest();
        int sln = sl.getSecondLargest(arr);
        System.out.println(sln);
    }
}
