package sixty;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ASUS on 2017/3/12.
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstCharInCharFlow {


    /**
    @author zhengyanan
    @time 19:40
    @description
     version_1:
        核心思路：
            1.取一个LinkedHashMap,用char当key，char出现的次数当value。
            2.每次 插入一个char，就更新Map；
            3.要找当前firstChar时，就从Map中找到第一个value为1的char输出即可
   运行时间：34ms
    占用内存：699k
     */
    LinkedHashMap<Character,Integer> result = new LinkedHashMap<Character,Integer>();
    //Insert one char from stringstream
    public void Insert(char ch){
        if (result.containsKey(ch))    result.put(ch,result.get(ch) + 1);
        else                           result.put(ch,1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        for (Map.Entry<Character,Integer> entry:result.entrySet()){
            if (entry.getValue() == 1)  return entry.getKey();
        }
        return '#';
    }
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append("1"));
    }
}
