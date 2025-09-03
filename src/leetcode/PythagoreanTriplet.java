package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// a^2 + b^2 = c^2
public class PythagoreanTriplet {

    public static void main(String[] args) {
        int[] array = new int[] {3,1,4,6,5};
        boolean result = containPythagoreanTriplet(array);
        System.out.printf("Contains Pythagoran triplet ? %s", result);
    }

    private static boolean containPythagoreanTriplet(int[] array) {
//        return bruteForceWay(array);
        return twoPointerWay(array);
//        return hashSetWay(array);
    }

    private static boolean twoPointerWay(int[] array) {
        int arrSize = array.length;
        for(int i=0; i<arrSize;i++){
            array[i] = array[i]*array[i];
        }
        Arrays.sort(array);
        // say c = largest of the array. here in sorted array it is array[arrSize-1]
        // two pointer technique to find the reminder 2 elements such that
        // a^2 + b^2 = c^2
        for(int k = arrSize-1; k > 1; k--) {
            int i = 0;
            int j = k - 1;
            int cSquare = array[k];
            while (i<j){
                int sum = array[i]+array[j];
                if(sum==cSquare) {
                    System.out.printf("%s %s %s\n", (int)Math.sqrt(array[i]), (int)Math.sqrt(array[j]), (int)Math.sqrt(array[k]));
                    return true;
                }
                else if(sum > cSquare)
                    j--;
                else i++;
            }
        }
        return false;
    }
}
