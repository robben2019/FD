package www;
import java.util.Scanner;

public class DiffentPath {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入m和n");
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        System.out.println(pathCount(m,n));

    }


    public static int pathCount(int m,int n)
    {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }



}
