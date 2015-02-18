package PAT1016;

import java.util.Scanner;

/**
 * Created by xiny on 2015/2/18.
 */
public class PAT1016 {
    public static void main(String[] args){
        int[] toll = new int[24];
        Scanner in = new Scanner(System.in);
        for(int i=0;i<24;i++)
            toll[i] = in.nextInt();
        int n = in.nextInt();
        Information[] s = new Information[n];
        String[] nameList = new String[n];
        int l=0,m=0;
        outer:for(int i=0;i<n;i++){//create the information array and the nameList array
            Information a = new Information(in.next(),in.next(),in.next());
            s[i] = a;
            if(l==0){
                nameList[0] = a.name;
                l++;
            }
            for(int j=0;j<l;j++){
                if(nameList[j].equals(a.name))
                    continue outer;
                m=0;
                while(nameList[j].charAt(m)==a.name.charAt(m))
                    m++;
                if(nameList[j].charAt(m)>a.name.charAt(m)){
                    for(int k=l-1;k>=j;k--)
                        nameList[k+1]=nameList[k];
                    nameList[j]=a.name;
                    l++;
                    continue outer;
                }
            }
            nameList[l] = a.name;
            l++;
        }
        Information[] t = new Information[n];
        double totalAmount;
        for(int i=0;i<l;i++){//output each customer in order
            totalAmount = 0;
            System.out.print(nameList[i]+" ");
            System.out.printf("%02d\n",s[0].month);
            int p=0;
            for(int j=0;j<n;j++){//get the call information of this customer
                if(s[j].name.equals(nameList[i])) {
                    t[p] = s[j];
                    p++;
                }
            }
            Information temp;
            for(int j=p;j>=2;j--){//bubble sort by calling time
                for(int k=0;k<j-1;k++){
                    if(t[k].timeMin>t[k+1].timeMin){
                        temp = t[k];
                        t[k] = t[k+1];
                        t[k+1] = temp;
                    }
                }
            }
            boolean onlineFound=false,offlineFound=false;
            for(int j=0;j<p;j++){//it`s a check
                if(!onlineFound){
                    if(t[j].ifOn){
                        onlineFound=true;
                    }
                }
                else{
                    if(!t[j].ifOn){
                        offlineFound=true;
                        break;
                    }
                }
            }
            if(!(onlineFound&&offlineFound)){
                System.out.println("Total amount: $0.00");
                continue;
            }
            onlineFound=false;
            Information online=null,offline=null;
            double thisCost;
            for(int j=0;j<p;j++){
                if(!onlineFound){
                    if(t[j].ifOn){
                        online = t[j];
                        onlineFound=true;
                    }
                }
                else{
                    if(t[j].ifOn){
                        online = t[j];
                    }
                    else{
                        offline = t[j];
                        thisCost=0;
                        if(online.date==offline.date) {
                            if (online.hour == offline.hour) {
                                thisCost += (offline.minute - online.minute) * toll[online.hour];
                            } else {
                                thisCost += (60 - online.minute) * toll[online.hour];
                                thisCost += offline.minute * toll[offline.hour];
                                for (int k = online.hour + 1; k < offline.hour; k++) {
                                    thisCost += 60 * toll[k];
                                }
                            }
                        }
                        else{
                            thisCost+=(60 - online.minute) * toll[online.hour];
                            for(int k=online.hour+1;k<24;k++)
                                thisCost+=60*toll[k];
                            thisCost+=offline.minute * toll[offline.hour];
                            for(int k=0;k<offline.hour;k++)
                                thisCost+=60*toll[k];
                            for(int k=online.date+1;k<offline.date;k++)
                                for(int x=0;x<24;x++)
                                    thisCost+=60*toll[x];
                        }
                        thisCost/=100;
                        System.out.print(online.time.substring(3)+" "+offline.time.substring(3)+" "+(offline.timeMin-online.timeMin)+" $");
                        System.out.printf("%.2f\n", thisCost);
                        totalAmount+=thisCost;
                        onlineFound=false;
                    }
                }
            }
            System.out.printf("Total amount: $%.2f\n", totalAmount);
        }

    }
}
class Information{
    String name;
    String time;
    int month;
    int date;
    int hour;
    int minute;
    int timeMin;
    boolean ifOn;
    public Information(String a,String b,String c){
        name = a;
        time = b;
        if(c.equals("on-line"))
            ifOn = true;
        else
            ifOn = false;
        month = (time.charAt(0)-48)*10+(time.charAt(1)-48);
        date = (time.charAt(3)-48)*10+(time.charAt(4)-48);
        hour = (time.charAt(6)-48)*10+(time.charAt(7)-48);
        minute = (time.charAt(9)-48)*10+(time.charAt(10)-48);
        timeMin = ((time.charAt(3)-48)*10+(time.charAt(4)-48))*24*60+((time.charAt(6)-48)*10+(time.charAt(7)-48))*60+((time.charAt(9)-48)*10+(time.charAt(10)-48));
    }
}
