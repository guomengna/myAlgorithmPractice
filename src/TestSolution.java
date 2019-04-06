import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class TestSolution {
    //输出字符串的子串，重复的字母的个数及字母
    //aabbcccbb 输出2a,2b,3c
    public void getSubString() {
        String s = "aabbcccbbb";
        char[] c = s.toCharArray();
        int count = 1;
        HashSet<String> hashSet = new HashSet<>();
        String temp = String.valueOf(c[0]);
        for (int i = 1; i < s.length(); i++) {
            if (String.valueOf(c[i]).equals(temp)) {
                count++;
            } else {
                hashSet.add(count + "" + temp);
                temp = String.valueOf(c[i]);
                count = 1;
            }
        }
        hashSet.add(count + "" + temp);
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //青蛙爬井的问题
    public void fog() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            double h = sc.nextDouble();
            if (h == 0) {
                System.out.println("输入结束");
                break;
            }
            double u = sc.nextDouble();
            double d = sc.nextDouble();
            System.out.println("h = " + h + " u = " + u + " d = " + d);
            if (h == 0 && u == 0 && d == 0) {
                System.out.println(0);
                return;
            }
            if (h <= u || u <= d || h <= d) {
                break;
            }
            int day = 0;
            double high = 0;//代表走的高度
            while (high < h) {
                day++;
                high = high + u;//u表示白天走的路程
                if (high >= h) {
                    break;
                }
                high = high - d;//晚上下滑
                if (high < 0) {//从这天起一直会在井底，走不出
                    break;
                }
            }
            System.out.println(day);
        }
    }

    //计算有多少个不重复的数字
    public void unrepeatNum() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] temp = s.split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            if (hashMap.containsKey(temp[i])) {
                hashMap.put(temp[i], hashMap.get(temp[i]) + 1);
            } else {
                hashMap.put(temp[i], 1);
            }
        }
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String t = iterator.next();
            if (hashMap.get(t) == 1) {
                System.out.println(t);
            }
        }
    }

    //大鱼吃小鱼游戏
    public void eatingFish() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Scanner sc1 = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nums.add(sc1.nextInt());
        }
        eating(nums);
    }

    public int eating(ArrayList<Integer> nums) {
        if (nums.size() == 1) {
            System.out.println("nums.get(0) = " + Math.abs(nums.get(0)));
            return Math.abs(nums.get(0));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                //i的左右都有值
                if (i >= 1 && i < nums.size() - 1) {
                    //向右吃
                    ArrayList right = nums;
                    right.set(i, nums.get(i) - nums.get(i + 1));
                    right.remove(i + 1);
                    //向左吃
                    ArrayList left = nums;
                    left.set(i, nums.get(i) - nums.get(i - 1));
                    left.remove(i - 1);
                    i--;
//                    System.out.println(Math.max(eating(left), eating(right)));
                    return Math.abs(Math.max(eating(left), eating(right)));
                }
                if (i == 0) {//i的右边有值，左边没有值
                    //向右吃
                    ArrayList right = nums;
                    right.set(i, nums.get(i) - nums.get(i + 1));
                    right.remove(i + 1);
//                    System.out.println(Math.abs(eating(right)));
                    return Math.abs(eating(right));
                }
                if (i == nums.size() - 1) {//i的左边有值，右边没有值
                    //向左吃
                    ArrayList left = nums;
                    left.set(i, nums.get(i) - nums.get(i - 1));
                    left.remove(i - 1);
//                    System.out.println(Math.abs(eating(left)));
                    return Math.abs(eating(left));
                }
            }
        }
        System.out.println(-1000);
        return -1000;
    }

    public void sort(int[] array, int len) {
        // 完成这个函数
        for (int i = 1; i < array.length; i++) {
            if (array[i] != i) {
                if (array[i] != 0) {
                    swapWithZero(array, array.length, array[i]);
                }
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == i) {
                        swapWithZero(array, array.length, array[j]);
                        break;
                    }
                }
            }
        }

    }

    public void swapWithZero(int[] array, int len, int n) {

    }

    /**
     * 华为笔试题1
     */
    public void huawei1() {
        Scanner scanner1 = new Scanner(System.in);
        int num = scanner1.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        String s = scanner2.nextLine();
        int cou = 0;
        String temp = "";
        for (int i = 0; i < num; i++) {
            if (s.charAt(cou) == '0') {
                for (int j = cou + 8; j > cou; j--) {
                    temp += s.charAt(j);
                }
                temp += " ";
            } else if (s.charAt(cou) == '1') {
                for (int j = cou + 1; j <= cou + 8; j++) {
                    temp += s.charAt(j);
                }
                temp += " ";
            }
            cou = cou + 9;
        }
        System.out.println(temp);
    }
    static final Point START = new Point(0, 0);
    static int minpath = Integer.MAX_VALUE;

    public static int calculate(Point start, Point[] points, int sum, int count) {
        if (count == points.length) {
            minpath = Math.min(minpath, sum + start.getLength(START));
            return minpath;
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i].visited == false) {
                sum += points[i].getLength(start);
                if (sum < minpath) {
                    points[i].visited = true;
                    calculate(points[i], points, sum, count + 1);
                }
                sum -= points[i].getLength(start);
                points[i].visited = false;
            }
        }
        return minpath;
    }
    public void huawei2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] nums = null;
            nums = sc.nextLine().split(" ");
            int num[] = new int[10];
            for (int i = 0; i < 10; i++) {
                num[i] = Integer.valueOf(nums[i]);
            }
            Point[] points = new Point[5];
            int index = 0;
            for (int i = 0; i < 10; i++) {
                points[index] = new Point(num[i], num[i + 1]);
                index++;
                i++;
            }
            int min = calculate(START, points, 0, 0);
            System.out.println(min);
        }
    }
    //字符串拼接
    public void huawei4(){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int count = 0;//代表所有数字的个数
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] s = str.split(",");
            ArrayList<Integer> num = new ArrayList<>();
            for(int i = 0; i < s.length; i++){
                int t = Integer.parseInt(s[i]);
                num.add(t);
                count++;
            }
            arrayLists.add(num);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(count > 0){
            for(int i = 0; i < arrayLists.size(); i++){
                if(arrayLists.get(i).size() >= size){
                    for(int j=0; j < size; j++){
                        res.add(arrayLists.get(i).get(j));
                    }
                    for(int j=0; j < size; j++){
                        res.remove(arrayLists.get(i).get(j));
                    }
                    count -= size;

                }else {
                    for(int j=0; j < arrayLists.get(i).size(); j++){
                        res.add(arrayLists.get(i).get(j));
                    }
                    for(int j=0; j < arrayLists.get(i).size(); j++){
                        res.remove(arrayLists.get(i).get(j));
                    }
                    count -= arrayLists.get(i).size();
                }
            }
        }
        for(int i=0; i < res.size(); i++){
            System.out.print(res.get(i)+",");
        }
    }


}

class Point{
    int px;
    int py;
    boolean visited;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;
        this.visited = false;
    }

    public int getLength(Point p){
        return (int)Math.sqrt((px-p.px)*(px-p.px)+(py - p.py)*(py-p.py));
    }

    public void test2018_001(){
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
        if(min1 >= 0 || max1 <= 0){//全部数字都为正或者为负
            res = max1 * max2 * max3;
            System.out.println(res);
            return;
        }else{
            res = Math.max(max1 * max2 * max3, min1 * min2 * max1);
            System.out.println(res);
            return;
        }
    }

}

