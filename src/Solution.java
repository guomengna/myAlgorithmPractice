import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.Array;
import java.sql.SQLSyntaxErrorException;
import java.util.*;

public class Solution {
    //283
    public void moveZeroes(int[] nums){
//        int[] zeroArray = new int[array.length];
//        ArrayList zeroArray = new ArrayList();
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]!=0){
//                zeroArray.add(nums[i]);
//            }
//        }
//        for(int j=0;j<zeroArray.size();j++){
//            nums[j] = Integer.parseInt(zeroArray.get(j).toString());
//        }
//        for(int g=zeroArray.size();g<nums.length;g++){
//            nums[g] = 0;
//        }
//        for(int k=0;k<nums.length;k++){
//            System.out.print(nums[k]+" ");
//        }
        //优化
        int k = 0;//nums中[0,k)为非零元素
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(i != k){
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
    //27
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }
        for(int g=0;g<i;g++){
            System.out.print(nums[g]+" ");
        }
        return i;
//        int k = nums.length-1;
//        int size = nums.length;
//        for(int i=0;i<=k;i++){
//            if(nums[i] == val){
//                int temp = nums[i];
//                nums[i] = nums[k];
//                nums[k] = temp;
//                i--;
//                k--;
//                size--;
//            }
//        }

//        System.out.print("size is: "+size);
//        return size;
    }

    //26
    /**
     * 去掉数组中的重复数据，返回数组的长度
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums==null){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        for(int k=0;k<=i;k++){
            System.out.print(nums[k]+" ");
        }
        return i+1;
    }
    //80,数组中可以保留两个重复数字，并返回数组的长度
    public int removeDuplicates2(int[] nums) {
//        if(nums==null){
//            return 0;
//        }
//        int i=0;
//        int flag = 0;
//        for(int j=1;j<nums.length;j++){
//            if(nums[i]==nums[j] & flag == 0){
//                i++;
//                j++;
//                flag=1;
//            }
//            if(nums[i]!=nums[j]){
//                i++;
//                nums[i] = nums[j];
//                flag = 0;
//            }
//
//        }
//        for(int k=0;k<=i;k++){
//            System.out.print(nums[k]+" ");
//        }
//        return i+1;
        if(nums==null){
            return 0;
        }
        int t=0;
        int nullSize = 0;
        for(int i=2;i<nums.length-t;i++){
            if(nums[i] == nums[i-2]){
                t += 1;
                for(int j=i;j<nums.length-t;j++){
                    nums[j] = nums[j+1];
                }
                nullSize += 1;
                i=2;
            }
        }
        System.out.println("数组大小为："+(nums.length-nullSize));
        for(int k=0;k<nums.length-nullSize;k++){
            System.out.print(nums[k]+" ");
        }
       return nums.length-nullSize;
    }
    //75 sort colors
    public void sortColors(int[] nums) {
        //计数排序
//        int[] count = new int[3];
//        for(int i = 0; i < nums.length; i++){
//            if( nums[i] >= 0 && nums[i] <= 2)
//                count[nums[i]]++;
//        }
//        int k = 0;
//        int index = 0;
//        while(k <= 2){
//            for(int j = 0; j < count[k]; j++){
//                nums[index] = k;
//                index++;
//            }
//            k++;
//        }
        //优化
        //三路快排的思路
        int zero = -1; //[0,zero] = 0;
        int two = nums.length; //[two,nums.length-1] = 2;
        for(int i = 0; i < two; ){
            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 2){
                two--;
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
            }else if(nums[i] == 0){
                zero++;
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        for (int i = 0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }

    /**
     * 88,将一个数组中归并到另一个数组中
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = 0; //num1上的指针
        int pointer2 = 0; //num2上的指针
//        int[] result = new int[m+n];
//        for(int i = 0; i < m+n; i++){
//            if(pointer1<m && pointer2<n){
//                if(nums1[pointer1] < nums2[pointer2]){
//                    result[i] = nums1[pointer1];
//                    pointer1++;
//                }else if(nums1[pointer1] > nums2[pointer2]){
//                    result[i] = nums2[pointer2];
//                    pointer2++;
//                }else if(nums1[pointer1] == nums2[pointer2]){
//                    result[i] =  nums1[pointer1];
//                    result[i+1] = nums1[pointer1];
//                    i++;
//                    pointer1++;
//                    pointer2++;
//                }
//            }else if(pointer1==m && pointer2<n){
//                result[i] = nums2[pointer2];
//                pointer2++;
//            }else if(pointer1<m && pointer2==n){
//                result[i] = nums1[pointer1];
//                pointer1++;
//            }
//        }
//        nums1 = result;
        //优化 空间复杂度明显减小，但是时间复杂度没有显著减小
        if(m>0 && n>0){
            while(pointer1 < nums1.length && pointer2 < n){
                if(nums2[pointer2] >= nums1[pointer1]){
                    pointer1++;
                }else if(nums2[pointer2] < nums1[pointer1]){
                    int temp = nums1[pointer1];
                    nums1[pointer1] = nums2[pointer2];
                    nums2[pointer2] = temp;
                }
                if(pointer1==m){
                    nums1[pointer1] = nums2[pointer2];
                    m++;
                    if(pointer2 < n){
                        pointer2++;
                    }
                    pointer1=0;
                }
                if(pointer1 == nums1.length-1){
                    break;
                }
            }
        }else if(n==0 && m>0){
            nums1 = nums1;
        }else if(m==0 && n>0){
            for(int i=0;i<n;i++){
                nums1[i] = nums2[i];
            }
        }else if(n==0 && m>1){
            nums1 = nums1;
        }else{
            nums1 = null;
        }
        for(int j = 0; j < nums1.length; j++){
            System.out.print(nums1[j]+" ");
        }

    }
    //167，寻找加和为target的两个数，并返回他们的索引
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];//存储返回的下标值
//
        //优化，使用对撞指针的思路
        int left = 0;
        int right = numbers.length-1;
        while(left < right){
            if(numbers[left]+numbers[right]==target){
                index[0] = left+1;
                index[1] = right+1;
                break;
            }else if(numbers[left]+numbers[right]<target){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(index[0]+" "+index[1]);
        return index;
    }

    public int binearySearch(int[] nums, int left, int right,int target){
        while(left <= right){//当left与right重合的时候依然是有效的搜索区间
            int mid = left + (right - left)/2; //防止使用加法造成int类型的变量溢出
            if(target == nums[mid]){
                return mid;//直接返回此时的索引值
            }else if(target > nums[mid]){//target的值大于中心值，此时，搜索范围变为[mid+1,right]
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 209. Minimum Size Subarray Sum
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int res = nums.length+1;
        while( l < nums.length){
            if( sum < s && r+1 < nums.length ){
                r++;
                sum += nums[r];
            }else{
                sum -= nums[l];
                l++;
            }
            if( sum >= s ){
                if( res > r - l + 1 ){
                    res = r - l + 1;
                }
            }
        }
        if( res == nums.length+1 ){
            return 0;
        }
        System.out.print(res);
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        int freq[] = new int[256];
        int l = 0;
        int r = -1;
        int res = 0;
        while( l < s.length() ){
            if( r + 1 < s.length() && freq[s.charAt(r+1)] == 0 ){
                System.out.println("(r+1)= "+(r+1)+" s.charAt(r+1)="+s.charAt(r+1));
                freq[s.charAt(r+1)]++;
                r++;
            }else{
                freq[s.charAt(l)]--;
                l++;
            }
            if(res < r-l+1){
                res = r-l+1;
            }
        }
        System.out.print(res);
        return res;
    }
    /**438
     * Find All Anagrams in a String
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> index = new ArrayList<>();
        int[] freqS = new int[26];
        int[] freqP = new int[26];
        int pointSleft = 0;
        int pointSright = 0;
        //p中每个字母的出现频率，只要s中子串的个字母频率等于p中的频率，即为一个目标值
        for(int i = 0; i < p.length(); i++){
            freqP[p.charAt(i)-97]++;
        }
        while(pointSleft < s.length() - p.length() + 1){
            if(pointSright - pointSleft + 1 <= p.length()){
                if(pointSright < s.length() && s.charAt(pointSright)-97 >= 0){
                    freqS[s.charAt(pointSright)-97]++;
                    pointSright++;
                }
            }else if(pointSright - pointSleft + 1 > p.length()){
                if(Arrays.equals(freqP, freqS)){
                    index.add(pointSleft);
                }
                pointSleft++;
                pointSright = pointSleft;
                freqS = new int[26];
            }
        }
        System.out.println("index.size() = "+index.size());
        for(int i = 0; i < index.size(); i++){
            System.out.println(index.get(i));
        }
        return index;
    }

    /**
     * 349,寻找两个数组的公共元素 set的使用方式
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(int j = 0; j < nums2.length; j++){
            if(set1.contains(nums2[j])){
                set2.add(nums2[j]);
            }
        }
        int[] result = new int[set2.size()];
        Iterator iterator = set2.iterator();
        int i = 0;
        while(iterator.hasNext()){
            result[i] = Integer.parseInt(iterator.next().toString());
            System.out.println(result[i]);
            i++;
        }
        return result;
    }

    /**
     * 350，寻找两个数组中的公共元素，允许重复出现，map的用法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            if(hashMap1.containsKey(nums1[i])){
                hashMap1.put(nums1[i], hashMap1.get(nums1[i]) + 1);
            }else {
                hashMap1.put(nums1[i], 1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++){
            if(hashMap1.get(nums2[i]) != null && hashMap1.get(nums2[i]) > 0){
                arrayList.add(nums2[i]);
                int tem = hashMap1.get(nums2[i])-1;
                hashMap1.put(nums2[i], tem);
            }
        }
        int[] result = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++){
            result[i] = arrayList.get(i);
            System.out.println(result[i]);
        }
        System.out.println(hashMap1.get(null));
        return result;
    }

    /**
     * 1
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(hashMap.containsKey(temp)){
                result[1] = i;
                result[0] = hashMap.get(temp);
                System.out.println(result[0]+" "+result[1]);
                return result;
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }

    /**
     * 454
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(hashMap.containsKey(A[i] + B[j])){
                    hashMap.put((A[i] + B[j]), hashMap.get(A[i] + B[j])+1);
                }else {
                    hashMap.put((A[i] + B[j]), 1);
                }
            }
        }
        int result = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                if(hashMap.get(0 - C[i] - D[j]) != null && hashMap.get(0 - C[i] - D[j]) > 0){
                    result += hashMap.get(0 - C[i] - D[j]);
                }
            }
        }
        System.out.println(result);
        return result;
    }

    /**
     * 49
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        ArrayList<String> tempArraylist = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            tempArraylist.add(strs[i]);
        }
        for(int i = 0; i < tempArraylist.size(); i++){
            List<String> list1 = new ArrayList<>();
            list1.add(tempArraylist.get(i));
            for(int j = i+1; j < tempArraylist.size(); j++){
                System.out.println("tempArraylist.get(i) = "+tempArraylist.get(i)+
                        " tempArraylist.get(j) = "+tempArraylist.get(j));
                if(StringIsEquals(tempArraylist.get(i), tempArraylist.get(j))){
                    System.out.println("tempArraylist.get(i) = tempArraylist.get(j)");
                    list1.add(tempArraylist.get(j));
                    tempArraylist.remove(j);
                    j -= 1;
                    System.out.println("tempArraylist = "+tempArraylist);
                }
            }
            resultList.add(list1);
            System.out.println(list1);
        }
        System.out.println(resultList);
        return resultList;
    }

    public boolean StringIsEquals(String str1, String str2){
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for(int i = 0; i < str1.length(); i++){
            int num = str1.charAt(i);
            if(hashMap1.get(num) != null && hashMap1.get(num) > 0 ){
                hashMap1.put(num, hashMap1.get(num) + 1);
            }else {
                hashMap1.put(num, 1);
            }
        }
        for(int i = 0; i < str2.length(); i++){
            int num = str2.charAt(i);
            if(hashMap2.get(num) != null && hashMap2.get(num) > 0){
                hashMap2.put(num, hashMap2.get(num) + 1);
            }else {
                hashMap2.put(num, 1);
            }
        }
        if(hashMap1.equals(hashMap2)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 49 优化
     * 用到了字符数组的排序，首先将所有的字符串转为字符数组，
     * 再对所有的字符数组进行排序，再转为字符串
     * 由此，所有的字符串都变为相同的
     * hashmap里存放的是<String, List>,
     * 分别表示排序之后的到的字符串、与此字符串相同的字符串原来的样子</>
     * 输出的时候只需要将hashmap中的所有values组成的list取出，放进list中，即可构成List<List<String>>的形式</>
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List> hashMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            System.out.println("key = "+key);
            if(hashMap.containsKey(key)){
                System.out.println("hashMap.containsKey("+key+")");
                hashMap.get(key).add(strs[i]);
            }else {
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                hashMap.put(key, l);
            }
        }
        List<List<String>> result = new ArrayList<>();
        result = new ArrayList(hashMap.values());
        System.out.println(result);
        return result;
    }


    /**
     * 206 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while( cur != null ){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode t = pre;
        while(t != null){
            System.out.println(t.val);
            t = t.next;
        }
        return pre;
    }

    /**
     * 92
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        if(m == n){
            return head;
        }
        ListNode cur = head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(cur != null){
            arrayList.add(cur.val);
            cur = cur.next;
        }
        int l = m-1;
        int r = n-1;
        while(l <= r ){
            int tem = arrayList.get(l);
            arrayList.set(l, arrayList.get(r));
            arrayList.set(r, tem);
            l++;
            r--;
        }
        ListNode newHead = createList(arrayList);
        return newHead;
    }
    public ListNode createList(ArrayList<Integer> a){
        ListNode head = new ListNode(a.get(0));
        ListNode cur = head;
        for(int i = 1; i < a.size(); i++){
            cur.next = new ListNode(a.get(i));
            cur = cur.next;
        }
        return head;
    }

    /**
     * 102
     * @param root
     * @return
     */
    public int levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if( root == null ){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue).add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int count = queue.size();
            while(count > 0){
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if( treeNode.left != null ){
                    ((LinkedList<TreeNode>) queue).add(treeNode.left);
                }
                if(treeNode.right != null){
                    ((LinkedList<TreeNode>) queue).add(treeNode.right);
                }
                count--;
            }
            result.add(temp);
        }
        int high = result.size();
        System.out.println(high);
        return high;
    }

    /**
     * 107 自底向上返回二叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if( root == null ){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue).add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int count = queue.size();
            while(count > 0){
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if( treeNode.left != null ){
                    ((LinkedList<TreeNode>) queue).add(treeNode.left);
                }
                if(treeNode.right != null){
                    ((LinkedList<TreeNode>) queue).add(treeNode.right);
                }
                count--;
            }
            result.add(temp);
        }
        System.out.println(result+" "+result.size());
        List<List<Integer>> result1 = new ArrayList<>();
        for(int i = result.size()-1; i >= 0; i--){
            System.out.println("i = "+i);
            result1.add(result.get(i));
        }
        System.out.println(result1);
        return result1;
    }

    /**
     * 103 “之”字形打印二叉树
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if( root == null ){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue).add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int count = queue.size();
            while(count > 0){
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if( treeNode.left != null ){
                    ((LinkedList<TreeNode>) queue).add(treeNode.left);
                }
                if(treeNode.right != null){
                    ((LinkedList<TreeNode>) queue).add(treeNode.right);
                }
                count--;
            }
            result.add(temp);
        }
        int cou = 1;
        for(int i = 0; i < result.size(); i++){
            if(cou % 2 == 0){
                List<Integer> list = result.get(i);
                int l = 0;
                int r = list.size()-1;
                while(l < r){
                    int temp = list.get(l);
                    list.set(l, list.get(r));
                    list.set(r, temp);
                    l++;
                    r--;
                }
                result.set(i, list);
            }
            cou ++;
        }
        System.out.println(result);
        return result;
    }

    /**
     * 199 二叉树的右视图 层次遍历 每次只保留每层最后一个节点
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if( root == null ){
            return result;
        }
        List<List<Integer>> resultTemp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue).add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int count = queue.size();
            while(count > 0){
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if( treeNode.left != null ){
                    ((LinkedList<TreeNode>) queue).add(treeNode.left);
                }
                if(treeNode.right != null){
                    ((LinkedList<TreeNode>) queue).add(treeNode.right);
                }
                count--;
            }
            resultTemp.add(temp);
        }
        for(int i = 0; i < resultTemp.size(); i++){
            List<Integer> r = resultTemp.get(i);
            result.add(r.get(r.size()-1));
        }
        System.out.println(result);
        return result;
    }

    /**
     * 279 完全平方数 不正确
     * @param n
     * @return
     */
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();

        ((LinkedList<Integer>) queue).add(n);
        int step = 0;
        while(!queue.isEmpty()){
            int num = queue.peek();
            queue.poll();
            if(num == 0){
                System.out.println("step = "+step);
                return step;
            }
            for(int i = 1; num - i*i >= 0; i++){
                int t = num - i*i;
                ((LinkedList<Integer>) queue).add(t);
                step += 1;
            }
        }
        return -1;
    }

    /**
     * 优先队列 347
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], hashMap.get(nums[i])+1);
            }else {
                hashMap.put(nums[i], 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        if(k > hashMap.size()){
            return res;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> hashMap.get(a) - hashMap.get(b));
        for(int key : hashMap.keySet()){
            if(priorityQueue.size() < k){
                priorityQueue.add(key);
            }else if(hashMap.get(key) > hashMap.get(priorityQueue.peek())){
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        while (!priorityQueue.isEmpty()){
            res.add(priorityQueue.remove());
        }
        System.out.println(res);
        return res;
    }
    //柠檬微趣测试题三道
    //1、获得二叉树的高度
    public int getHight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHight(root.left), getHight(root.right))+1;
    }
    //2、找出两个相同整数的最远距离
    public int getDistance(int[] nums){
        HashMap<Integer,List<Integer>> hashMap = new LinkedHashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                List temp = hashMap.get(nums[i]);
                temp.add(i);
                hashMap.put(nums[i], temp);
                System.out.println( hashMap.get(nums[i]));
            }else {
                hashMap.put(nums[i], new ArrayList<>());
            }
        }
        int res = 0;
        for(int key : hashMap.keySet()){
            List list = new ArrayList();
            list = hashMap.get(key);
            System.out.println(list);
            if(list.size() > 0){

                for(int i = 0; i < list.size(); i++){
                    for(int j = i+1; j < list.size(); j++){
                        int t = Integer.parseInt(list.get(i).toString()) -
                                Integer.parseInt(list.get(j).toString());
                        res = Math.max(t, res);
                    }
                }
            }
        }
//        System.out.println(res+1);
        return res;
    }

    //3、二叉树的最浅叶节点的和
    public int getResult(TreeNode root){
        List<Integer> leaf = new ArrayList<>();
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue).add(root);
        int high = -1;
        while(!queue.isEmpty() && high == -1){
            int count = queue.size();
            while(count > 0){
                TreeNode t = queue.poll();
                if(t.left == null && t.right == null){
                    high = count;
                    leaf.add(t.val);
                }
                if (t.left != null){
                    ((LinkedList<TreeNode>) queue).add(t.left);
                }
                if(t.right != null){
                    ((LinkedList<TreeNode>) queue).add(t.right);
                }
                count--;
            }
        }
        int res = 0;
        for(int i = 0; i <leaf.size(); i++){
            res += Integer.parseInt(leaf.get(i).toString());
        }
        return res;
    }

    /**
     *  104 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    /**
     * 111 最小二叉树的高度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left != null && root.right != null){
//            System.out.println(Math.min(minDepth(root.left), minDepth(root.right))+1);
            return Math.min(minDepth(root.left), minDepth(root.right))+1;
        }else if(root.left != null){
//            System.out.println(minDepth(root.left)+1);
            return minDepth(root.left)+1;
        }else if(root.right != null){
//            System.out.println(minDepth(root.right)+1);
            return minDepth(root.right)+1;
        }else {
//            System.out.println(1);
            return 1;
        }
    }

    /**
     * 翻转二叉树 226
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    /**
     * 100 判断二叉树是否相同
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null ){
            System.out.println("p and q = null");
            return true;
        }
        if(p != null && q != null){
            if(p.val == q.val){
                System.out.println("p.val = "+p.val+" , q.val = "+p.val);
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
        return false;
    }

    /**
     * 101 一棵二叉树是否是镜像对称的
     * 递归解法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }else if(t1 == null || t2 == null){
            return false;
        }else if(t1.val == t2.val){
            return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        }else {
            return false;
        }
    }

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }

    /**
     * 110 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if ((getHigh(root.left) - getHigh(root.right)) > 1 ||
                (getHigh(root.right) - getHigh(root.left)) > 1){
            return false;
        }else {
            return isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    public int getHigh(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHigh(root.left), getHigh(root.right))+1;
    }
}

