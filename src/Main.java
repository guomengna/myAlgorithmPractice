import com.sun.deploy.util.SyncAccess;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

//import java.util.*;
import javax.swing.text.html.HTMLDocument;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Niuke2018 niuke2018 = new Niuke2018();
        niuke2018.recycleNums();
//        niuke2018.sortString("9638");

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        //将从控制台读取的数字存放在h中
//        int[] h = new int[n];
//        for(int i = 0; i < n; i++){
//            h[i] = sc.nextInt();
//        }
//        for(int i = 0; i < n; i++){
//            for(int j = i; j < n; j++){
//                if(h[j] < h[i]){
//                    int temp = h[j];
//                    h[j] = h[i];
//                    h[i] = temp;
//                }
//            }
//        }
//        //将站好的疯狂队列存在a中
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(h[0]);
//        h[0] = 0;
//        //i代表站队已经站好的人数
//        for(int i = 1; i < n; i++){
//            int maxMinus = -1;
//            int index = 0;
//            for(int j = 0; j < n; j++){
//                System.out.println("h["+j+"] = "+h[j]);
//                if(h[j] != 0){
//                    int minus = Math.abs(h[j] - a.get(i-1));
//                    if(minus > maxMinus){
//                        maxMinus = minus;
//                        index = j;
//                    }
//                }
//            }
//            a.add(h[index]);
//            h[index] = 0;
//        }
//        for(int i = 0; i < a.size(); i++){
//            System.out.println(a.get(i));
//        }
//        int res = 0;
//        for(int i = 0; i+1 < n; i++){
//            res += Math.abs(a.get(i+1) - a.get(i));
//        }
//        System.out.println(res);
//        Scanner sc = new Scanner(System.in);
//        ArrayList<String> arrayList = new ArrayList<>();
//        HashSet<String> hashSet = new HashSet<>();
//        do{
//            String s = sc.nextLine();
//            System.out.println(s);
//            if(s.equals(" ")){
//                break;
//            }else{
//                //输入没有结束
//                String regex = "^[a-z0-9A-Z]+$";
//                if(s.matches(regex)) {
//                    s = LeftRotateString(s, 10);
//                    hashSet.add(s);
//                }else {
//                    arrayList.add(s);
//                }
//            }
//        }while(true);
//        Iterator it = hashSet.iterator();
//        String[] right = new String[hashSet.size()];
//        int i = 0;
//        while(it.hasNext()){
//            right[i] = it.next().toString();
//            i++;
//        }
//        right = getUrlParam(right);
//        for(int j = 0; j < right.length; j++){
//            System.out.println(right[j]);
//        }
//        for(int j = 0; j < arrayList.size(); j++){
//            System.out.println(arrayList.get(i));
//        }
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