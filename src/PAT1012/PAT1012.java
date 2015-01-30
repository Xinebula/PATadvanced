package PAT1012;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/30.
 */
public class PAT1012 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N,M;
        N = in.nextInt();
        M = in.nextInt();
        Score[] scores = new Score[N];
        for(int i=0;i<N;i++){//input scores
            scores[i] = new Score(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
        }
        Score[] ranks = new Score[N];
        for(int i=0;i<N;i++){//calculate ranks
            int c=1,m=1,e=1,a=1;
            for(int j=0;j<N;j++){
                if(scores[j].C>scores[i].C)
                    c++;
                if(scores[j].M>scores[i].M)
                    m++;
                if(scores[j].E>scores[i].E)
                    e++;
                if(scores[j].A>scores[i].A)
                    a++;
            }
            ranks[i] = new Score(scores[i].StudentID,c,m,e,a);
        }
        int found;
        for(int i=0;i<M;i++){//output
            int anID = in.nextInt();
            found=0;
            for(int j=0;j<N;j++){
                if(anID==ranks[j].StudentID){
                    if(ranks[j].A<=ranks[j].C&&ranks[j].A<=ranks[j].M&&ranks[j].A<=ranks[j].E){
                        System.out.println(ranks[j].A + " A");
                        found=1;
                        break;
                    }
                    if(ranks[j].C<=ranks[j].M&&ranks[j].C<=ranks[j].E&&ranks[j].C<=ranks[j].A){
                        System.out.println(ranks[j].C+" C");
                        found=1;
                        break;
                    }
                    if(ranks[j].M<=ranks[j].C&&ranks[j].M<=ranks[j].E&&ranks[j].M<=ranks[j].A){
                        System.out.println(ranks[j].M+" M");
                        found=1;
                        break;
                    }
                    if(ranks[j].E<=ranks[j].C&&ranks[j].E<=ranks[j].M&&ranks[j].E<=ranks[j].A){
                        System.out.println(ranks[j].E+" E");
                        found=1;
                        break;
                    }
                }
            }
            if(found==0)
                System.out.println("N/A");
        }
    }
}

class Score{
    int StudentID;
    int C;
    int M;
    int E;
    int A;
    public Score(int ID,int c,int m,int e){
        StudentID = ID;
        C = c;
        M = m;
        E = e;
        A = (c+m+e)/3;
    }
    public Score(int ID,int c,int m,int e,int a){
        StudentID = ID;
        C = c;
        M = m;
        E = e;
        A = a;
    }
}