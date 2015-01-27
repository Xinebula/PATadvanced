package PAT1006;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/27.
 */
public class PAT1006 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String ID_number;
        String tempTime;
        int sign_in_time;
        int sign_out_time;
        int h,m,s;
        String unlock="";
        int earliest_time=Integer.MAX_VALUE;
        String lock="";
        int latest_time=0;
        int M = in.nextInt();
        for(int i=0;i<M;i++){
            ID_number = in.next();
            tempTime = in.next();
            h = (tempTime.charAt(0)-'0')*10+(tempTime.charAt(1)-'0');
            m = (tempTime.charAt(3)-'0')*10+(tempTime.charAt(4)-'0');
            s = (tempTime.charAt(6)-'0')*10+(tempTime.charAt(7)-'0');
            sign_in_time = h*3600+m*60+s;
            tempTime = in.next();
            h = (tempTime.charAt(0)-'0')*10+(tempTime.charAt(1)-'0');
            m = (tempTime.charAt(3)-'0')*10+(tempTime.charAt(4)-'0');
            s = (tempTime.charAt(6)-'0')*10+(tempTime.charAt(7)-'0');
            sign_out_time = h*3600+m*60+s;
            if(sign_in_time<earliest_time){
                earliest_time=sign_in_time;
                unlock=ID_number;
            }
            if(sign_out_time>latest_time){
                latest_time=sign_out_time;
                lock=ID_number;
            }
        }
        System.out.print(unlock+" "+lock);
    }
}
