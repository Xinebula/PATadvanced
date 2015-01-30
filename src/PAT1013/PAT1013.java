package PAT1013;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/30.
 */
public class PAT1013 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N,M,K;
        N = in.nextInt();
        M = in.nextInt();
        K = in.nextInt();
        int[][] map = new int[N][N];
        int x,y;
        for(int i=0;i<M;i++){
            x = in.nextInt();
            y = in.nextInt();
            map[x][y] = 1;
        }

    }
}
