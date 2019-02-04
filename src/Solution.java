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
    //438

    /**
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
}
