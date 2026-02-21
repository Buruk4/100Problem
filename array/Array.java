package array;

import java.util.Arrays;

public class Array {

    // this class will demostarate array operations

    // insert a given element at the beginning of an array
    public void atBeginning(int[] arr, int key) {

        // shift element to right while then the last element have to be ignored,
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = key;
    }

    // move zeros to end

    public void pushZerosToEnd(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        while (count < arr.length) {
            arr[count] = 0;
            count++;
        }

    }

    // second approach to move zeros element to the end

    public void pushZerosToEnds(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

                count++;
            }

        }

    }

    // reverse array elements
    void reverseArray(int[] arr) {

        // let use two pointers

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // swap
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // increase left pointer

            left++;

            // decrease right pointer
            right--;

        }
    }

    // rotate array to the left by distance d;

    public int[] rotateToLeft(int[] arr, int d) {
        int n = arr.length;
        d %= n;

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);

        return arr;
    }

    // helper function to rotate array
    void reverse(int arr[], int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

    // rotate arrat counter clockwise : second option

    static int[] rotateArr(int[] arr, int d) {

        int n = arr.length;
        d %= n;
        int cycles = gfd(d, n);

        for (int i = 0; i < cycles; i++) {
            int start = arr[i];
            int currentIdx = i;

            while (true) {
                int nextIdx = (currentIdx + d) % n;

                if (nextIdx == i)
                    break;

                arr[currentIdx] = arr[nextIdx];
                currentIdx = nextIdx;
            }

            arr[currentIdx] = start;
        }
        return arr;
    }

    // helper function
    public static int gfd(int a, int b) {
        if (b == 0)
            return a;
        return gfd(b, a % b);
    }

    // return second largest element from array: if there is not second largest
    // element return -1
    public int getSecondLargest(int[] arr) {

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

    // next permutation

    /*
     * Given an array of integers arr[] representing a permutation, implement
     * the next permutation that rearranges the numbers into the lexicographically
     * next greater permutation. If no such permutation exists, rearrange the
     * numbers
     * into the lowest possible order (i.e., sorted in ascending order).
     * 
     * Note: A permutation of an array of integers refers
     * to a specific arrangement of its elements in a sequence or linear order.
     * 
     * Examples:
     * 
     * Input: arr[] = [2, 4, 1, 7, 5, 0]
     * Output: [2, 4, 5, 0, 1, 7]
     * Explanation: The next permutation of the given array is [2, 4, 5, 0, 1, 7].
     */

    public int[] nextPermutation(int[] arr) {

        int n = arr.length;
        int i = n - 2;

        // find breaker point

        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;

        if (i >= 0) {

            int j = n - 1;

            // find the next greater num to breaker point
            while (j >= 0 && arr[j] < arr[i]) {
                j--;
            }

            // swap a breaker point and the next greater

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

        // reverse
        reverse(arr, i + 1, n - 1);

        return arr;
    }

    public static void main(String[] args) {

        Array a = new Array();
        int[] arr = { 2, 4, 1, 7, 5, 0 };
        int[] res = a.nextPermutation(arr);

        for (int i : res) {
            System.out.print(i + " ");
        }

    }
}
