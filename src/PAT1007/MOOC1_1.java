package PAT1007;
import java.util.*;
public class MOOC1_1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		maxSum s = new maxSum(n,in);
		returnValue a = s.getAnswer();
		System.out.println(a.max+" "+a.startNum+" "+a.stopNum);
	}
}
class maxSum{
	int n;
	int[] num;
	maxSum(int m,Scanner in){
		n = m;
		num = new int[n];
		for(int i=0;i<n;i++){
			num[i]=in.nextInt();
		}
	}
	returnValue getAnswer(){
		returnValue a = this.fenZhi(0, n-1);
		if(a.max<0){
			a.max = 0;
			a.startNum = num[0];
			a.stopNum = num[n-1];
		}
		else{
			a.startNum = num[a.startNum];
			a.stopNum = num[a.stopNum];
		}
		return a;
	}
	returnValue fenZhi(int start,int stop){
		returnValue value = new returnValue();
		if(stop==start){
			value.max=num[start];
			value.startNum=start;
			value.stopNum=stop;
			return value;
		}
		else{
			int sumLeft = 0,sumRight = 0;
			int max_sumLeft = -99999,max_sumRight = -99999;
			value=fenZhi(start,(start+stop)/2);
			returnValue sum = new returnValue();
			for(int i=(start+stop)/2;i>=start;i--){
				sumLeft+=num[i];
				if(sumLeft>max_sumLeft){
					max_sumLeft=sumLeft;
					sum.startNum=i;
				}
			}
			for(int i=(start+stop)/2+1;i<=stop;i++){
				sumRight+=num[i];
				if(sumRight>max_sumRight){
					max_sumRight=sumRight;
					sum.stopNum=i;
				}
			}
			sum.max=max_sumRight+max_sumLeft;
			if(value.max<sum.max)
				value=sum;
			sum=fenZhi((start+stop)/2+1,stop);
			if(value.max<sum.max)
				value=sum;
			return value;
		}
	}
}
class returnValue{
	int max;
	int startNum;
	int stopNum;
}