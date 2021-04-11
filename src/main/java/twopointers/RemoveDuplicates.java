package twopointers;

/**
 * @description: <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/">80. 删除有序数组中的重复项 II</a>
 * @author: 582895699@qq.com
 * @time: 2021/4/11 下午 04:47
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        // 数组检查
        int size = nums.length;
        if (size < 2) {
            return -1;
        }
        // 由于每个元素最多出现两次，所以可以保留前两个
        int slow = 2, fast = 2;
        // 防止出现数据越界
        while (fast < size) {
            // 如果当前元素(fast)与num[slow-2]的值相等，表示已经出现第三个相等元素
            // 通过判断不相等，把不相等的元素移动到slow当前的位置，覆盖第三个重复元素
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                // 已替换 执行++操作
                slow++;
            }
            // 出现第三个相等元素，执行fast++
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int a = removeDuplicates.removeDuplicates(arr);
        System.out.println(a);
    }
}
