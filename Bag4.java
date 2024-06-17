package www;
import java.util.Scanner;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class Bag4 {

    public static void main(String[] args) {
        int[]cost=new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(stepCost(cost));
    }



    public static int stepCost(int[]cost)
    {
        int[]dp=new int [cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<cost.length+1;i++)
        {
            dp[i]=Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[cost.length];
    }



}
//


