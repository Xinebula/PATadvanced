import java.util.Scanner;

/**
 * Created by xiny on 2015/1/28.
 */
public class CharToInt {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a = in.next();
        for(int i=0;i<a.length();i++)
            System.out.print(" "+(int)a.charAt(i));
    }
}
