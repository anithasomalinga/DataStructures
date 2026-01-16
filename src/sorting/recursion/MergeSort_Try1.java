package sorting.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort_Try1 {
    public static void main(String[] args) {
        int[] arr = new int[] {10, 4, 1, 7, 6};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int startIdx, int endIdx) {
        if (startIdx == endIdx) return;
        int midIdx = (startIdx + endIdx) / 2;
        mergeSort(arr, startIdx, midIdx);
        mergeSort(arr, midIdx + 1, endIdx);
        merge(arr, startIdx, midIdx, endIdx);
    }

    private static void merge(int[] arr, int startIdx, int midIdx, int endIdx) {
        int left = startIdx;
        int right = midIdx + 1;
        List<Integer> temp = new ArrayList<>();
        while (left <= midIdx && right <= endIdx) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= midIdx) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= endIdx) {
            temp.add(arr[right]);
            right++;
        }
        for(int i = startIdx; i <= endIdx; i++) {
            arr[i] = temp.get(i - startIdx);
        }
    }
}
