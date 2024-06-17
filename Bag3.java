package www;

public class Bag3 {


    public static void main(String[] args) {
        int[] nums = {3,34,4,12,5,2};
        System.out.println(methoddigui(nums,nums.length-1,9));
        System.out.println(methoddigui(nums,nums.length-1,10));
        System.out.println(methoddigui(nums,nums.length-1,11));
        System.out.println(methoddigui(nums,nums.length-1,12));
        System.out.println(methoddigui(nums,nums.length-1,13));

        System.out.println('\n');

        System.out.println(methodfeidigui(nums,9));
        System.out.println(methodfeidigui(nums,10));
        System.out.println(methodfeidigui(nums,11));
        System.out.println(methodfeidigui(nums,12));
        System.out.println(methodfeidigui(nums,13));

    }



public static boolean methoddigui(int[]nums,int length,int target)
{
    if(target==0)
    {
        return true;
    }
    else if(length==0)
    {
        return nums[0]==target;
    }
    else if(nums[length]>target)
    {
        return methoddigui(nums,length-1,target);
    }
     else{
        boolean a=methoddigui(nums,length-1,target);
        boolean b=methoddigui(nums,length-1,target-nums[length]);
        return a||b;
    }
}




public static boolean methodfeidigui(int[]nums,int target)
{
    boolean[][]dp=new boolean[nums.length][target+1];
    for(int i=0;i<nums.length;i++)
    {
        dp[i][0]=true;
    }
    for(int j=0;j<target+1;j++)
    {
        dp[0][j]=false;
    }
    dp[0][nums[0]]=dp[0][0]=true;

    for(int m= 1;m<nums.length;m++)
    {
        for(int n=1;n<target+1;n++)
        {
            if(nums[m]>n)
            {
                dp[m][n]=dp[m-1][n];
            }
            else {
                boolean a = dp[m-1][n-nums[m]];
                boolean b = dp[m-1][n];
                dp[m][n]=a||b;
            }
        }
    }
    return dp[nums.length-1][target];

}



}
