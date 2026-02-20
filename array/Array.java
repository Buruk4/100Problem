package array;

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

    public void rotateToLeft(int[] arr, int d) {
        int n = arr.length;
        d %= n;

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);

    }

    // helper function to rotate array
    void reverse(int arr[], int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

}
