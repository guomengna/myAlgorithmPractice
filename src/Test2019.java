import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    // 游戏海报
    public void gameposts(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int res = 0;
        char[] c = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        if(str.length() == 1){
            System.out.println(51);
        }else{
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < str.length(); i++){
                if(map.get(str.charAt(i))!=null){
                    map.put(str.charAt(i), map.get(str.charAt(i))+1);
                }else{
                    map.put(str.charAt(i), 1);
                }
            }
            for(int i = 0; i < c.length; i++){
                int count = 0;
                if(map.get(c[i])!= null){
                    count = map.get(c[i]);
                }
                int t = str.length() - count + 1;
                res += t;
            }

            System.out.println(res);
        }
    }
    // 字符串归一化
    public void Stringyasuo(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] nums = new int[26];
        for(int i = 0; i < str.length(); i++){
            nums[str.charAt(i)-97]++;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                System.out.print((char)(i+97));
                System.out.print(nums[i]);
            }
        }
    }
    // 回文子串
    // 数出一个字符串中的回文子串的数量
    public void numsofHuiwenSubString(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = s.length();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                String t = s.substring(i, j);
                if(ifHuiwen(t)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    // 判断一个字符串是不是回文串
    public boolean ifHuiwen(String s){
        String s1 = "";
        for(int i = s.length()-1; i >= 0; i--){
            s1 += s.charAt(i);
        }
        if(s.equals(s1)){
            return true;
        }else{
            return false;
        }
    }

    // 鸡鸭分类
    public void chickAndDuck(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // D在左
        int l = 0;
        int[] count = new int[s.length()];
        count[0] = -1;
        if(s.charAt(0) == 'D'){
            count[0] = 0;
        }
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == 'D'){
                count[i] = count[i-1] + 1;
            }else{
                count[i] = count[i-1];
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'D'){
                l += i - count[i];
            }
        }
        //D在右
        int r = 0;
        int[] count1 = new int[s.length()];
        count1[s.length()-1] = -1;
        if(s.charAt(s.length()-1) == 'D'){
            count1[s.length()-1] = 0;
        }
        for(int i = s.length()-2; i >= 0; i--){
            if(s.charAt(i) == 'D'){
                count1[i] = count1[i+1] + 1;
            }else{
                count1[i] = count1[i+1];
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'D'){
                r += s.length()-1 - i - count1[i];
            }
        }
        int res = Math.min(l, r);
        System.out.println(res);
    }

    // 方格走法，动态规划算法
    public void fanggeZoufa(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] cp = new int[x+1][y+1];
        for(int i = 0; i <= x; i++){
            for(int j = 0; j <= y; j++){
                if(i == 0 && j == 0){
                    cp[i][j] = 0;
                }else if(i == 0 || j == 0){
                    cp[i][j] = 1;
                }else{
                    cp[i][j] = cp[i-1][j] + cp[i][j-1];
                }
            }
        }
        int res = cp[x][y];
        System.out.println(res);
    }

    //会话列表
    public void HuihuaList(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int n1 = sc.nextInt();
            int[] num = new int[n1];
            for(int j = 0; j < n1; j++){
                num[j] = sc.nextInt();
            }
            ArrayList<Integer> a = new ArrayList<>();
            for(int j = 0; j < n1; j++){
                if(a.size() == 0){
                    a.add(num[j]);
                }else {
                    int index = inArray(num[j], a);
                    if(index != -1){
                        int t = num[j];
                        for(int k = index-1; k >= 0; k--){
                            a.set(k+1, a.get(k));
                        }
                        a.set(0, t);
                    }else{
                        int size = a.size();
                        a.add(num[j]);
                        for(int k = size; k > 0; k--){
                            a.set(k, a.get(k-1));
                        }
                        a.set(0, num[j]);
                    }
                }
            }
            for(int j = 0; j < a.size(); j++){
                System.out.print(a.get(j)+" ");
            }
            System.out.println();
        }
    }
    public int inArray(int j, ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == j) {
                return i;
            }
        }
        return -1;
    }
}
