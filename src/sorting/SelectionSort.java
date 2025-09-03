package sorting;

import java.util.Arrays;

// Select min in array and swap
// Time Complexity O(n^2)
// take u forward
public class SelectionSort {
    public static void main(String[] args) {
        final int[] inputArray = {13, 46, 24, 52, 20, 9};
        selectionSort(inputArray);
        System.out.println(Arrays.toString(inputArray));
    }

    private static void selectionSort(int[] inputArray) {
        int n = inputArray.length;
        for (int i = 0; i <= n - 2; i++) {
//            assume current min idx is i
            for (int j = i; j <= n - 1; j++) {
                if (inputArray[j] < inputArray[i]) {
                    swap(j, i, inputArray);
                }
            }
        }
    }

    private static void swap(int i, int min, int[] inputArray) {
        int temp = inputArray[min];
        inputArray[min] = inputArray[i];
        inputArray[i] = temp;
    }
}
