package ten;

/**
 * Created by Administrator on 2016/12/23.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {

        /**
           @author zhengyanan
           @date 2016/12/23 @time 12:15
          33ms 503K
         version_3
        */
        StringBuilder result = new StringBuilder();
        char mChar;
        for (int i = 0; i < str.length(); i++) {
            mChar = str.charAt(i);
            if (mChar == ' ')   result.append("%20");
            else result.append(mChar);
        }

        return result.toString();


        /**
           @author zhengyanan
           @date 2016/12/23 @time 11:22
           version_2
          35ms  688k
        */
//        if (str == null){
//            return null;
//        }
//        return str.toString().replaceAll(" ","%20");

        /**
           @author zhengyanan
           @date 2016/12/23 @time 10:55
          version_1 调用java String类的APi   42ms，654k
        */
//        String str2 = "*" + str.toString() + "*";
//        String[] words = str2.split(" ");
//        StringBuilder s = new StringBuilder("");
//        for (int i = 0; i < words.length; i++) {
//            s.append(words[i]);
//            s.append("%20");
//        }
//        s.delete(0,1);
//        s.delete(s.length() - 4,s.length());
//        return s.toString();
    }
    public static void main(String[] args){
        ReplaceSpace r = new ReplaceSpace();
        System.out.println("ReplaceSpace.main():" + r.replaceSpace(new StringBuffer("hlkfdjsa hlkj")));
    }
}
