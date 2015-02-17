package PAT1015;

import java.util.Scanner;

/**
 * Created by xiny on 2015/2/17.
 */
public class PAT1015 {
    public static void main(String[] args){
        int N,D,c;
        int[] digits = new int[100];
        Scanner in = new Scanner(System.in);
        while(true) {
            N = in.nextInt();
            if(N<0)
                break;
            D = in.nextInt();
            c=0;
            while(N>0){//get the digits of the number
                digits[c] = N%D;
                N = N/D;
                c++;
            }
            int num1=0, num2=0;
            for(int i=0;i<c;i++){
                num1*=D;
                num1+=digits[i];
            }
            for(int i=c-1;i>=0;i--){
                num2*=D;
                num2+=digits[i];
            }
            if(isPrime(num1)&&isPrime(num2))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    static boolean isPrime(int n){
        if(n==1||n==0)
            return false;
        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
