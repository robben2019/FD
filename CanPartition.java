package www;
import java.util.ArrayList;
import java.util.Scanner;

public class CanPartition {
    public static void main(String[] args) {
        Scanner get=new Scanner(System.in);
        String str=get.nextLine();
        String[] srr=str.split(" ");
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < srr.length; i++) {
            list.add(Integer.valueOf(srr[i]));
        }
        System.out.println(canPartition(list));
        get.close();
    }


    public static boolean  canPartition(ArrayList<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        int flag = sum % 2;
        if (flag != 0) {
            return false;
        } else {
            int target=sum/2;
            boolean[][] dp = new boolean[nums.size()][target + 1];
            for (int i = 0; i < nums.size(); i++) {
                dp[i][0] = true;
            }
            for (int j = 0; j < target + 1; j++) {
                dp[0][j] = false;
            }
            dp[0][nums.get(0)] = dp[0][0] = true;

            for (int m = 1; m < nums.size(); m++) {
                for (int n = 1; n < target + 1; n++) {
                    if (nums.get(m) > n) {
                        dp[m][n] = dp[m - 1][n];
                    } else {
                        boolean a = dp[m - 1][n - nums.get(m)];
                        boolean b = dp[m - 1][n];
                        dp[m][n] = a || b;
                    }
                }
            }
            return dp[nums.size() - 1][target];
        }
    }


}
