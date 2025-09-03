package leetcode;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6};
        int subArraySize = 3;
        int max = getSubArrayWithMaxSum(data, subArraySize);
        System.out.println(max);
    }

    private static int getSubArrayWithMaxSum(int[] data, int subArraySize) {
        int windowSum = 0;
        for(int i = 0; i< subArraySize;i++){
            windowSum += data[i];
        }
        int maxSum = windowSum;
        for(int k = subArraySize; k < data.length; k++){
            windowSum = windowSum - data[k-subArraySize] + data[k];
            maxSum = Math.min(maxSum, windowSum);
        }
        return maxSum;
    }

}
