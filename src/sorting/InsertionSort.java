package sorting;

import java.util.Arrays;

// Take an element and place it in its correct order
// Time complexity best o(n) worst o(n^2)
public class InsertionSort {
    public static void main(String[] args) {
        final int[] inputArray = {13, 46, 24, 52, 20, 9};
        insertionSort(inputArray);
        System.out.println(Arrays.toString(inputArray));
    }

    private static void insertionSort(int[] inputArray) {
        int n = inputArray.length;
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            while (j > 0 && inputArray[j] < inputArray[j - 1]) {
                swap(j, j - 1, inputArray);
                j--;
            }
        }
    }

    private static void swap(int j, int i, int[] inputArray) {
        int temp = inputArray[j];
        inputArray[j] = inputArray[i];
        inputArray[i] = temp;
    }
}
