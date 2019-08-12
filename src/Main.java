import com.sun.deploy.util.SyncAccess;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

//import java.util.*;
import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){

    }

    //贝壳测试第4题 通过64%
    public static void Beike4(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] num = new long[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextLong();
        }
        if(n == 1){
            System.out.println(0);
            return;
        }
        if(n == 2 && num[0] != num[1]){
            System.out.println(0);
            return;
        }
        long minTotal = Long.MAX_VALUE;

        for(int i = 0; i < n; i++){
            long[] nums = new long[n];
            for(int j = 0; j < n; j++){
                nums[j] = num[j];
            }
            long min = 0;
            //i及之前递增；
            for(int j = 0; j+1 <= i; j++){
                if(nums[j+1] <= nums[j]){
                    long t = nums[j+1];
                    nums[j+1] = nums[j]+1;
                    min += nums[j+1] - t;
                }
            }
            for(int j = i; j+1 < n; j++){
                if(nums[j] < nums[j+1]){
                    long t = nums[j];
                    nums[j] = nums[j+1] + 1;
                    min += nums[j] - t;
                }
            }
            if(i != n-1 && nums[i] == nums[i+1]){
                nums[i+1]++;
                min++;
            }
            minTotal = Math.min(minTotal, min);
        }
        System.out.println(minTotal);
    }

    public static boolean judge(String str, String pat){
        String[] strs = str.split(" ");
        if(strs.length != pat.length()){
//            System.out.println("false");
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char c = pat.charAt(i);
            if(map.get(c) == null){
                map.put(c, strs[i]);
            }else if(!map.get(c).equals(strs[i])){
//                System.out.println("false");
                return false;
            }
        }
//        System.out.println("true");
        return true;
    }

    public static boolean judgeReverse(String str, String pat){
        String[] strs = str.split(" ");
        if(strs.length != pat.length()){
//            System.out.println("false");
            return false;
        }
        HashMap<String, Character> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char c = pat.charAt(i);
            if(map.get(strs[i]) == null){
                map.put(strs[i], c);
            }else if(!map.get(strs[i]).equals(c)){
//                System.out.println("false");
                return false;
            }
        }
//        System.out.println("true");
        return true;
    }


    public static void readIPs() throws Exception{
        File file = new File("E:\\file.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        String s = "";
        while((s = bufferedReader.readLine()) != null){
            sb.append(s+"\n");
        }
        bufferedReader.close();
        String string  = sb.toString();
        String patternStr = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher m = pattern.matcher(string);
        while(m.find()){
            System.out.println(m.group(0));
        }
    }

    /**
     * 全排列，无重复数字
     * @param array 排列的数组
     * @param k 从第k个数字开始排列
     * @param m 数组的最后一个元素的下标
     */
    public static void quanSort(int[] array, int k, int m){
        if(k == m){
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i]);
            }
            System.out.println();
        }else {
            for(int i = k; i <= m; i++){
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;

                quanSort(array, k+1, m);

                int temp1 = array[i];
                array[i] = array[k];
                array[k] = temp1;
            }
        }
    }

    public static void quanSort1(int[] array, int k, int m){
        if(k == m){
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i]);
            }
            System.out.println();
        }else {
            for(int i = k; i <= m; i++){
                if(!has(array, k, i)){
                    int temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;

                    quanSort(array, k+1, m);

                    int temp1 = array[i];
                    array[i] = array[k];
                    array[k] = temp1;
                }
            }
        }
    }
    public static boolean has(int[] array, int i, int j){
        for(int k = i; k < j; k++){
            if(array[k] == array[j]){
                return true;
            }
        }
        return false;
    }

    public static boolean Find(int target, int [][] array) {
        for(int i = 0; i < array.length; i++){
            if(target == array[i][0] || target == array[i][array[i].length-1]){
                return true;
            }
            if(target > array[i][0] && target < array[i][array[i].length-1]){
                for(int j = 0; j < array[i].length-1; j++){
                    if(target == array[i][j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static ArrayList<Integer> sort(ArrayList<Integer> a){
        for(int i = 0; i < a.size(); i++){
            for(int j = i; j < a.size(); j++){
                if(a.get(i) < a.get(j)){
                    int t = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, t);
                }
            }
        }

        return a;
    }
    //寻找连续子序列
    public static ArrayList<ArrayList<Integer>> getSubnum(int[] a){
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> r = new ArrayList<>();
        res.add(a[0]);
        for(int i = 0; i+1 < a.length; i++){

            if(a[i] + 1 == a[i+1]){
                res.add(a[i+1]);
            }else {
                if(res.size() <= 1){
                    res = new ArrayList<Integer>();
                }else {
                    r.add(res);
                }
                res = new ArrayList<Integer>();
            }
        }
        res = new ArrayList<>();
        res.add(a[0]);
        for(int i = 0; i+1 < a.length; i++){
            if(a[i] - 1 == a[i+1]){
                res.add(a[i+1]);
            }else {
                if(res.size() == 1){
                    res = new ArrayList<Integer>();
                }else {
                    r.add(res);
                }
                res = new ArrayList<Integer>();
            }
        }

        return r;
    }


    // 按照字典序排序字符串数组
    public static String[] getUrlParam(String[] keys){
        for (int i = 0; i < keys.length - 1; i++) {
            for (int j = 0; j < keys.length - i -1; j++) {
                String pre = keys[j];
                String next = keys[j + 1];
                if(isMoreThan(pre, next)){
                    String temp = pre;
                    keys[j] = next;
                    keys[j+1] = temp;
                }
            }
        }
        return keys;
    }
    private static boolean isMoreThan(String pre, String next){
        if(null == pre || null == next || "".equals(pre) || "".equals(next)){
            return false;
        }
        char[] c_pre = pre.toCharArray();
        char[] c_next = next.toCharArray();
        int minSize = Math.min(c_pre.length, c_next.length);
        for (int i = 0; i < minSize; i++) {
            if((int)c_pre[i] > (int)c_next[i]){
                return true;
            }else if((int)c_pre[i] < (int)c_next[i]){
                return false;
            }
        }
        if(c_pre.length > c_next.length){
            return true;
        }
        return false;
    }

    //循环左移
    public static String LeftRotateString(String str,int n) {
        if(str.length()==0||str==null)
            return "";
        String a=Rote(str);
        String a1=Rote(a.substring(0, str.length()-n));
        String a2=Rote(a.substring(str.length()-n, str.length()));
        return  a1+a2;
    }
    static String Rote(String str){
        char []a=new char[str.length()];
        for(int i=0,j=str.length()-1;i<=j;i++,j--){
            a[j]=str.charAt(i);
            a[i]=str.charAt(j);
        }
        return String.valueOf(a);
    }


//

//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
//        int count = 0;
//        int res = 0;
//        for(int i = 13; count <= k; i += 2){
//            if(ifSu(i)){
//                if(!reverseNum(i)){
//                    //i是素数,并且反过来与原来的值不相等
//                    count++;
//                }
//            }
//            if(count == k && i <= 1000000){
//                res = i;
//                break;
//            }
//        }
//        System.out.println(res);

    //        int rows = sc.nextInt();
//        int cols = sc.nextInt();
//        int thredhold = sc.nextInt();
//
//        boolean[][] visit = new boolean[rows][cols];
//
//        int count = movingCount(thredhold, rows, cols, 0, 0, visit);
//        System.out.println(count);
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        int[] nums = new int[len];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = sc.nextInt();
//        }
//        //找出两个最小值和三个最大值
//        if (nums.length < 3) {
//            return;
//        } else {
//            long min1 = Long.MIN_VALUE;
//            long min2 = Long.MIN_VALUE;
//            long max1 = Long.MAX_VALUE;
//            long max2 = Long.MAX_VALUE;
//            long max3 = Long.MAX_VALUE;
//            max1 = Math.max(nums[0], nums[1]);
//            max2 = Math.min(nums[0], nums[1]);
//            if (nums[2] > max1) {
//                max3 = max2;
//                max2 = max1;
//                max1 = nums[2];
//            } else if (nums[2] > max2) {
//                max3 = max2;
//                max2 = nums[2];
//            } else {
//                max3 = nums[2];
//            }
//            min1 = max3;
//            min2 = max2;
//            for (int i = 2; i < nums.length; i++) {
//                if (nums[i] > max1) {
//                    max3 = max2;
//                    max2 = max1;
//                    max1 = nums[i];
//                } else if (nums[i] > max2) {
//                    max3 = max2;
//                    max2 = nums[i];
//                } else if (nums[i] > max3) {
//                    max3 = nums[i];
//                }
//                if (nums[i] < min1) {
//                    min2 = min1;
//                    min1 = nums[i];
//                } else if (nums[i] < min2) {
//                    min2 = nums[i];
//                }
//            }
//            long res = 0;
//            if (min2 >= 0) {//全部数字都为正
//                res = max1 * max2 * max3;
//                System.out.println(res);
//                return;
//            } else {
//                res = Math.max(res, min1 * min2 * max1);
//                System.out.println(res);
//                return;
//            }
//        }
    public static boolean reverseNum(int num){
        StringBuffer sb = new StringBuffer(num + "");
        int r = Integer.parseInt(sb.reverse().toString());
        if(r != num){
//            System.out.println("不相等");
            return false;
        }
//        System.out.println("相等");
        return true;
    }
    public static boolean ifSu(int num){
        boolean r = false;
        for(int i = 2; i <= num; i++){
            if( (num % i) == 0 ){
                if(((i != num) && (i != 1))){
                    r = false;
                    break;
                }
                if(i == num){
                    r = true;
                }
            }
        }
        System.out.println(r);
        return r;
    }

    public static int movingCount(int thredhold, int rows, int cols, int row, int col, boolean[][] visit){
        if( row < 0 || row >= rows || col < 0 || col >= cols || visit[row][col] ||
                gitDigitSum(row)+gitDigitSum(col) > thredhold){
            return 0;
        }
        visit[row][col] = true;
        return movingCount(thredhold, rows, cols, row-1, col, visit) +
                movingCount(thredhold, rows, cols, row, col-1, visit) +
                movingCount(thredhold, rows, cols, row+1, col, visit) +
                movingCount(thredhold, rows, cols, row, col+1, visit) + 1;
    }
    public static int gitDigitSum(int row){
        int sum = 0;
        while(row != 0){
            sum += row % 10;
            row = row / 10;
        }
        return sum;
    }
}


//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        //input
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] killer = new int[n];
//        for(int i = 0; i < n; i++){
//            killer[i] = sc.nextInt();
//        }
//        System.out.println(nightCount(killer,n));
//    }
//    //how many nights needed to stop killing
//    private static int nightCount(int[] killer, int n) {
//        int count = 0;
//        while(judgeIfKill(killer)){
//            count++;
//            int j = 0;//how many killers has been killed
//            for(int i = killer.length-1; i>0; i--){
//                if(killer[i] < killer[i-1]){
//                    killer[i] = -1;//if this killer is killed, make it -1
//                    j++;
//                }
//            }
//            //killer's length should minus j
//            killer = change(killer,killer.length - j);
//        }
//        return count;
//    }
//    //killer has changed
//    private static int[] change(int[] killer, int num) {
//        int[] newKiller = new int[num];
//        for(int i = 0,k = 0; i < killer.length; i++){
//            if(killer[i] != -1){
//                newKiller[k] = killer[i];
//                k++;
//            }
//        }
//        return newKiller;
//    }
//    //judge if need to kill
//    private static boolean judgeIfKill(int[] killer) {
//        boolean flag = false;
//        for(int i = 1; i < killer.length; i++){
//            if(killer[i] == -1)
//                continue;
//            if(killer[i-1] > killer[i]){
//                flag = true;
//            }
//        }
//        return flag;
//    }
//public class Main {
//    public static void main(String[] args) {
//        //input
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];//存储输入的数组
//        for(int i = 0; i < n; i++){
//            nums[i] = sc.nextInt();
//
//        }
//        int result = -1000;
//        for(int i = 0; i < nums.length-1; i++){
//            int minSum = FrontMinSum(nums, i);
//            int maxSum = AfterMaxSum(nums, i);
//            int temp = maxSum - minSum;
//            if(result < temp){
//                result = temp;
//            }
//        }
//        System.out.println(result);
//    }
//    //下标index之前数的最小和
//    private static int FrontMinSum(int[] nums, int index){
//        if(index == 0 || index == 1){
//            return 0;
//        }
//        int minSum = 0;
//        for(int i = index-1; i > 0; i--){
//            int temp = minSum + nums[i];
//            if(temp < minSum){
//                minSum = temp;
//            }
//        }
//        return minSum;
//    }
//    //下标index及其之后数的最大和
//    private static int AfterMaxSum(int[] nums, int index){
//        if(index == nums.length-1){
//            return nums[index];
//        }
//        int maxSum = nums[index];
//        for(int i = index+1; i <= nums.length-1; i++){
//            int temp = maxSum + nums[i];
//            if(temp > maxSum){
//                maxSum = temp;
//            }
//        }
//        return maxSum;
//    }
//
//    public static void main(String[] args) {
//        Scanner s1 = new Scanner(System.in);
//        String Left1_1 = s1.next();
//        String Left2_1 = s1.next();
//        Scanner s2 = new Scanner(System.in);
//        String right1_1 = s2.next();
//        System.out.println(Left1_1 +"+"+ Left2_1+"="+right1_1);
//
//        Scanner s3 = new Scanner(System.in);
//        String Left1_2 = s3.next();
//        String Left2_2 = s3.next();
//        Scanner s4 = new Scanner(System.in);
//        String right1_2 = s4.next();
//        String right2_2 = s4.next();
//        System.out.println(Left1_2 +"-"+ Left2_2+"="+right1_2+"+"+right2_2);
//
//        double x,y;
//        for(x=1;x<100;x++){
//            for(y=1;y<100;y++){
//                if( (3*x+2*y) == 10 && (4*x - y)==(4+y)){
//                    System.out.println(x+" "+y);
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        ArrayList<Integer> numes = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        numes.add(sc.nextInt());
//        while(sc.hasNextLine()){
//            Scanner s = new Scanner(System.in);
//            int a = s.nextInt();
//            if(a != 0)
//                numes.add(a);
//            if(a == -1){
//                break;
//            }
//            int b = s.nextInt();
//            if(b == -1){
//                break;
//            }
//            if(b != 0){
//                for(int j =a+1; j<=b;j++){
//                    numes.add(j);
//                }
//            }
//        }
//        System.out.println(numes);
//        int left =0;
//        int right = left+1;
//        int count = 1;
//        while(right<numes.size()){
//            if(numes.get(right)-numes.get(left) ==1){
//                right++;
//                left++;
//                count ++;
//            }else {
//                right++;
//                left++;
//                count=1;
//            }
//        }
//        System.out.println(count);
//    }
//}