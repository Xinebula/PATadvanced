package PAT1003;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/11.
 */
class Map{
    private int N;
    private int[][] map;
    private int[] rescueTeam;
    private int[] went;
    private int[] numOfRescue = new int[1000];//Might need larger
    private int numOfRoutes = 0;
    private int shortestRoute = Integer.MAX_VALUE;
    public Map(int n){
        this.N = n;
        map = new int[n][n];
        rescueTeam = new int[n];
        went = new int[n];
    }
    public void setRescueTeam(int i,int n){
        rescueTeam[i] = n;
    }
    public void setMap(int i,int j,int L){
        map[i][j] = L;
        map[j][i] = L;
    }
    public int getLength(int i,int j){
        return map[i][j];
    }
    public int getRescueTeam(int i){
        return rescueTeam[i];
    }
    void findRoute(int i,int f,int l,int n){
        went[i]=1;
        n+=rescueTeam[i];
        if(i==f){
            if(l<shortestRoute){
                shortestRoute = l;
                numOfRoutes = 1;
                numOfRescue[0] = n;
                went[i]=0;
                return;
            }
            if(l==shortestRoute){
                numOfRescue[numOfRoutes] = n;
                numOfRoutes++;
                went[i]=0;
                return;
            }
            went[i]=0;
            return;
        }
        for(int j=0;j<N;j++){
            if(this.map[i][j]!=0&&went[j]==0){
                findRoute(j,f,l+map[i][j],n);
            }
        }
        went[i]=0;
        return ;
    }

    public int getNumOfRoutes(){
        return numOfRoutes;
    }

    public int getNumOfRescue(){
        int n=0;
        for(int i=0;i<numOfRoutes;i++)
            if(numOfRescue[i]>n)
                n=numOfRescue[i];
        return n;
    }
}

public class PAT1003 {
    public static void main(String[] args){
        int N,M,C1,C2;
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        C1 = in.nextInt();
        C2 = in.nextInt();
        Map aMap = new Map(N);
        for(int i=0;i<N;i++)
            aMap.setRescueTeam(i,in.nextInt());
        for(int i=0;i<M;i++)
            aMap.setMap(in.nextInt(),in.nextInt(),in.nextInt());
        aMap.findRoute(C1,C2,0,0);
        System.out.print(aMap.getNumOfRoutes() + " " + aMap.getNumOfRescue());
    }
}
