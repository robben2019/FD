package www;
import java.lang.reflect.Method;

public class Bag2 {

    public static void main(String[] args) {
        int[] nums = {1,2,4,1,7,8,3};
        System.out.println(methodfeidigui(nums));
        System.out.println(methoddigui(nums, nums.length-1));
    }



public static int methodfeidigui(int[]nums)
{
 int[]dp=new int[nums.length];
 dp[0]=nums[0];
 dp[1]=Math.max(nums[0],nums[1]);
for(int i=2;i<nums.length;i++)
{
dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
}
return dp[nums.length-1];
}


public static int methoddigui(int[]nums,int length)
{
if(length==0)
{
    return nums[0];
}
else if(length==1)
{
    return Math.max(nums[0],nums[1]);
}
else
{
    int a=methoddigui(nums,length-2)+nums[length];
    int b=methoddigui(nums,length-1);
    return Math.max(a,b);
}
}



}
