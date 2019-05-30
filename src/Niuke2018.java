import java.util.*;

public class Niuke2018 {

    //拼多多 最大乘积
    public void MaxMutiply(){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        long[] nums = new long[len];
        for(int i = 0; i < nums.length; i++){
            nums[i] = sc.nextInt();
        }
        //找出两个最小值和三个最大值
        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] > max3){
                max3 = nums[i];
            }
            if(nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i] < min2){
                min2 = nums[i];
            }
        }
        long res = 0;
        res = Math.max(max1 * max2 * max3, min1 * min2 * max1);
        System.out.println(res);
    }
    //2018 拼多多 大整数相乘
    public void hugeIntMutiply(){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextBigDecimal().toString();
        String s2 = sc.nextBigDecimal().toString();
        int[] res = new int[s1.length() + s2.length()];
        for(int i = s1.length()-1; i >= 0; i--){
            int x = s1.charAt(i)-'0';
            for(int j = s2.length()-1; j >= 0; j--){
                int y = s2.charAt(j)-'0';
                res[i+j] += (res[i+j+1]+x*y)/10;
                res[i+j+1] = (res[i+j+1]+x*y)%10;
            }
        }
        String r = "";
        for(int i = 0; i < res.length; i++){
            if(i == 0 && res[i] == 0){
                continue;
            }
            r += res[i];
        }
        System.out.print(r);
    }

    // 六一儿童节
    public void holiday61(){
        Scanner sc = new Scanner(System.in);
        int sduNum = sc.nextInt();
        int[] h = new int[sduNum];
        for(int i = 0; i < sduNum; i++){
            h[i] = sc.nextInt();
        }
        int choNum = sc.nextInt();
        int[] w = new int[choNum];
        for(int i = 0; i < choNum; i++){
            w[i] = sc.nextInt();
        }
        //给数组w排序
        w = sort(w);
        h = sort(h);
        int count = 0;
        int i = w.length - 1;
        int j = h.length - 1;
        while(i >= 0 && j >= 0){
            if(w[i] >= h[j]){
                count ++;
                i--;
                j--;
            }else{
                j--;
            }
        }
        System.out.println(count);
    }
    public int[] sort(int[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i; j < a.length; j++){
                if(a[j] < a[i]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        return a;
    }

    // 网易 彩色的砖块
    public void colorsBrick(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
        if(map.size() > 2){
            System.out.println(0);
        }else if(map.size() == 2){
            System.out.println(2);
        }else if(map.size() == 1){
            System.out.println(1);
        }else if(map.size() == 0){
            System.out.println(0);
        }
    }

    // 网易 等差数列
    public void euqalDiffrenceNums(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(nums[j] < nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        int d = nums[1] - nums[0];
        int count = 1;
        for(int i = 1; i+1 < n; i++){
            if(nums[i+1] - nums[i] != d){
                break;
            }else{
                count++;
            }
        }
        if(count == n-1){
            System.out.println("Possible");
        }else{
            System.out.println("Impossible");
        }
    }

    //网易 01交错串
    public void stringwith01(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.length() == 1){
            System.out.println(1);
            return;
        }
        if(str == null){
            System.out.println(0);
            return;
        }
        int count = 1;
        int max = 1;
        for(int i = 0; i+1 < str.length(); i++){
            if(str.charAt(i) != str.charAt(i+1)){
                count ++;
            }else{
                if(count > max){
                    max = count;
                }
                count = 1;
            }
            if(i+1 == str.length()-1){
                if(count > max){
                    max = count;
                }
            }
        }
        System.out.println(max);
    }
    //网易 操作序列
    public void operateList(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        ArrayList<Integer> b = new ArrayList<>();
        if(n % 2 == 1){
            for(int i = n-1; i >= 0; i--){
                if(i%2 == 0){
                    b.add(nums[i]);
                }
            }
            for(int i = 0; i <= n-1; i++){
                if(i % 2 == 1){
                    b.add(nums[i]);
                }
            }
        }else if(n % 2 == 0){
            for(int i = n-1; i >= 0; i--){
                if(i % 2 == 1){
                    b.add(nums[i]);
                }
            }
            for(int i = 0; i <= n-1; i++){
                if(i % 2 == 0){
                    b.add(nums[i]);
                }
            }
        }
        //打印
        for(int i = 0; i < n-1; i++){
            System.out.print(b.get(i) + " ");
        }
        System.out.print(b.get(n-1));
    }
    //网易 独立生存
    public void livingByOwn(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int count = 0;
        if(d > f*x){
            count = f;
            d -= f*x;
            count += d/(x+p);
        }else{
            count = d/x;
        }
        System.out.println(count);
    }

    //循环数比较大小 100%
    public void loopNumber(){
        Scanner sc = new Scanner(System.in);
        String x1 = sc.next();
        int k1 = sc.nextInt();
        String x2 = sc.next();
        int k2 = sc.nextInt();
        String res1 = "";
        String res2 = "";
        int size1 = x1.length()*k1;
        int size2 = x2.length()*k2;
        if(size1 > size2){
            System.out.println("Greater");
            return;
        }else if(size1 < size2){
            System.out.println("Less");
            return;
        }else{
            int size = x1.length() * k1;
            for(int i = 0; i < k1; i++){
                res1 += x1;
            }
            for(int i = 0; i < k2; i++){
                res2 += x2;
            }
            for(int i = 0; i < size; i++){
                int v1 = (int)res1.charAt(i);
                int v2 = (int)res2.charAt(i);
                if(v1 > v2){
                    System.out.println("Greater");
                    return;
                }
                if(v1 < v2){
                    System.out.println("Less");
                    return;
                }

            }
            System.out.println("Equal");
            return;
        }
    }
    //DNA序列
    public void DNA(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.length() < 4){
            System.out.println(1);
            return;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i), map1.get(s.charAt(i))+1);
            }else{
                map1.put(s.charAt(i), 1);
            }
        }
        if(map1.size() < 4){
            System.out.println(1);
            return;
        }
        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i = 0; i+1 < s.length(); i++){
            String temp = String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1));
            if(map2.containsKey(temp)){
                map2.put(temp, map2.get(temp)+1);
            }else{
                map2.put(temp, 1);
            }
        }
        if(map2.size() < 16){
            System.out.println(2);
            return;
        }
        HashMap<String, Integer> map3 = new HashMap<>();
        for(int i = 0; i+2 < s.length(); i++){
            String temp = String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1))
                    +String.valueOf(s.charAt(i+2));
            if(map3.containsKey(temp)){
                map3.put(temp, map3.get(temp)+1);
            }else{
                map3.put(temp, 1);
            }
        }
        if(map3.size() < 64){
            System.out.println(3);
            return;
        }
        HashMap<String, Integer> map4 = new HashMap<>();
        for(int i = 0; i+3 < s.length(); i++){
            String temp = String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1))
                    +String.valueOf(s.charAt(i+2))+String.valueOf(s.charAt(i+3));
            if(map4.containsKey(temp)){
                map4.put(temp, map4.get(temp)+1);
            }else{
                map4.put(temp, 1);
            }
        }
        if(map4.size() < 256){
            System.out.println(4);
            return;
        }
        HashMap<String, Integer> map5 = new HashMap<>();
        for(int i = 0; i+4 < s.length(); i++){
            String temp = String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1))
                    +String.valueOf(s.charAt(i+2))+String.valueOf(s.charAt(i+3))
                    +String.valueOf(s.charAt(i+4));
            if(map5.containsKey(temp)){
                map5.put(temp, map5.get(temp)+1);
            }else{
                map5.put(temp, 1);
            }
        }
        if(map5.size() < 256*4){
            System.out.println(5);
            return;
        }
        System.out.println(6);
    }

    //求猜做判断题的最大得分
    public void maxScore(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int a = sc.nextInt();
        int score1 = 0; // 猜对的为“正确”的题目
        int score2 = 0; // 猜对的为“错误”的题目
        if(t == a){
            System.out.println(n);
            return;
        }
        if(t > a){
            score1 = a;
            int actWrong = n - a;//实际答案为“错误”的题目数量
            score2 = actWrong - (t - a);
            System.out.println(score1 + score2);
            return;
        }
        if(t < a){
            score1 = t;
            int actWrong = n - a;
            score2 = actWrong;
            System.out.println(score1 + score2);
            return;
        }
    }

    //去掉重复的字符
    public void deleteRepeatLetters(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] letters = new int[26];
        for(int i = 0; i < 26; i++){
            letters[i] = -1;
        }
        String res = "";
        for(int i = 0; i < str.length(); i++){
            if(letters[str.charAt(i) - 97] == -1){
                letters[str.charAt(i) - 97] = i;
                res += String.valueOf(str.charAt(i));
            }
        }
        System.out.println(res);
    }

    //空中飞行
    public void flyInSky(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] f = new int[n];
        for(int i = 0; i < n; i++){
            f[i] = sc.nextInt();
        }

        int i = 0;
        int count = 0;
        while(s > 0 && i < n){
            if(s >= f[i]){
                count ++;
                s -= f[i];
                i++;
            }else{
                break;
            }
        }
        System.out.println(count);
    }

    //回文素数 值得注意的是0和1要单独讨论，更值得注意的是1不是素数
    public void huiWenSushu(){
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        if(l > r){
            System.out.println(0);
            return;
        }
        for(int i = l; i <= r; i++){
            if(isSu(i) && isHuiWen(i)){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean isSu(int n){
        if(n == 0 || n == 1){
            return false;
        }
        for(int i = 2; i < n; i++){
            if(i != n && n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isHuiWen(int n){
        String str = String.valueOf(n);
        if(str.length() == 1){
            return true;
        }
        String temp = "";
        for(int i = str.length()-1; i >= 0; i--){
            temp += str.charAt(i);
        }
        int res = Integer.parseInt(temp);
        if(n == res){
            return true;
        }else{
            return false;
        }
    }

    //将序列排序为非严格升序，问最少需要多少移位
    public void sort(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] tp = new int[n];
        for(int i = 0; i < n; i++){
            int t = sc.nextInt();
            nums[i] = t;
            tp[i] = t;
        }

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != tp[i]){
                count++;
            }
        }
        System.out.println(count);
    }

    // 字符串的价值
    public void valueOfString(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        Iterator it = map.values().iterator();
        while(it.hasNext()){
            list.add(Integer.parseInt(it.next().toString()));
        }
        int[] l = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            l[i] = list.get(i);
        }
        l = sort1(l);
        for(int i = 0; i < k; i++){
            l[0] = l[0] - 1;
            l = sort1(l);
        }
        int res = 0;
        for(int i = 0; i < l.length; i++){
            res += l[i] * l[i];
        }
        System.out.println(res);
    }
    public int[] sort1(int[] l){
        for(int i = 0; i < l.length; i++){
            for(int j = i; j < l.length; j++){
                if(l[j] > l[i]){
                    int t = l[j];
                    l[j] = l[i];
                    l[i] = t;
                }
            }
        }
        return l;
    }
    //拼凑正方形 最长的边-最短的边 + 第二长的边-第二短的边
    public void makeSquare(){
        Scanner sc = new Scanner(System.in);
        int[] t = new int[4];
        for(int i = 0; i < 4; i++){
            t[i] = sc.nextInt();
        }
        t = sort1(t);
        int res = t[0] - t[3] + t[1] - t[2];
        System.out.println(res);
    }
    // 区间表达
    public void qujian(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int count = 1;
        for(int i = 0; i+1 < n; i++){
            if(nums[i]+1 < nums[i+1]){
                count++;
            }
        }
        System.out.println(count);
    }

    //数字游戏
    public void numsPlay(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int[] reverseNums = new int[n];
        for(int i = 0; i < n; i++){
            String s = String.valueOf(nums[i]);
            String temp = "";
            s = sortString(s);
            if(s.charAt(s.length()-1) == '0'){
                temp = s.substring(1, s.length());
            }else{
                temp = s;
            }
            reverseNums[i] = Integer.parseInt(temp);
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            if(reverseNums[i] > max){
                max = reverseNums[i];
            }
        }
        System.out.println(max);
    }
    public String sortString(String s){
        String temp = "";
        int nums[] = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            nums[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        for(int i = 0; i < nums.length; i++){
            temp += nums[i] + "";
        }
        return temp;
    }

    //红和绿
    public void redAndGreen(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int min = s.length();
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            for(int j = 0; j < i; j++){
                if(s.charAt(j) != 'R'){
                    count++;
                }
            }
            for(int j = i+1; j < s.length(); j++){
                if(s.charAt(j) != 'G'){
                    count++;
                }
            }
            min = Math.min(count,min);
        }
        System.out.println(min);
    }

    //形成三角形
    public void createTriangle(){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        nums[0] = sc.nextInt();
        nums[1] = sc.nextInt();
        nums[2] = sc.nextInt();
        for(int i = 0; i < 3; i++){
            for(int j = i; j < 3; j++){
                if(nums[i] > nums[j]){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if(c - b < a && c - a < b){
            System.out.println(a + b + c);
            return;
        }
        c = c - (c - (a + b) + 1);
        System.out.println(a + b + c);
        return;
    }

    public void recycleNums(){
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int k1 = sc.nextInt();
        int x2 = sc.nextInt();
        int k2 = sc.nextInt();
        int l1 = String.valueOf(x1).length() * k1;
        int l2 = String.valueOf(x2).length() * k2;
        if(l1 < l2){
            System.out.println("Less");
            return;
        }else if(l1 > l2){
            System.out.println("Greater");
            return;
        }
        String s1 = "";
        for(int i = 0; i < l1; i++){
            s1 += x1+"";
        }
        String s2 = "";
        for(int i = 0; i < l2; i++){
            s2 += x2+"";
        }
        for(int i = 0; i < l1; i++){
            if((int)s1.charAt(i) < (int)s2.charAt(i)){
                System.out.println("Less");
                return;
            }else if((int)s1.charAt(i) > (int)s2.charAt(i)){
                System.out.println("Greater");
                return;
            }
        }
        System.out.println("Equal");
    }

    public void eatingGrass(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int nums[] = new int[t];
        for(int i = 0; i < t; i++){
            nums[i] = sc.nextInt();
        }
        for(int i = 0; i < t; i++){
            System.out.println(winner(nums[i]));
        }
    }
    public String winner(int num){
        String s = "";
        if(num % 5 == 1 || num % 5 == 3 || num % 5 == 4){
            s = "niu";
        }else if(num % 5 == 2 || num % 5 == 0){
            s = "yang";
        }
        return s;
    }

    /**
     * 最长公共子串 动态规划
     * dp[i][j] 存放的是以s1[i],s2[j]结尾的两个子串的最长公共子串的长度
     */
    public void maxSameSubString(){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 == 0 || l2 == 0){
            System.out.println(0);
            return;
        }
        int max = 0;
        int[][] dp = new int[l1][l2];
        for(int i = 0; i < l1; i ++){
            for(int j =0 ; j < l2; j ++){
                dp[i][j] = 0;
            }
        }
        for(int i = 0; i < l1; i++){
            for(int j = 0; j < l2; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
    public ArrayList<Integer> sort(ArrayList<Integer> array){
        for(int i = 0; i < array.size(); i++){
            for(int j = i; j < array.size(); j++){
                if(array.get(i) < array.get(j)){
                    int temp = array.get(i);
                    array.set(i,array.get(j));
                    array.set(j,temp);
                }
            }
        }
        System.out.println(array);
        return array;
    }
    public ArrayList<ArrayList<Integer>> getSubnums(int[] nums){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start = 0;
        int end = -1;
        for(int i = 0; i +1 < nums.length; i++){
            if(nums[i] + 1 == nums[i+1]){
                end = i+1;
            }else{
                ArrayList<Integer> array = new ArrayList<>();
                for(int j = start; j <= end; j++){
                    array.add(nums[j]);
                }
                if(array.size() >= 1){
                    res.add(array);
                }
                start = i + 1;
            }
        }
        ArrayList<Integer> array = new ArrayList<>();
        for(int j = start; j <= end; j++){
            array.add(nums[j]);
        }
        if(array.size() >= 1){
            res.add(array);
        }
        start = 0;
        end = -1;
        for(int i = 0; i + 1 < nums.length; i++){
            if(nums[i] - 1 == nums[i+1]){
                end = i+1;
            }else{
                array = new ArrayList<>();
                for(int j = start; j <= end; j++){
                    array.add(nums[j]);
                }
                if(array.size() >= 1){
                    res.add(array);
                }
                start = i + 1;
            }
        }
        array = new ArrayList<>();
        for(int j = start; j <= end; j++){
            array.add(nums[j]);
        }
        if(array.size() >= 1){
            res.add(array);
        }
//        System.out.println(res);
        return res;
    }

    // 幸运子序列
    public void luckySubSequence(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int maxres = -1;
        for(int i = 0; i < n; i++){
            int m1 = nums[i];
            for(int j = i; j < n; j++){
                if(nums[j] > m1){
                    int m2 = nums[j];
                    maxres = Math.max(m1 ^ m2, maxres);
                    break;
                }
            }
            for(int j = i; j >= 0; j--){
                if(nums[j] > m1){
                    int m2 = nums[j];
                    maxres = Math.max(m1 ^ m2, maxres);
                    break;
                }
            }
        }
        System.out.println(maxres);
    }

    //确实括号的数量
    public void missParentheses(){
        Stack<String> stack = new Stack<>();
        String str = "(()(()";
        int add = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push("(");
            }else if(str.charAt(i) == ')'){
                if(stack.isEmpty()){
                    add++;
                }else {
                    stack.pop();
                }
            }
        }
        add = stack.size() + add;
        System.out.println(add);
    }
    //
    public void lastPosition(){
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long l = 1;
        long r = num;
        while(l+1 < r){
            long mid = (l+r)/2;
            if(getsum(mid) == num){
                System.out.println(mid);
                return;
            }else if(getsum(mid) > num){
                r = mid;
            }else{
                l = mid;
            }
        }
        System.out.println(-1);
    }
    public long getsum(long num){
        long sum = 0;
        while(num != 0){
            sum += num;
            num = num / 10;
        }
        return sum;
    }

    //深度括号匹配
    public void deepkuohaomatch(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<String> stack = new Stack<>();
        int maxdeep = 0;
        int td = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push("(");
                td++;
            }else if(str.charAt(i) == ')'){
                maxdeep = Math.max(maxdeep, td);
                td--;
                stack.pop();
            }
        }
        System.out.println(maxdeep);
    }

    /**
     * 寻找两个子串的最长公共子串
     * @param s1
     * @param s2
     * @return
     */
    public int gonggong(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                dp[i][j] = 0;
            }
        }
        for(int i = 0; i < s1.length(); i ++){
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
