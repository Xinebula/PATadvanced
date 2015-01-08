package PAT1001;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/8.
 */
public class PAT1001 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long sum;
        int flag=1;
        int[] nums = new int[10];
        int count=0;
        sum = a+b;
        if(sum<0){
            sum*=-1;
            flag=-1;
        }
        for(;sum>0;){
            nums[count]=(int)sum%1000;
            sum/=1000;
            count++;
        }
        if(flag==-1)
            System.out.print("-");
        for(int i=count-1;i>0;i--){
            System.out.print(nums[i]);
            System.out.print(",");
        }
        System.out.print(nums[0]);
    }
}
