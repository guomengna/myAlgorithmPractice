import com.sun.deploy.util.SyncAccess;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

//import java.util.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.StyleSheet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        String s = "";
        String res = resolve(s);
        System.out.println(res);
    }
    //xiecheng 2
    static String resolve(String expr) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        String res = "";
        for(int i = 0; i < expr.length(); i++){
            char c = expr.charAt(i);
            if(c == '('){
                s1.push(c);
            }else if(c == ')' && !s1.isEmpty()){
                s1.pop();
            }
        }
        if(!s1.isEmpty()){
            return "";
        }
        for(int i = 0; i < expr.length(); i++){
            String t = "";
            char c = expr.charAt(i);
            if(c == '('){
                s1.push(c);
            }else if(c == ')'){
                if(s1.isEmpty()){
                    return "";
                }
                s1.pop();
                while(!s2.isEmpty()){
                    char ct = s2.pop();
                    t += String.valueOf(ct);
                }
                if(s1.isEmpty()){
                    res = t;
                }
                if(!s1.isEmpty()){
                    for(int j = 0; j < t.length(); j++){
                        s2.push(t.charAt(j));
                    }
                }
            }else {
                if(s1.isEmpty()){
                    res += String.valueOf(c);
                }else {
                    s2.push(c);
                }
            }
        }
        return res;
    }
    //xiecheng 3
    static int schedule(int m,int[] array) {
        int l = 0;
        int r = 0;
        for(int i = 0; i < array.length; i++){
            l = Math.max(l, array[i]);
            r += array[i];
        }
        int middle = 0;
        while(l < r){
            middle = (l + r)/2;
            int temp = 1;
            int sum = array[0];
            for(int i = 1; i < array.length; i++){
                if(sum+array[i] <= middle){
                    sum += array[i];
                }else{
                    temp++;
                    if(temp > m){
                        break;
                    }
                    sum = array[i];
                }
            }
            if(temp > m){
                l = middle + 1;
            }else{
                r = middle;
            }
        }
        return r;
    }

    public static void didi1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++){
            int tMax = 0;
            for(int j = 0; j < n; j++){
                tMax = Math.max(tMax, nums[j][i]);
            }
            res += tMax;
        }
        System.out.println(res);
    }

    //36%
    public static void didi2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        if(n < 3){
            return;
        }
        long res = 0;
        int count  = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                res += nums[i];
                count++;
            }
        }
        if(count == n){
            System.out.println(res);
            return;
        }
        res = 0;
        for(int i = 0; i < n; i++){
            res += nums[i];
        }
//        System.out.println("res = "+res);
        for(int i = 1; i < n; i++){
            for(int s = 0; s < n; s++){
                int temp = 0;
                int cou = 0;
                for(int j = 0; j < n; ){
                    temp += nums[j];
                    j += i;
                    cou++;
                }
                if(cou >= 3){
//                System.out.println("temp = "+temp);
                    res = Math.max(res, temp);
                }
            }
        }
        System.out.println(res);
    }

    public static int Switch(int n){
        int i = 10;
        switch (n){
            case 1:i--;
            case 2:i++;
            case 3:i--;
            case 4:i++;
            case 5:i--;
            case 6:i++;
            case 7:i--;
            default:i--;
        }
        return i+n;
    }

    public static void Shangtang3(){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int f0 = sc.nextInt();
        final int t = 1000000007;
        int[] nums = new int[4];
        nums[0] = f0;
        nums[1] = a * nums[0] + 32768;
        nums[2] = a * nums[1] + b * nums[0] + 2 * 2 * 2 - 2 + 32767;
        nums[3] = a * nums[2] + b * nums[1] + c * nums[0] + 2 * 3 * 3 - 3 + 32767;
        for(int i = 4; i <= n; i++){
            int temp = (a * nums[(i-1) % 3] + b * nums[(i-2) % 3]
                    + c * nums[(i-3) % 3] + 2 * i * i - i + 32767) % t;
            nums[i % 3] = temp;
        }
        System.out.println(nums[(int)(n % 3)]);
    }

//    public static void Shangtang4(){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] num = new int[n];
//        for(int i = 0; i < n; i++){
//            num[i] = sc.nextInt();
//        }
//        if(n == 1){
//            System.out.println(0);
//            return;
//        }
//        cou = new HashMap<>();
//        map = new HashMap<>();
//        for(int i : num){
//            cou.put(i, cou.getOrDefault(i, 0) + 1);
//        }
//        for(int i : cou.keySet()){
//            map.put(i, new ArrayList<Integer>());
//        }
//        for(int i : cou.keySet()){
//            for(int j : cou.keySet()){
//                int t = (int) (Math.sqrt(i+j)+0.5);
//                if(t * t == i+j){
//                    map.get(i).add(j);
//                }
//            }
//        }
//        int result = 0;
//        for(int i : cou.keySet()){
//            result += fun(i, n-1);
//        }
//        System.out.println(result);
//    }
//
//    public static int fun(int i, int size){
//        cou.put(i, cou.get(i) - 1);
//        int res = 1;
//        if(size != 0){
//            res = 0;
//            for(int j : map.get(i)){
//                if(cou.get(j) !=0){
//                    res += fun(j, size-1);
//                }
//            }
//        }
//        cou.put(i,cou.get(i) + 1);
//        return res;
//    }


    public static void Shangtang2(){
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
        if(num == null || num.length < 3){
            System.out.println(0);
            return;
        }
        int result = 0;
        for(int i = 1; i< num.length-1; i++){
            if(num[i] > num[i-1] && num[i] > num[i+1]){
                int left = i-1;
                int right = i+1;
                while(left > 0 && num[left - 1] < num[left]){
                    left--;
                }
                while(right < num.length-1 && num[right] > num[right+1]){
                    right++;
                }
                result = Math.max(result, right-left+1);
            }
        }
        System.out.println(result);
    }

    public static void Shangtang1(){
        Scanner sc =new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        String[] strs = s.split(" ");
        for(int i = 0; i < strs.length; i++){
            if(strs[i].equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(strs[i].equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }else if(strs[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(strs[i].equals("/")){
                int temp = stack.pop();
                stack.push(stack.pop() / temp);
            }else {
                stack.push(Integer.parseInt(strs[i]));
            }
        }
        System.out.println(stack.pop());
    }

    public static void t3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            if(i == n-1){
                int r = 2;
                int low = nums[i-1];
                for(int j = i-2; j >= 0; j--){
                    if(nums[j] > low){
                        low = nums[j];
                        r++;
                    }
                }
                System.out.print(r+" ");
            }else if(i == 0){
                int r = 2;
                int high = nums[i+1];
                for(int j = i+2; j < n; j++){
                    if(nums[j] > high){
                        high = nums[j];
                        r++;
                    }
                }
                System.out.print(r+" ");
            }else {
//                System.out.println("i = "+i);
                int r = 3;
                int low = nums[i-1];
                int high = nums[i+1];
                for(int j = i-2; j >= 0; j--){
//                    System.out.println("low = "+low +" and nums[j] = "+nums[j]);
                    if(nums[j] > low){
                        low = nums[j];
                        r++;
                    }
                }
                for(int j = i+2; j < n; j++){
//                    System.out.println("high = "+high +" and nums[j] = "+nums[j]);
                    if(nums[j] > high){
                        high = nums[j];
                        r++;
                    }
                }
                System.out.print(r+" ");
            }
        }
    }

    public static void t2(){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n = 1;
        for(int i = 0; i < n1; i++){
            n *= 2;
        }
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] fan = new int[m];
        for(int i = 0; i < m; i++){
            fan[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            //翻转的一组的长度
            int fanLength = 1;
            for(int j = 0; j < fan[i]; j++){
                fanLength *= 2;
            }
            fanzhuan(nums, fanLength);
        }
    }

    public static int[] fanzhuan(int[] a, int size){
        int i = 0;
        int j = i + size-1;
        while(j < a.length){
            int i1 = i;
            int j1 = j;
            while(i1 < j1){
                //翻转
                int t = a[i1];
                a[i1] = a[j1];
                a[j1] = t;
                i1++;
                j1--;
            }
            i = j + 1;
            j = i + size;
        }
        for(int k = 0; k < a.length; k++){
            System.out.print(a[k]);
        }
        return a;
    }


    public static void t1(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        String r = "";
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '['){
                //数字压栈1
                s1.push(Integer.parseInt(String.valueOf(s.charAt(i+1))));
                i++;
                //字母压栈2
                int j = i+1;
                int index = -1;
                while(j < s.length()){
                    if(s.charAt(j) == '[' || s.charAt(j) == ']'){
                        index = j - 1;
                        break;
                    }
                    j++;
                }
                s2.push(s.substring(i+2, index+1));
//                System.out.println(s.substring(i+2, index+1));
                i = index + 1;
            }else if(s.charAt(i) == ']'){
                String tem = s2.pop();
                String re = "";
                int count = s1.pop();
                for(int j = 0; j < count; j++){
                    re += tem;
                }
                if(!s2.empty()){
                    String re1 = s2.pop() + re;
                    s2.push(re1);
                }else {
                    r += re;
                }
                i++;
            }else {
                r +=  s.charAt(i);
                i++;
            }
        }
        System.out.println(r);
    }

    //琪琪有N个数字，她想知道有多少数字可以恰好用剩余n-1中的两个数字的和表示
    public static void beike2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> num = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            num.add(sc.nextInt());
        }
        num = sort1(num);
        int res = 0;
        for(int i = 0; i < n; i++){
            int target = num.get(i);
            //剩余n-1个数字,排过序了
            ArrayList<Integer> a = new ArrayList<>(n-1);
            for(int j = 0; j < n; j++){
                if(j != i){
                    a.add(num.get(j));
                }
            }
            outer:
            for(int j = 0; j < a.size(); j++){
                for(int k = j+1; k < a.size(); k++){
                    if(a.get(j) + a.get(k) == target){
                        res++;
                        break outer;
                    }else if(a.get(j) + a.get(k) > target){
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }

    public static ArrayList<Integer> sort1(ArrayList<Integer> a){
        for(int i = 0; i < a.size(); i++){
            for(int j = i; j < a.size(); j++){
                if(a.get(i) > a.get(j)){
                    int t = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, t);
                }
            }
        }
        return a;
    }

    //洗牌算法：未规定牌不能出现在原来的地方
    public static void xipai(){
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        ArrayList<Integer> a1 = new ArrayList<>();
        for(int i =0; i < a.length; i++){
            a1.add(a[i]);
        }
        //洗牌之后的数组
        ArrayList<Integer> arrayList = new ArrayList<>();
        int count = a1.size();
        while(count > 0){
            Random r = new Random();
            int index = r.nextInt(count);
            arrayList.add(a1.get(index));
            a1.remove(index);
            count = a1.size();
        }
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i)+" ");
        }
    }

    //寻找第K大的数
    public static void findKMax(int[] a, int l, int r, int k){
        if(l < r){
            int index = partBigFirst(a, l, r);
            if(index == k){
                System.out.println(a[k]);
            }else if(index > k){
                findKMax(a, l, index-1, k);
            }else{
                findKMax(a, index+1, r, k);
            }
        }else {
            System.out.println(a[l]);
        }
    }

    public static int partBigFirst(int[] a, int l, int r){
        int pivot = a[l];
        int i = l;
        for(int j = l+1; j <= r; j++){
            if(a[j] > pivot){
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i];
        a[i] = a[l];
        a[l] = t;
        return i;
    }

    public static void sumIsM(){
        int[] a = {2,33,4,5,7,9,12};
        int m = 12;
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[j] < a[i]){
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        for(int i = 0; i < a.length; i++){
            int sum = 0;
            ArrayList<Integer> arrayList = new ArrayList<>();
            if(a[i] == m){
                System.out.println(a[i]);
            }else if(a[i] > m){
                break;
            }else{
                sum += a[i];
                arrayList.add(a[i]);
                for(int j = i+1; j < a.length; j++){
                    if(a[j] + sum == m){
                        arrayList.add(a[j]);
                        for(int k = 0; k < arrayList.size(); k++){
                            System.out.print(arrayList.get(k)+" ");
                        }
                        System.out.println();
                        arrayList.clear();
                        break;
                    }else if(a[j] + sum > m){
                        arrayList.clear();
                        break;
                    }else {
                        arrayList.add(a[j]);
                        sum += a[j];
                    }
                }
            }
        }
    }

    //快排
    public static void quickSort(int[] a, int p, int q){
        if(p < q){
            int r = patition(a, p, q);
            quickSort(a, p, r-1);
            quickSort(a, r+1, q);
        }
    }

    public static int patition(int[] a, int p, int q){
        int pviot = a[p];
        int i = p;
        for(int j = i+1; j <= q; j++){
            if(a[j] < pviot){
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i];
        a[i] = pviot;
        a[p] = t;
        return i;
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