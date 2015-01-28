package PAT1009;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/28.
 */
public class PAT1009 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double[] input1 = new double[1000];
        double[] input2 = new double[1000];
        double[] output = new double[2000];
        int n1 = in.nextInt();
        int k;
        for(int i=0;i<n1;i++){
            k = in.nextInt();
            input1[k] = in.nextDouble();
        }
        int n2 = in.nextInt();
        for(int i=0;i<n2;i++){
            k = in.nextInt();
            input2[k] = in.nextDouble();
        }
        int p=0,q;
        for(int i=0;i<n1;p++){
            if(input1[p]==0)
                continue;
            q=0;
            for(int j=0;j<n2;q++){
                if(input2[q]==0)
                    continue;
                output[p+q]+=input1[p]*input2[q];
                j++;
            }
            i++;
        }
        int n=0;
        for(int i=0;i<50;i++)
            if(output[i]!=0)
                n++;
        System.out.print(n);
        int r=1999;
        for(int i=0;i<n;r--){
            if(output[r]!=0){
                System.out.printf(" %d %.1f",r,output[r]);
                i++;
            }
        }
    }
}
