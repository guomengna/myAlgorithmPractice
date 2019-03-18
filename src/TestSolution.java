import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class TestSolution {
    //输出字符串的子串，重复的字母的个数及字母
    //aabbcccbb 输出2a,2b,3c
    public void getSubString(){
        String s = "aabbcccbbb";
        char[] c = s.toCharArray();
        int count = 1;
        HashSet<String> hashSet = new HashSet<>();
        String temp = String.valueOf(c[0]);
        for(int i = 1; i < s.length(); i++){
            if(String.valueOf(c[i]).equals(temp)){
                count++;
            }else {
                hashSet.add(count+""+temp);
                temp = String.valueOf(c[i]);
                count = 1;
            }
        }
        hashSet.add(count+""+temp);
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //青蛙爬井的问题
    public void fog(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            double h = sc.nextDouble();
            if(h == 0){
                System.out.println("输入结束");
                break;
            }
            double u = sc.nextDouble();
            double d = sc.nextDouble();
            System.out.println("h = "+h+" u = "+u+" d = "+d);
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
    public void unrepeatNum(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] temp = s.split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < temp.length; i++){
            if(hashMap.containsKey(temp[i])){
                hashMap.put(temp[i], hashMap.get(temp[i])+1);
            }else {
                hashMap.put(temp[i], 1);
            }
        }
        Iterator<String> iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()){
            String t = iterator.next();
            if(hashMap.get(t) == 1){
                System.out.println(t);
            }
        }
    }
    //大鱼吃小鱼游戏
    public void eatingFish(){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Scanner sc1 = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < size; i++){
            nums.add(sc1.nextInt());
        }
        eating(nums);
    }
    public int eating(ArrayList<Integer> nums){
        if(nums.size() == 1){
            System.out.println("nums.get(0) = "+Math.abs(nums.get(0)));
            return Math.abs(nums.get(0));
        }else {
            for(int i = 0; i < nums.size(); i++){
                //i的左右都有值
                if(i >= 1  && i < nums.size()-1){
                    //向右吃
                    ArrayList right = nums;
                    right.set(i, nums.get(i)-nums.get(i + 1));
                    right.remove(i + 1);
                    //向左吃
                    ArrayList left = nums;
                    left.set(i, nums.get(i)-nums.get(i - 1));
                    left.remove(i - 1);
                    i--;
//                    System.out.println(Math.max(eating(left), eating(right)));
                    return Math.abs(Math.max(eating(left), eating(right)));
                }
                if(i == 0){//i的右边有值，左边没有值
                    //向右吃
                    ArrayList right = nums;
                    right.set(i, nums.get(i)-nums.get(i + 1));
                    right.remove(i + 1);
//                    System.out.println(Math.abs(eating(right)));
                    return Math.abs(eating(right));
                }
                if(i == nums.size() - 1){//i的左边有值，右边没有值
                    //向左吃
                    ArrayList left = nums;
                    left.set(i, nums.get(i)-nums.get(i - 1));
                    left.remove(i - 1);
//                    System.out.println(Math.abs(eating(left)));
                    return Math.abs(eating(left));
                }
            }
        }
        System.out.println(-1000);
        return -1000;
    }

}
