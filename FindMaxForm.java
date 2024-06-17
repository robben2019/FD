package www;

public class FindMaxForm {
    public static void main(String[] args) {
        String []strs={"10", "0001", "111001", "1", "0"};
        int m=5;
        int n=3;
        Solution solution=new Solution();

        System.out.println(solution.findMaxForm(strs,m,n));


    }
}


class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i < strs.length + 1; i++) {
            String s = strs[i - 1];
            int[] zerosOnes = getZerosOnes(s);
            int zeros = zerosOnes[0];
            int ones = zerosOnes[1];
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j < zeros || k < ones) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }


    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }
}













