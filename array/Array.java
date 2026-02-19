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

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 0 };
        System.out.println("before");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        Array a = new Array();
        a.atBeginning(arr, 50);
        System.out.println("after");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
