package sorting.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Divide and merge algorithm
// Time Complexity n*log n
// Space complexity o(n)
public class MergeSort {
    public static void main(String[] args) {
        final int[] inputArray = {5,4,3,2,1,0};
        mergeSort(inputArray, 0, inputArray.length - 1);
        System.out.println(Arrays.toString(inputArray));
    }

    private static void mergeSort(int[] inputArray, int low, int high) {
        if (low == high) return;
        int mid = (low + high) / 2;
        mergeSort(inputArray, low, mid);
        mergeSort(inputArray, mid + 1, high);
        merge(inputArray, low, mid, high);
    }

    private static void merge(int[] inputArray, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (inputArray[left] <= inputArray[right]) {
                temp.add(inputArray[left]);
                left++;
            } else {
                temp.add(inputArray[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(inputArray[left]);
            left++;
        }
        while (right <= high) {
            temp.add(inputArray[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            inputArray[i] = temp.get(i - low);
        }
    }
}
