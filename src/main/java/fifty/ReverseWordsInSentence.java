package fifty;

/**
 * Created by Administrator on 2017/2/28.
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseWordsInSentence {
    /**
       @author zhengyanan
       @date 2017/2/28 @time 20:23
      version_1:
        核心思路：
            1.经典解法：原字符串 A*B*C，要求结果C*B*A (*表示空格，A、B、C表示无空格的字符串)
            假设^表示翻转字符串操作，
            先将A*B*C翻转，(A*B*C)^ = C^*B^*A^；再将所得结果中的每一个单词翻转，即：
            (C^)^*(B^)^*(A^)^ = C*B*A，就得到了要求的结果C*B*A。
            2.将上述思路实现即可
       运行时间：31ms
       占用内存：503k
    */
    public String ReverseSentence(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        int start=0,end=0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' '){
                end = i - 1;
                reverse(sb,start,end);

                start = i + 1;
            }
        }
        reverse(sb,start,str.length() - 1);

        return sb.toString();
    }

    private void reverse(StringBuilder sb,int start,int end){
        char t;
        while (start < end){
            t = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,t);

            start++;
            end--;
        }
    }

    public static void main(String[] args){
//        System.out.println("sfdfds");
        System.out.println("*******"+
        new ReverseWordsInSentence().ReverseSentence("   ")+"**");
    }
}
