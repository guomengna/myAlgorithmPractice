import java.util.Arrays;
import java.util.HashMap;

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
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        solution.groupAnagrams1(s);

    }
}
