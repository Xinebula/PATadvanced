package PAT1010;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/28.
 */
public class PAT1010 {
    public static void main(String[] args){
        String N1,N2;
        int tag,radix;
        Scanner in = new Scanner(System.in);
        N1 = in.next();
        N2 = in.next();
        tag = in.nextInt();
        radix = in.nextInt();
        int[] num1 = new int[10];
        int[] num2 = new int[10];
        int num1_length,num2_length;
        int number1=0,number2;
        int max_digit2=0;
        if(tag==1){
            num1_length=N1.length();
            num2_length=N2.length();
            for(int i=0;i<num1_length;i++){
                int a = N1.charAt(i);
                if(a<=57&&a>=48)
                    num1[i] = a-48;
                else if(a<=122&&a>=97)
                    num1[i] = a-87;
            }
            for(int i=0;i<num2_length;i++){
                int a = N2.charAt(i);
                if(a<=57&&a>=48){
                    num2[i] = a-48;
                    if(a-48>max_digit2)
                        max_digit2=a-48;
                }
                else if(a<=122&&a>=97){
                    num2[i] = a-87;
                    if(a-87>max_digit2)
                        max_digit2=a-87;

                }
            }
        }
        else{
            num1_length=N2.length();
            num2_length=N1.length();
            for(int i=0;i<num1_length;i++){
                int a = N2.charAt(i);
                if(a<=57&&a>=48)
                    num1[i] = a-48;
                else if(a<=122&&a>=97)
                    num1[i] = a-87;
            }
            for(int i=0;i<num2_length;i++){
                int a = N1.charAt(i);
                if(a<=57&&a>=48){
                    num2[i] = a-48;
                    if(a-48>max_digit2)
                        max_digit2=a-48;
                }
                else if(a<=122&&a>=97){
                    num2[i] = a-87;
                    if(a-87>max_digit2)
                        max_digit2=a-87;
                }
            }
        }
        for(int i=0;i<num1_length;i++){
            number1*=radix;
            number1+=num1[i];
        }
        int r;
        for(r=max_digit2+1;r<=36;r++){
            number2=0;
            for(int i=0;i<num2_length;i++){
                number2*=r;
                number2+=num2[i];
            }
            if(number2==number1){
                System.out.print(r);
                break;
            }
        }
        if(r==37)
            System.out.print("Impossible");
    }
}
