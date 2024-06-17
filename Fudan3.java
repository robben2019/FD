package www;

import javax.print.attribute.standard.Finishings;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;
public class Fudan3 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println("有 " + countWays(nums, target) + " 种取法使得整数序列的和等于期望值");
    }

    public static int countWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int offset = sum; // 使用偏移量将负数转换为非负数

        int[][] dp = new int[nums.length + 1][2 * offset + 1];
        dp[0][offset] = 1; // 初始化，表示和为0的情况有一种取法

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= 2 * offset; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i - 1] <= 2 * offset) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target + offset];
    }


}
