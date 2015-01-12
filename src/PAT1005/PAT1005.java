package PAT1005;

import java.io.IOException;

/**
 * Created by xiny on 2015/1/12.
 */
public class PAT1005 {
    public static void main(String[] args) throws IOException {
        int sum=0;
        int d=0;
        d=System.in.read()-48;
        while(d<10&&d>0){
            sum+=d;
            d=(int)System.in.read()-48;
        }
        int i;
        int[] num = new int[10];
        for(i=0;sum>0;i++){
            num[i] = sum%10;
            sum/=10;
        }
        if(i==0)
            i++;
        switch (num[i-1]){
            case 0:
                System.out.print("zero");
                break;
            case 1:
                System.out.print("one");
                break;
            case 2:
                System.out.print("two");
                break;
            case 3:
                System.out.print("three");
                break;
            case 4:
                System.out.print("four");
                break;
            case 5:
                System.out.print("five");
                break;
            case 6:
                System.out.print("six");
                break;
            case 7:
                System.out.print("seven");
                break;
            case 8:
                System.out.print("eight");
                break;
            case 9:
                System.out.print("nine");
                break;
            default:
                break;
        }
        for(int j=i-2;j>=0;j--){
            switch (num[j]){
                case 0:
                    System.out.print(" zero");
                    break;
                case 1:
                    System.out.print(" one");
                    break;
                case 2:
                    System.out.print(" two");
                    break;
                case 3:
                    System.out.print(" three");
                    break;
                case 4:
                    System.out.print(" four");
                    break;
                case 5:
                    System.out.print(" five");
                    break;
                case 6:
                    System.out.print(" six");
                    break;
                case 7:
                    System.out.print(" seven");
                    break;
                case 8:
                    System.out.print(" eight");
                    break;
                case 9:
                    System.out.print(" nine");
                    break;
                default:
                    break;
            }
        }
    }
}
