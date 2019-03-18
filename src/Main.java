import com.sun.deploy.util.SyncAccess;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Search search = new Search();
//        int n = 1000000;
//        int[] array = new int[n];
//        for (int i=0;i<n;i++){
//            array[i] = i;
//        }
//        double startTime = System.currentTimeMillis();//开始的时间，以毫秒计
//        for(int j=0;j<n;j++){
//            search.binarySearch(array, n, j);
//        }
//        double endTime = System.currentTimeMillis();//结束的时间，以毫秒计
//        System.out.println("结束："+(endTime-startTime)/1000);
//        int[] a = {3,1,0,3,12};
//        int[] b = {4,5};
//        int[] c = {1,3,12,0,0};
//        int[] d = {1,3,3,5,12};
//        int[] f = {1,2,3,3,3,3};
//        int[] g = {1,2,2,2,2,3,3,3};
//        int[] k = {0,2,1,2,1,0};
//        int[] j = {1};
//        int[] l = null;
//        int[] m = {1,2,3,0,0,0};
//        int[] n = {2,5,6};
//        int[] m1 = {4,5,6,0,0,0};
//        int[] n1 = {1,2,3};
//        solution.moveZeroes(d);
//        solution.removeElement(a, 3);
//        solution.removeDuplicates(d);
//        solution.removeDuplicates(f);
//        solution.removeDuplicates2(b);
//        solution.sortColors(k);
//        solution.merge(c, 3, b, 2);
//        solution.merge(j, 1, l, 0);
//        solution.merge(m1, 3, n1, 3);
//        int[] m2 = {1,2,3,5,6,7,13};
//        solution.twoSum(m2, 11);//返回4,5
//        int[] m3 = {1,3,5,6,7,13};
//        solution.twoSum(m3, 14);//返回1,6
//        solution.minSubArrayLen(7, n);
//        solution.lengthOfLongestSubstring("");
//        solution.findAnagrams("cbaebabacd", "abc");
//        solution.findAnagrams("ccaebabacd", "abc");
//        solution.findAnagrams("abab", "ab");
//        solution.intersection(g, k);
//        int[] n = {4, 9, 5};
//        int[] m1 = {9, 4, 9, 8, 4};
//        int[] n1 = {2, 7, 11, 15};
////        solution.intersect(n, m1);
//        solution.twoSum1(n, 13);
//        solution.twoSum1(n1, 9);
//        int[] a = {1, 2};
//        int[] b = {-2, -1};
//        int[] c = {-1, 2};
//        int[] d = {0, 2};
//        int[] a = {-1,-1};
//        int[] b = {-1,1};
//        int[] c = {-1,1};
//        int[] d = {1,-1};
//        solution.fourSumCount(a, b, c, d);
//        HashMap<String,Integer> hashMap1 =  new HashMap<>();
//        HashMap<String,Integer> hashMap2 =  new HashMap<>();
//        hashMap1.put("str",2);
//        hashMap2.put("str",2);
//        if(hashMap1.equals(hashMap2)){
//            System.out.println("true");
//        }else {
//            System.out.println("false");
//        }
//        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        solution.groupAnagrams1(s);
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        solution.reverseList(l1);
//        ListNode cur = l1;
//        int i = 1;
//        while(cur != null){
//            if(i >= 2 && i <= 4){
//                System.out.println(cur.val);
//
//            }
//            cur = cur.next;
//            i ++;
//        }
//        solution.reverseBetween(l1, 2, 4);
//        ListNode l6 = new ListNode(3);
//        ListNode l7 = new ListNode(5);
//        l6.next = l7;
//        solution.reverseBetween(l6, 1, 1);
//        TreeNode t1 = new TreeNode(3);
//        TreeNode t2 = new TreeNode(9);
//        TreeNode t3 = new TreeNode(20);
//        TreeNode t4 = new TreeNode(15);
//        TreeNode t5 = new TreeNode(7);
//        t1.left = t2;
//        t1.right = t3;
//        t3.left = t4;
//        t3.right = t5;
//        solution.rightSideView(t1);
//        solution.numSquares(4);
//        Queue<Integer> queue = new LinkedList<>();
//        ((LinkedList<Integer>) queue).add(1);
//        ((LinkedList<Integer>) queue).add(2);
//        System.out.println(queue.peek());
//        int[] a = {1,3,1,5};
//        solution.topKFrequent(a,2);
//        solution.getHight(t1);
//        solution.getResult(t1);
//        solution.minDepth(t1);
//        solution.invertTree(t1);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(1);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        solution.isSameTree(node1,node4);
//        solution.isSameTree(t1,t1);
//        solution.countNodes(node1);
//        int a[] = {1,2,3,4};
//        System.out.println(solution.binearySearch(a, 3));
//        int b[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        int c[][] = {{}};
//        solution.Find(7, c);
//        String s = "hello  world";
//        if(String.valueOf(s.charAt(3)).equals(" ")){
//            System.out.println("space");
//        }
//        StringBuffer sb = new StringBuffer(s);
//        solution.replaceSpace(sb);
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;
//        solution.reverseListNode(l1);
//        int[] pre = {1,2,4,7,3,5,6,8};
//        int[] in = {4,7,2,1,5,3,8,6};
//        solution.foundAllRoot(pre, in, 0, 7);
        SolutionLeetcode solutionLeetcode = new SolutionLeetcode();
//        TreeNode t1 = new TreeNode(5);
//        TreeNode t2 = new TreeNode(4);
//        TreeNode t3 = new TreeNode(8);
//        t1.left = t2;
//        t1.right = t3;
//        TreeNode t4 = new TreeNode(11);
//        t2.left = t4;
//        TreeNode t5 = new TreeNode(13);
//        TreeNode t6 = new TreeNode(4);
//        t3.left = t5;
//        t3.right = t6;
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(2);
//        t4.left = t7;
//        t4.right = t8;
//        TreeNode t9 = new TreeNode(5);
//        TreeNode t10 = new TreeNode(1);
//        t6.left = t9;
//        t6.right = t10;
//        solutionLeetcode.pathSum(t1, 22);
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(1);
//        TreeNode t3 = new TreeNode(4);
//        t1.left = t2;
//        t1.right = t3;
//        TreeNode t4 = new TreeNode(3);
//        TreeNode t5 = new TreeNode(6);
//        t3.left = t4;
//        t3.right = t5;
//        solutionLeetcode.isValidBST(t1);
//        solutionLeetcode.returnfib(40);
//        solutionLeetcode.integerBreak(32);
//        solutionLeetcode.insertSort();
//        solutionLeetcode.numSquares(12);
//        solutionLeetcode.uniquePaths(3,2);
//        int[] a = {3, 4, 3, 2, -1, 3, 3, 3};
//        solutionLeetcode.judge(a);
//        solutionLeetcode.compareStrings();
//        solutionLeetcode.compString("Ad", "X man");
////        Scanner in = new Scanner(System.in);
//        String string = "aabbaaabbc";
////        string = in.nextLine();
//        char s = string.charAt(0);
//        double count = 1,d;
//        for(int i = 0; i < string.length(); i++){
//            if(string.charAt(i)<65 || string.charAt(i)>91){
//                System.out.println(0);
//                return;
//            }
//            if(s!=string.charAt(i)){
//                s = string.charAt(i);
//                count ++;
//            }
//        }
//        d = string.length()/count;
//        System.out.println(String.format("%.2f",d));

//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            if(sc.nextDouble()==0){
//                break;
//            }
//            double h = sc.nextDouble();
//            double u = sc.nextDouble();
//            double d = sc.nextDouble();
//            if (h == 0 && u == 0 && d == 0) {
//                System.out.println(0);
//                return;
//            }
//            if(h<=u || u<=d || h<=d){
//                break;
//            }
//            int day = 0;
//            String str = "success on day ";
//            double high = 0;//代表走的高度
//            while (high <= h) {
//                day++;
//                high = high + u;//u表示白天走的路程
//                if (high > h) {
//                    break;
//                }
//                high = high - d;//晚上下滑
//                if (high < 0) {//从这天起一直会在井底，走不出
//                    str = "failure on day ";
//                    break;
//                }
//            }
//            System.out.println(day);

//        Scanner in=new Scanner(System.in);
//        String inputString = in.nextLine();
//        String stringArray[] = inputString.split(" ");
//        int num[] = new int[stringArray.length];
//        for (int i = 0; i < stringArray.length; i++) {
//            num[i] = Integer.parseInt(stringArray[i]);
//        }
//        Map<Integer,Integer> map=new HashMap<>();
//        for(int m=0;m<num.length;m++){
//            if(map.containsKey(num[m])){
//                map.put(num[m],map.get(num[m])+1);
//            }else {
//                map.put(num[m],1);
//            }
//        }
//        int count=0;
//        for (Integer key:map.keySet()){
//            if(map.get(key)==1){
//                count++;
//            }
//        }
//        System.out.println(count);
        TestSolution testSolution = new TestSolution();
        testSolution.eatingFish();

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