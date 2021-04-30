package twopointers;

/**
 * @author haicheng.long@androidmov.com
 * @ClassName MaximumWealth
 * @Description <a href="https://leetcode-cn.com/problems/richest-customer-wealth/">最富有客户的资产总量</a>
 * @date 2021/4/30 16:35
 */
public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        // 循环后把和赋值给sum  比较max和sum和大小  再赋值给max  最后返回Max
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {3, 2, 1}};
        MaximumWealth maximumWealth = new MaximumWealth();
        System.out.println(maximumWealth.maximumWealth(arr));
    }
}