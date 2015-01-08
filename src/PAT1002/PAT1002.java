package PAT1002;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/9.
 */
public class PAT1002 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        double[][] nums1 = new double[n1][2];
        for(int i=0;i<n1;i++){
            nums1[i][0] = in.nextDouble();
            nums1[i][1] = in.nextDouble();
        }
        int n2 = in.nextInt();
        double[][] nums2 = new double[n1][2];
        for(int i=0;i<n2;i++){
            nums2[i][0] = in.nextDouble();
            nums2[i][1] = in.nextDouble();
        }
        int now1=0,now2=0,now3=0;
        double[][] nums3 = new double[n1+n2][2];
        while(now1!=n1&&now2!=n2){
            if(nums1[now1][0]==nums2[now2][0]){
                if(nums1[now1][1]+nums2[now2][1]==0){
                    now1++;
                    now2++;
                }
                else{
                    nums3[now3][0]=nums1[now1][0];
                    nums3[now3][1]=nums1[now1][1]+nums2[now2][1];
                    now3++;
                    now1++;
                    now2++;
                }
            }
            else if(nums1[now1][0]>nums2[now2][0]){
                if(nums1[now1][1]==0){
                    now1++;
                }
                else {
                    nums3[now3][0] = nums1[now1][0];
                    nums3[now3][1] = nums1[now1][1];
                    now1++;
                    now3++;
                }
            }
            else{
                if(nums2[now2][1]==0){
                    now2++;
                }
                else {
                    nums3[now3][0] = nums2[now2][0];
                    nums3[now3][1] = nums2[now2][1];
                    now2++;
                    now3++;
                }
            }
        }
        if(now1==n1)
            for(;now2!=n2;now2++){
                if(nums2[now2][1]==0)
                    continue;
                nums3[now3][0]=nums2[now2][0];
                nums3[now3][1]=nums2[now2][1];
                now3++;
            }
        else
            for(;now1!=n1;now1++){
                if(nums1[now1][1]==0)
                    continue;
                nums3[now3][0]=nums1[now1][0];
                nums3[now3][1]=nums1[now1][1];
                now3++;
            }
        System.out.print(now3);
        for(int i=0;i<now3;i++)
            System.out.printf(" %d %.1f",(int)nums3[i][0],nums3[i][1]);
    }
}
