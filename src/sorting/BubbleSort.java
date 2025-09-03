package sorting;

import java.util.Arrays;

// Adjacent swaps, push max at the end
// Time Complexity - Best case o(n) worst case o(n^2)
// take u forward
public class BubbleSort {
    public static void main(String[] args) {
        final int[] inputArray = {13, 46, 24, 52, 20, 9};
        bubbleSort(inputArray);
        System.out.println(Arrays.toString(inputArray));
    }

    private static void bubbleSort(int[] inputArray) {
        int n = inputArray.length;
        for (int i = n - 1; i >= 1; i--) {
            boolean isSwap = false;
            for (int j = 0; j <= i - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    swap(j, j + 1, inputArray);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    private static void swap(int j, int i, int[] inputArray) {
        int temp = inputArray[j];
        inputArray[j] = inputArray[i];
        inputArray[i] = temp;
    }
}
