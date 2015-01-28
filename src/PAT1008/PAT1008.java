package PAT1008;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/27.
 */
public class PAT1008 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nowFloor=0;
        int nextFloor;
        int time=0;
        for(int i=0;i<n;i++){
            nextFloor = in.nextInt();
            if(nextFloor>=nowFloor)
                time+=(nextFloor-nowFloor)*6+5;
            else
                time+=(nowFloor-nextFloor)*4+5;
            nowFloor = nextFloor;
        }
        System.out.print(time);
    }
}
