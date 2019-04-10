import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

    //疯狂队列 通过10%
    public void crazyQuery(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //将从控制台读取的数字存放在h中
        int[] h = new int[n];
        for(int i = 0; i < n; i++){
            h[i] = sc.nextInt();
        }
        //将站好的疯狂队列存在a中
        ArrayList<Integer> a = new ArrayList<>();
        a.add(h[0]);
        //i代表站队已经站好的人数
        for(int i = 1; i < n; i++){
            int maxMinus = 0;
            int index = 0;
            for(int j = 0; j < n; j++){
                if(h[j] != 0){
                    int minus = Math.abs(h[j] - a.get(i-1));
                    if(minus > maxMinus){
                        maxMinus = minus;
                        index = j;
                    }
                }
            }
            a.add(h[index]);
            h[index] = 0;
        }

        int res = 0;
        for(int i = 0; i+1 < n; i++){
            res += Math.abs(a.get(i+1) - a.get(i));
        }
        System.out.println(res);
    }
}
