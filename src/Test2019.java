import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
}
