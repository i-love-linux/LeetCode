package _0209_Minimum_Size_Subarray_Sum;

public class Solution {
    // 时间复杂度：O(n^3)
    // 空间复杂度：O(1)
    // Time Limit Exceeded
    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int length = nums.length + 1;

        for (int i = 0; i < nums.length; i++)
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum += nums[k];

                if (sum >= s)
                    length = Math.min(length, j - i + 1);

            }

        return length == nums.length + 1 ? 0 : length;
    }

    public static void main(String[] args) {
//        int[] numbers = {2,3,1,2,4,3};
        int[] numbers = {5,1,3,5,10,7,4,9,2,8};
        int s = 15;

        System.out.println((new Solution()).minSubArrayLen(s, numbers));
    }
}
