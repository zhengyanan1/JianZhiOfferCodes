package seventy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/3/13.
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如[a b c e
 *     s f c s
 *     a d e e]
 *     是3*4矩阵，其包含字符串"bcced"的路径，但是矩阵中不包含“abcb”路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class PathInMatrixForString {




    /**
       @author zhengyanan
       @date 2017/3/14 @time 10:07
      version_2:
        核心思路：优化版回溯法，参考《剑指offer》
            1.将matrix字符串模拟映射为一个字符矩阵(但并不实际创建一个矩阵)
            2.取一个boolean[matrix.length]标记某个字符是否已经被访问过。
            3.如果没找到结果，需要将对应的boolean标记值置回false,返回上一层进行其他分路的查找。
       运行时间：37ms
       占用内存：528k
    */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean[] visited = new boolean[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchFromHere(matrix,rows,cols,i,j,0,str,visited))
                    return true;

            }
        }
//        System.out.println(Arrays.toString(visited));
        return false;
    }

    public boolean searchFromHere(char[] matrix,int rows,int cols,int r,int c,int index,char[] str,boolean[] visited){
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r * cols + c] != str[index] || visited[r * cols + c])
            return false;
        if (index == str.length - 1)    return true;

        visited[r * cols + c] = true;
        if (searchFromHere(matrix,rows,cols,r - 1,c,index + 1,str,visited) ||
                searchFromHere(matrix,rows,cols,r,c -1,index + 1,str,visited) ||
                searchFromHere(matrix,rows,cols,r + 1,c,index + 1,str,visited) ||
                searchFromHere(matrix,rows,cols,r,c + 1,index + 1,str,visited))
            return true;

        visited[r * cols + c] = false;
        return false;
    }

    /**
     @author zhengyanan
     @time 22:10
     @description
     version_1:
     核心思路：回溯法
     1.先将matrix字符串映射为字符矩阵；
     2.从原字符串中找到第一个跟str[0]相等的字符，得到其对应的在矩阵中的位置[r,c]
     1）从[r,c]开始按 上、左、右、下的顺序搜索；
     2）每当搜索到一个节点，先判断path是否包括它，包括就说明已经经过此节点，不能
     再经过了；如果不包括，就将其加入path容器
     3）直到搜索到str[length - 1]节点，说明成功找到，标记result为true，标记
     isFinished为true,尽快结束所有的递归操作
     4）如果某节点起的 上、左、右、下 都搜索过但还没找到结果，说明经过此节点的路
     径都不满足题意，将其从path中删除，回溯到上一层继续找。
     （PS:确实是回溯法，不过代码有点长，实现的有点繁杂）
     运行时间：51ms
     占用内存：625k
     */
//    private char[][] data;
//    private int rows;
//    private int cols;
//    private LinkedList<Integer> path = new LinkedList<Integer>();
//    private boolean result = false;
//    private boolean isFinished = false;
//
//    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
//        this.rows = rows;
//        this.cols = cols;
//        data = new char[rows][cols];
//        for (int i = 0,k = 0; i < rows; i ++) {
//            for (int j = 0; j < cols; j ++) {
//                data[i][j] = matrix[k ++];
//            }
//        }
//
//        int r,c;
//        for (int i = 0; i < matrix.length; i++) {
//            if (matrix[i] == str[0] && !isFinished){
//                r = i / cols;
//                c = i % cols;
//                tryPath(r,c,str,0);
//            }
//        }
//
//        return result;
//    }
//
//    public void tryPath(int r,int c,char[] str,int index){
//        if (isFinished) return;
//        if (path.contains(r * cols + c))   return;
//
//        path.addLast(r * cols + c);
//
//        if (index == str.length - 1)    {
//            isFinished = true;
//            result = true;
//        }
//        else {
//            for (int i = 0; i < 4; i++) {
//                switch (i) {
//                    case 0:
//                        if (r - 1 >= 0 && data[r - 1][c] == str[index + 1]) {
//                            tryPath(r - 1, c, str, index + 1);
//                        }
//                        break;
//                    case 1:
//                        if (c - 1 >= 0 && data[r][c - 1] == str[index + 1]) {
//                            tryPath(r, c - 1, str, index + 1);
//                        }
//                        break;
//                    case 2:
//                        if (r + 1 < rows && data[r + 1][c] == str[index + 1]) {
//                            tryPath(r + 1, c, str, index + 1);
//                        }
//                        break;
//                    case 3:
//                        if (c + 1 < cols && data[r][c + 1] == str[index + 1]) {
//                            tryPath(r, c + 1, str, index + 1);
//                        }
//                        break;
//                }
//            }
//        }
//        path.removeLast();
//    }


    public static void main(String[] args){
        char[] a = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] b = "SGGFIECVAASABCEHJIGQEM".toCharArray();
        System.out.println(new PathInMatrixForString().hasPath(a,5,8,b));
    }
}
// A B C E H J I G
// S F C S L O P Q
// A D E E M N O E
// A D I D E J F M
// V C E I F G G S