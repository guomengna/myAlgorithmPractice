import com.sun.deploy.util.SyncAccess;
import com.sun.org.apache.xml.internal.security.exceptions.AlgorithmAlreadyRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionLeetcode {
    /**
     * 113
     * 给定一个二叉树和一个目标和，
     * 找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<String> list = pathSumString(root);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);
            List<Integer> digitList = new ArrayList<>();
            //以空格划分字符串
            String[] splited = s.split("\\s+");
            for(int k = 0; k < splited.length; k++){
                digitList.add(Integer.parseInt(splited[k]));
            }
            int total = 0;
            for(int k =0; k < digitList.size(); k++){
                total += digitList.get(k);
            }
            if(total == sum){
                res.add(digitList);
            }
        }
        System.out.println(res);
        return res;
    }
    // 257 变形
    public List<String> pathSumString(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null){
            //退出的条件,已经到达叶子节点
            String s = root.val+"";
            res.add(s);
            return res;
        }
        if(root.left != null){
            List<String> left = pathSumString(root.left);
            for(int i = 0; i < left.size(); i++){
                res.add(root.val+" "+left.get(i));
            }
        }
        if(root.right != null){
            List<String> right = pathSumString(root.right);
            for(int i = 0; i < right.size(); i++){
                res.add(root.val+" "+right.get(i));
            }
        }
        return res;
    }

    public int sumNumbers(TreeNode root) {
        List<String> list = pathSumString1(root);
        int total = 0;
        for(int i = 0; i < list.size(); i++){
            total += Integer.parseInt(list.get(i));
        }
        System.out.println(total);
        return total;
    }
    public List<String> pathSumString1(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null){
            //退出的条件,已经到达叶子节点
            String s = root.val+"";
            res.add(s);
            return res;
        }
        if(root.left != null){
            List<String> left = pathSumString1(root.left);
            for(int i = 0; i < left.size(); i++){
                res.add(root.val+""+left.get(i));
            }
        }
        if(root.right != null){
            List<String> right = pathSumString1(root.right);
            for(int i = 0; i < right.size(); i++){
                res.add(root.val+""+right.get(i));
            }
        }
        return res;
    }

    /**
     * 437
     * @param root
     * @param sum
     * @return
     */
    public int pathSum437(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int res = findSum(root, sum);
        res += pathSum437(root.left, sum);
        res += pathSum437(root.right, sum);

        return res;
    }
    // 以node为根节点，找到一共有多少条路径，其包含node，并且路径的和为num
    public int findSum(TreeNode node, int num){
        if(node == null){
            return 0;
        }
        int res = 0;
        if(node.val == num){
            res += 1;
        }
        res += findSum(node.left, num-node.val);
        res += findSum(node.right, num-node.val);
        return res;
    }

    /**
     * 235
     * 最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == null || q == null){
            return null;
        }
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p , q);
        }
        return root;
    }

    /**
     * 98
     * 验证一棵树是二叉搜索树
     * @param root
     * @return
     */
    private boolean ans = true;
    private TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (pre != null && node.val <= pre.val)
            ans = false;
        pre = node;
        dfs(node.right);
    }

    /**
     * 递归计算斐波那契数列
     * 记忆化搜索
     * 自上而下解决问题
     * @param n
     * @return
     */
    long[] memo;
    public long fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(memo[n] == -1){
            memo[n] = fib(n-1) + fib(n-2);
//            System.out.println("memo " +n +" = "+memo[n]);
        }
        System.out.println("memo " +n +" = "+memo[n]);
        return memo[n];
    }
    public void returnfib(int n){
        long start = System.currentTimeMillis();
        memo = new long[n+1];
        for(int i = 0; i <= n; i++){
            memo[i] = -1;
        }
        fib2(n);
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end - start)+"ms");
    }

    /**
     * 动态规划计算斐波那契数列
     * 自下而上解决问题（先计算小数据，层层向上递推）
     * 性能更优
     * @param n
     * @return
     */
    public long fib2(int n){
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2; i <= n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        System.out.println(memo[n]);
        return memo[n];
    }

    /**
     * 70
     * 爬台阶
     * @param n
     * @return
     */
    int[] memory;
    public int climbStairs(int n) {
        memory = new int[n+1];
        for(int i = 0; i <= n; i++){
            memory[i] = -1;
        }
        return calWays1(n);
    }

    public int calWays(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(memory[n] == -1){
            memory[n] = climbStairs(n-1)+climbStairs(n-2);
        }
        return memory[n];
    }
    public int calWays1(int n){
        memory[0] = 1;
        memory[1] = 1;
        for(int i = 2; i <= n; i++){
            memory[i] = memory[i-1] + memory[i-2];
        }
        return memory[n];
    }

    /**
     * 120
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        // 只需要记录每一层的最小值即可
        int[] dp = new int[triangle.size()+1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
                dp[j] = Math.min(dp[j],dp[j+1]) + curTr.get(j);
            }
        }
        return dp[0];
    }

    /**
     * 343 分割整数，使得分割所得的各个数的乘积最小
     * @param n
     * @return
     */
    int[] memo1;
    public int integerBreak(int n) {
        memo1 = new int[n+1];
        for(int i = 0; i < n+1; i++){
            memo1[i] = -1;
        }
        return breakInteger(n);
    }
    //记忆递归法
    public int breakInteger(int n){
        if(n == 1){
            return 1;
        }
        if(memo1[n] != -1){
            return memo1[n];
        }
        int res = -1;
        for(int i = 1; i < n; i++){
            res = max3(res, i * (n-i), i * breakInteger(n-i));
        }
        memo1[n] = res;
        return res;
    }
    public int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
    //自底向上的动态规划法
    public int breakInteger1(int n){
        int[] memo2 = new int[n+1];
        for(int i = 0; i <= n; i++){
            memo2[i] = -1;
        }
        memo2[1] = 1;
        //memo2[j]代表的是分割j这个数字所得到的最大的乘积
        for(int j = 2; j <= n; j++){
            for(int k = 1; k <= j-1; k++){
                memo2[j] = max3(memo2[j], k*(j-k), k*memo2[j-k]);
            }
        }
        return memo2[n];
    }


    //插入排序
    public void insertSort(){
        int a[] = {3, 1, 5, 7, 2, 4, 9, 6};
        int i, j;
        for(i = 1; i < a.length; i++){
            int temp = a[i];
            for(j = i-1; (j>=0)&&a[j] > temp; j--){
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
        for(int k = 0; k < a.length; k++){
            System.out.println(a[k]);
        }
    }

    //二分排序

    /**
     * 279
     * 给定正整数 n，找到若干个完全平方数
     * （比如 1, 4, 9, 16, ...）使得它们的和等于 n。
     * 你需要让组成和的完全平方数的个数最少。
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if(n == 0){
            return 1;
        }
        int[] results = new int[n+1];
        for(int i = 0; i < results.length; i++){
            results[i] = i;//results数组中存放的是当输入为n时，需要最少多个个平方数相加，初始值都是i个1相加的数目
        }
        results[0] = 0;//此处的n=0时，必须要等于0，否则最后的结果会多出一个。
        results[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j*j <= i; j++){
                results[i] = Math.min(results[i-j*j]+1, results[i]);
            }
            System.out.println("results["+i+"] = "+results[i]);
        }
        System.out.println("输入 "+n+" 的结果是："+results[n]);
        return results[n];
    }

    /**
     * 91 解码
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
        if(s.length() == 1){
            return s.charAt(0) == '0' ? 0 : 1;
        }
        int[] result = new int[s.length()+1];
        if(s.charAt(0) == '0'){
            return 0;
        }
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i <= s.length(); i++){
            if(s.charAt(i-1) == '0'){
                result[i-1] = 0;
            }
            if(s.charAt(i-2) == '0' || Integer.valueOf(s.substring(i-2, i)) > 26){
                result[i-2] = 0;
            }
            result[i] = result[i-1] + result[i-2];
        }
        return result[s.length()];
    }

    /**
     * 61 机器人的不同路径有多少种
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0){
            return 0;
        }
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    res[i][j] = 1;
                }else {
                    res[i][j] = res[i][j-1] + res[i-1][j];
                }
            }
        }
        System.out.println(res[m-1][n-1]);
        return res[m-1][n-1];
    }
    //归并排序
    public int[] mergeSort(int[] a, int low, int high){
        int mid = (low + high)/2;
        if(low < high){
            mergeSort(a, low, mid);
            mergeSort(a,mid+1, high);
            a = merge(a, low, high, mid);
        }
        return a;
    }
    public int[] merge(int a[], int low, int high, int mid){
        int[] temp = new int[a.length];
        int i = low;
        int j = mid + 1;
        int num = 0;
        while (i <= mid && j <= high){
            if(a[i] < a[j]){
                temp[num] = a[i];
                i++;
            }else if(a[i] > a[j]){
                temp[num] = a[j];
                j++;
            }else {
                temp[num] = a[i];
                temp[++num] = a[i];
                i++;
                j++;
            }
            num += 1;
        }
        a = temp;
        return a;
    }

    /**
     * 寻找数组中的支配者，数量超过数组一半的为支配者，否则返回-1；
     * @param a
     * @return
     */
    public int judge(int[] a){
        HashMap<Integer, Integer> res = new HashMap<>();
        for(int i = 0; i < a.length; i++){
            if(res.containsKey(a[i])){
                res.put(a[i], res.get(a[i])+1);
            }else {
                res.put(a[i], 1);
            }
        }
        for(int i = 0; i < a.length; i++){
            if(res.get(a[i]) >= (a.length/2)){
                System.out.println(a[i]);
                return a[i];
            }
        }
        System.out.println("无 "+-1);
        return -1;
    }

    /**
     * 约瑟夫环问题,面试宝典的191页
     */
    public void usaJapa(){
        Boolean usajapa[] = new Boolean[30];
        for(int i = 0; i < usajapa.length; i++){
            usajapa[i] = true;//开始的时候数组中都为true，丢下海的位置改为false
        }
        int leftcount = usajapa.length;
        int count = 0;//记录有多少个人被丢下海
        int index = 0;//记录当前的索引，即当前数到哪个位置了,下次需要从index的下一个位置开始数
        while(leftcount > 15){
//            System.out.println("leftcount = "+leftcount);
            count ++;
            if(count == 9){
                count = 0;
                //如果当前的index位置为false，则index向下顺延，知道找到一个不是false的位置，将其置为false
                while(usajapa[index] == false){
                    index ++;
                }
                usajapa[index] = false;
                leftcount -- ;
            }
            index++;
            if(index == usajapa.length){
                index = 0;
            }
        }
        //存放15个教徒应该站的位置，此15个位置为安全位置，，在每次数9个数的情况下不会被丢下海
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < usajapa.length; i++){
            if(usajapa[i] == true){
                res.add(i);
            }
        }
        System.out.println("res.size = "+res.size());
        System.out.println("教徒所占的位置应该为"+res);
    }
    //小写字母变成大写字母
    public String changeToCap(String a){
        char[] c = a.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(c[i] > 96){
                c[i] = (char)(c[i]-32);
//                System.out.println(c[i]-32);
//                System.out.println("c["+i+"] = "+c[i]);
            }
        }
//        System.out.println(c);
        return String.valueOf(c);
    }
    //比较是否a小于b
    public boolean compString(String a, String b){
        int index = 0;
        String a1 = changeToCap(a);
//        System.out.println("a1 = " + a1);
        String b1 = changeToCap(b);
//        System.out.println("b1 = " + b1);
        while (index < Math.min(a.length(), b.length())){
            if(a1.charAt(index) < b1.charAt(index)){
                System.out.println(true);
                return true;
            }else if(a1.charAt(index) > b1.charAt(index)){
                System.out.println(false);
                return false;
            }else {
                index ++;
            }
        }
        if(a.length() > b.length()){
            System.out.println(false);
            return false;
        }
        System.out.println(true);
        return true;
    }

    public String[] compareStrings(){
        String[] strings = {"Bc", "Ad", "aC", "Hello", "X man", "little"};
        for(int i = 0; i < strings.length; i++){
            for(int j = i+1; j < strings.length; j++){
                if(!compString(strings[i], strings[j])){
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        for(int i = 0; i < strings.length; i++){
            System.out.print(strings[i]+",");
        }
        return strings;
    }


}
