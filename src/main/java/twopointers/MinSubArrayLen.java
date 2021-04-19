package twopointers;


import javax.annotation.Resource;

/**
 * @author haicheng.long@androidmov.com
 * @ClassName MinSubArrayLen
 * @Description <a href="https://leetcode-cn.com/problems/minimum-size-subarray-sum/">长度最小的子数组</a>
 * @date 2021/4/19 下午 7:26
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;    // nums[l...r]为我们的滑动窗口
        int sum = 0;
        int result = nums.length + 1;
        while (l < nums.length) { // 窗口的左边界在数组范围内,则循环继续

            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else { // r已经到头 或者 sum >= s
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                result = (r - l + 1) < result ? (r - l + 1) : result;
            }
        }
        if (result == nums.length + 1) {
            return 0;
        }
        return result;

    }

    public int minSubArrayLen1(int s, int[] nums) {
        int left = 0, right = -1, result = Integer.MAX_VALUE, sum = 0;
        while (left < nums.length) {
            if (left < nums.length && sum < s) {
                right++;
                sum += nums[right];
            } else {
                left++;
                sum -= nums[left];
            }

            if (sum > s) {
                result =right-left+1 > result? result:right-left+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen1(target, nums));
    }
}