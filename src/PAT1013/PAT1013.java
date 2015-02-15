package PAT1013;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/30.
 */
public class PAT1013 {
    static int[][] map;
    static int N,M,K;
    static int[] checkingMap;
    static List toCheck = new List();//store the cities connected(the head of the list is empty)
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        K = in.nextInt();
        map = new int[N][N];
        int x,y;
        for(int i=0;i<M;i++){
            x = in.nextInt()-1;
            y = in.nextInt()-1;
            map[x][y] = 1;
            map[y][x] = 1;
        }
        int city;
        int n;//the number of the cities connected
        for(int i=0;i<K;i++){
            checkingMap = new int[N];
            List thisCheck = toCheck;
            n=0;
            city = in.nextInt()-1;
            for(int j=0;j<N;j++){
                if(map[city][j]==1){
                    List aCityConnected = new List();
                    aCityConnected.cityID = j;
                    thisCheck.next = aCityConnected;
                    thisCheck = aCityConnected;
                    n++;
                }
            }
            if(n==0){//actually this check is useless
                System.out.println("0");
                continue;
            }
            if(n==1){
                System.out.println("0");
                continue;
            }
            List checking = toCheck;
            for(int j=0;j<n;j++){//check all the cities that are connected with the checking city
                checking = checking.next;//start from the second of the list
                n=check(checking.cityID,city,n);
            }
            System.out.println(n-1);
        }
    }
    static int check(int start,int checkingCity,int n){
        checkingMap[start]=1;
        for(int i=0;i<N;i++){
            if(i==checkingCity)
                continue;
            if(map[start][i]==1&&checkingMap[i]==0){
                List thisCheck = toCheck;
                while(thisCheck.next!=null){
                    if(thisCheck.next.cityID==i){
                        thisCheck.next = thisCheck.next.next;
                        n--;
                        break;
                    }
                    thisCheck = thisCheck.next;
                }
                n=check(i,checkingCity,n);
            }
        }
        return n;
    }
}

class List{
    int cityID = -1;
    List next = null;
}
