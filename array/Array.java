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

    public int[] pushZerosToEnd(int[] arr) {

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
        return arr;
    }

    // second approach to move zeros element to the end

    public int[] pushZerosToEnds(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

                count++;
            }

        }
        return arr;
    }

}
