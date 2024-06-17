package www;
import java.util.Scanner;

public class NumTrees {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(numTrees(n));
    }

    public static int numTrees(int n)
    {
        int[]dp=new int[n+1];
        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i ; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

}
