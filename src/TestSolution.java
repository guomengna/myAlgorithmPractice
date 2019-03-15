import java.util.HashSet;
import java.util.Iterator;

public class TestSolution {
    //输出重复的字母的个数及字母
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
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
