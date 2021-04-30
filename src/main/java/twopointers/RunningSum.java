package twopointers;

import java.util.Arrays;

/**
 * @author haicheng.long@androidmov.com
 * @ClassName RunningSum
 * @Description <a href="https://leetcode-cn.com/problems/running-sum-of-1d-array/">一维数组的动态和</a>
 * @date 2021/4/30 16:01
 */
public class RunningSum {

    /**
     * 以下标1开始，先获取第二个数和第二个数的和，并设置为和为第二个数；  执行i++
     * 以下标2开始，获取第三个数和第二个数的和，并将和设置到第三位； 执行i++
     * 以此类推
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i]+ nums[i-1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
        RunningSum runningSum = new RunningSum();
        runningSum.runningSum(arr);
        System.out.println(Arrays.toString(arr));
    }
}