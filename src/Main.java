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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        solution.reverseListNode(l1);
    }

}
