package PAT1004;

import java.util.Scanner;

/**
 * Created by xiny on 2015/1/11.
 */

class Tree{
    int n;
    int[] son;
    int level = -1;
    public Tree(Scanner in){
        n = in.nextInt();
        son = new int[n];
        for(int i=0;i<n;i++){
            this.son[i] = in.nextInt();
        }
    }
}
public class PAT1004 {
    static int[] count = new int[100];
    static Tree[] allNodes = new Tree[100];
    static int maxLevel = 0;
    public static void main(String[] args){
        int N,M;
        int id;
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        for(int i=0;i<M;i++){
            id = in.nextInt();
            Tree aTree = new Tree(in);
            allNodes[id] = aTree;
        }
        allNodes[1].level=0;
        getNumber(1);
        System.out.print(count[0]);
        for(int i=1;i<=maxLevel+1;i++)
            System.out.print(" "+count[i]);
    }
    static void getNumber(int id){
        Tree aTree = allNodes[id];
        if(aTree.level>maxLevel)
            maxLevel = aTree.level;
        if(aTree.n==0){
            count[aTree.level]++;
            return;
        }
        for(int i=0;i<aTree.n;i++){
            if(allNodes[aTree.son[i]]==null)
                count[aTree.level+1]++;
            else{
                allNodes[aTree.son[i]].level = aTree.level+1;
                getNumber(aTree.son[i]);
            }
        }
    }
}
