package twopointers;

import java.util.Arrays;

/**
 * @author haicheng.long@androidmov.com
 * @ClassName MergeSortedArray
 * @Description <a herf="https://leetcode-cn.com/problems/merge-sorted-array/">合并两个有序数组</a>
 * @date 2021/4/16 上午 11:21
 */
public class MergeSortedArray {

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        System.out.println(Arrays.toString(nums1));
        mergeSortedArray.merge1(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}