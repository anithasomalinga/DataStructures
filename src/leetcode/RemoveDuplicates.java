    package leetcode;

    import java.util.Arrays;
    import java.util.Set;
    import java.util.TreeSet;

    // Remove duplicates from sorted array
    public class RemoveDuplicates {

        public static int removeDuplicates1(int[] nums) {
//            int[] nums = {1,1,1,2,2,3,5,5};
    //        int count = 0;
            int i = 0;
            for(int num : nums){
                if(i < 1 || num > nums[i-1]){
                    nums[i++] = num;
                }
            }
            System.out.println(Arrays.toString(nums));
            System.out.println(nums.length);
            return i;
        }
        public static int removeDuplicates(int[] nums) {
            // Length of the updated array
            int count = 0;
            // Loop for all the elements in the array
            for (int i = 0; i < nums.length; i++) {
                // If the current element is equal to the next element, we skip
                if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    continue;
                }
                // We will update the array in place
                nums[count] = nums[i];
                count++;
            }
            System.out.println(Arrays.toString(nums));
            System.out.println(nums.length);
            return count;
        }

        private static void removeDuplicates2(int[] nums) {
            Set<Integer> set = new TreeSet<>();
            for(int n : nums) {
                set.add(n);
            }
            System.out.println(Arrays.asList(set));
        }

        public static void main(String[] args) {
            int[] nums = {1,1,1,2,2,3,5,5};
            removeDuplicates1(nums);
        }

    }
