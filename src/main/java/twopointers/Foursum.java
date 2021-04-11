package twopointers;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: <a href="https://leetcode-cn.com/problems/4sum/">四数之和</a>
 * <a href="https://juejin.cn/post/6949796539732590628/">四数之和 | 刷题打卡</a>
 * @author: 582895699@qq.com
 * @time: 2021/4/1 下午 10:59
 */
public class Foursum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 判断是否是合法数组
        int size = nums.length;
        if (size < 4) {
            return Collections.emptyList();
        }
        // 排序
        Arrays.sort(nums);
        // 定义List接受结果
        List<List<Integer>> lists = new ArrayList<>();
        // 最外层循环
        for (int a = 0; a < size; a++) {
            // 如果最左边的数已经向右移动了，就判断和之前的数是否一样，若一样就跳出此次循环（获取第一个数）
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // 第二个数是在第一个数的基础上加1（获取第二个数）
            for (int b = a + 1; b < size; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // 定义第三个数（获取第三个数）
                int left = b + 1;
                // 把最后一个数放在数组的尾端(获取第四个数)
                int right = size - 1;
                // 若左指正小于右指针，执行循环
                while (left < right) {
                    // 若四数之和小于target，执行left++ 使target变大
                    if (nums[a] + nums[b] + nums[left] + nums[right] < target) {
                        left++;
                        // 若四叔之和大于target，执行right++，是target变小
                    } else if (nums[a] + nums[b] + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        // 四叔之和等于target 放入list中
                        lists.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));

                        // 判断left将要右移的数是不是等于当前的值，若等于，执行left++
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // 判断right将要右移的数是不是等于当前的值，若等于，执行right--
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // left++ 继续执行下一次探索
                        left++;
                        // left++ 继续执行下一次探索
                        right--;
                    }
                }
            }
        }
        // 返回最后结果
        return lists;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        Foursum foursum = new Foursum();
        List<List<Integer>> lists = foursum.fourSum(arr, target);
        System.out.println(JSONUtil.toJsonStr(lists));
    }
}
