package PAT1014;

import java.util.Scanner;

/**
 * Created by xiny on 2015/2/16.
 */
public class PAT1014 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        int Q = in.nextInt();
        int[] customers = new int[K];//store the input data
        int[] finishTime = new int[K];//store the output data
        for(int i=0;i<K;i++){
            customers[i] = in.nextInt();
        }
        int[][] queue = new int[N][M];
        for(int i=0;i<N;i++){//initialize
            if(i==K)
                break;
            queue[i][0] = customers[i];
            finishTime[i] = customers[i]+480;//store the finish time
//            if(finishTime[i]>1020)
//                finishTime[i]=-1;
        }
        outer1:for(int i=1;i<M;i++){
            for(int j=0;j<N;j++){
                if((i*N+j)>=K)
                    break outer1;
                queue[j][i] = customers[i*N+j]+queue[j][i-1];
                finishTime[i*N+j] = queue[j][i]+480;//store the finish time
//                if(finishTime[i*N+j]>1020)
//                    finishTime[i*N+j]=-1;
            }
        }
        if(N*M-1<K) {
            int nextCustomer = N * M;
            int temp;
            outer:
            for (int min = 0; min <= 540; min++) {//As time goes
                for (int i = 0; i < N; i++) {
                    if (queue[i][0] == min) {
                        temp = queue[i][M - 1];//store the last data of queue in case of M==1
                        for (int j = 0; j < M - 1; j++) {
                            queue[i][j] = queue[i][j + 1];//move the data in queue forward
                        }
                        queue[i][M - 1] = customers[nextCustomer] + temp;//get the next customer in queue
                        finishTime[nextCustomer] = queue[i][M - 1] + 480;//store the finish time
                        nextCustomer++;
                        if (nextCustomer == K)//check whether there`s no more customer
                            break outer;
                    }
                }
            }
//            if (nextCustomer < K)//for those customers who cannot finish their transaction
//                for (; nextCustomer < K; nextCustomer++)
//                    finishTime[nextCustomer] = -1;
        }
        int check,hour,minute;
        for(int i=0;i<Q;i++){
            check = in.nextInt()-1;
            if(finishTime[check]>=480&&finishTime[check]<=1020){
                hour = finishTime[check]/60;
                minute = finishTime[check]%60;
                System.out.printf("%02d:%02d",hour,minute);
                System.out.println();
            }
            else {
                System.out.println("Sorry");
            }
        }
    }
}
