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

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p = 0, q = 0;
        int[] arr = new int[m + n];
        int temp = 0;
        while (p < m && q < n) {
            if (nums1[p] < nums2[q]) {
                arr[temp++] = nums1[p++];
            } else if (nums2[q] < nums1[p]) {
                arr[temp++] = nums2[q++];
            } else if (nums1[p] == nums2[q]) {
                arr[temp++] = nums1[p++];
            }
        }
        System.arraycopy(nums1, 0, arr, 0, m + n);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        System.out.println(Arrays.toString(nums1));
        mergeSortedArray.merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}