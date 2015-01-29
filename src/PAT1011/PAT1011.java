package PAT1011;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/29.
 */
public class PAT1011 {
    public static void main(String[] args){
        double[][] odds = new double[3][5];
        Scanner in = new Scanner(System.in);
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++) {
                odds[i][j] = in.nextDouble();
                if(odds[i][j]>odds[i][4]){
                    odds[i][4]=odds[i][j];
                    odds[i][3]=j;
                }
            }
        double profit = (odds[0][4]*odds[1][4]*odds[2][4]*0.65-1)*2;
        for(int i=0;i<3;i++){
            if(odds[i][3]==0)
                System.out.print("W ");
            if(odds[i][3]==1)
                System.out.print("T ");
            if(odds[i][3]==2)
                System.out.print("L ");
        }
        System.out.printf("%.2f",profit);
    }
}
