package twopointers;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: <a href="https://leetcode-cn.com/problems/4sum/">四数之和</a>
 * @author: 582895699@qq.com
 * @time: 2021/4/1 下午 10:59
 */
public class Foursum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int size = nums.length;
        if (size == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        int[] arr = {};
        int target = 1;
        Foursum foursum = new Foursum();
        List<List<Integer>> lists = foursum.fourSum(arr, target);
        System.out.println(JSONUtil.toJsonStr(lists));
    }
}
