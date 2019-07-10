import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Test2019 {
    public void days(){
        String dateStr = "2012-3-12";
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String ss[] = new String[t];
        for(int i = 0; i < t; i++){
            String y = sc.next();
            String m = sc.next();
            String d = sc.next();
            String dateStr2 = y+"-"+m+"-"+d;
            ss[i] = dateStr2;
        }
        for(int i = 0; i < t; i++){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            try
            {
                Date date2 = format.parse(ss[i]);
                Date date = format.parse(dateStr);
                System.out.println(differentDaysByMillisecond(date,date2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    //计算相差几天
    public int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println((day2-day1));
            return day2-day1;
        }
    }
    //计算相差几天，用毫秒计算
    public int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

    public void teachclass(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num[] = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
        int count = fun1(num);
        int min = 0;
        for(int i = 0; i < n; i++){
            min += num[i]/count;
        }
        System.out.println(min);
    }
    //求一个数组的最大公约数
    public int fun1(int[] num) {
        int count = 0;
        for (int i = 2; i < num.length; i++) {
            count = gcd(gcd(num[i - 2], num[i - 1]), num[i]);
        }
        return count;
    }
    //求最大公约数
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public void ifIP(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.length() < 7 || s.length() > 15){
            System.out.println("NOT");
            return;
        }else {
            String[] strs = s.split("\\.");
            if(strs.length != 4){
                System.out.println("NOT");
                return;
            }else {
                for(int i = 0; i < strs.length; i++){
                    if(strs[i].length() > 3){
                        System.out.println("NOT");
                        return;
                    }else {
                        for(int j = 0; j < strs[i].length(); j++){
                            if(strs[i].charAt(j) < '0' || strs[i].charAt(j) > '9'){
                                System.out.println("NOT");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("IS");
    }

    // 快排
    public void quicksort(int[] a, int p, int q){
        if(p < q){
            int r = partition(a, p, q);
            quicksort(a, p, r-1);
            quicksort(a, r+1, q);
        }
    }

    //划分
    public int partition(int[] a, int p, int q){
        int x = a[p];
        int i = p;
        for(int j = p+1; j <= q; j++){
            if(a[j] < x){
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i];
        a[i] = a[p];
        a[p] = t;
        return i;
    }

    public void sameLincklistNode(){
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(6);
        l2.add(7);
        int same = -1;
        if(l1.size() < l2.size()){
            LinkedList t = l1;
            l1 = l2;
            l2 = t;
        }
        int minus = l1.size() - l2.size();
        for(int i = minus, j = 0; i < l1.size(); i++, j++){
            if(l1.get(i) == l2.get(j)){
                same = l1.get(i);
                System.out.println(same);
                return;
            }
        }
        System.out.println("none");
    }
    // 迷路的牛牛
    public void lostway(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] s = new char[n];
        for(int i = 0; i < n; i++){
            s[i] = str.charAt(i);
        }
        int lc = 0;
        int rc = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == 'L'){
                lc++;
            }else{
                rc++;
            }
        }
        if(lc > rc){
            lc = lc - rc;
            int t = lc % 4;
            if(t == 0){
                System.out.println("N");
            }else if(t == 1){
                System.out.println("W");
            }else if(t == 2){
                System.out.println("S");;
            }else if(t == 3){
                System.out.println("E");;
            }
        }else if(lc < rc){
            rc = rc - lc;
            int t = rc % 4;
            if(t == 0){
                System.out.println("N");;
            }else if(t == 1){
                System.out.println("E");;
            }else if(t == 2){
                System.out.println("S");;
            }else if(t == 3){
                System.out.println("W");;
            }
        }else{
            System.out.println("N");;
        }
    }

}
