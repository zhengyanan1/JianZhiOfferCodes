package ten;

/**
 * Created by Administrator on 2016/12/22.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/**
   @author zhengyanan
   @date 2016/12/22 @time 16:59
  二维数组中的查找
*/
public class Ints {
    public static boolean recursionFind(int target,int[][]array,int leftR,int leftC,int rightR,int rightC){
//        System.out.println("Ints.recursionFind():"+"("+leftR+","+leftC+")"+array[leftR][leftC]+
//                ";"+"("+rightR+","+rightC+")"+array[rightR][rightC]);
        if (leftR == rightR){
            for (int i = leftC; i <= rightC ; i++) {
                if (array[leftR][i] == target)  return true;
            }
            return false;
        }
        if (leftC == rightC){
            for (int i = leftR; i <= rightR; i++) {
                if (array[i][leftC] == target)  return true;
            }
            return false;
        }

        int currentR,currentC;
        currentR = (leftR + rightR) / 2;
        currentC = (leftC + rightC) / 2;
        if (array[currentR][currentC] == target)    return true;
        else if (array[currentR][currentC] > target) return recursionFind(target,array,leftR,leftC,currentR,currentC);
        else return recursionFind(target,array,currentR+1,leftC,rightR,currentC)
                    || recursionFind(target,array,leftR,currentC+1,rightR,rightC);
    }
    public static boolean Find(int target, int [][] array) {
        /**
           @author zhengyanan
           @date 2016/12/23 @time 16:19
           version_2: 无法说明时间复杂度，至少是 小于 O(m*n)
           运行时间：134ms
           占用内存：5173k
        */
        int row,column = 0;
        row = array.length;
        if (row != 0)   {
            column = array[0].length;
        }
        if (0 == row || 0 == column)    return false;

        int leftR = 0,leftC = 0,rightR = row - 1,rightC = column - 1;

        return recursionFind(target,array,leftR,leftC,rightR,rightC);


        /**
           @author zhengyanan
           @date 2016/12/23 @time 15:36
           运行时间：142ms
           占用内存：5173k
         version_1:
            思路：* 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
            * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移一列
            * 要查找数字比左下角数字小时，上移一行。这样每次比较，要么找到，要么消去一行或者一列
         * 不可能的元素，同时还没有遗漏。
         * 时间复杂度 O(m+n)
        */
//        int row,column = 0;
//        row = array.length;
//        if (row != 0)   {
//            column = array[0].length;
//        }
//        if (0 == row || 0 == column)    return false;
//
//        int rowC = row - 1,columnC = 0;
//        while (rowC >= 0 && columnC < column){
//            /**
//               @author zhengyanan
//               @date 2016/12/23 @time 15:32
//               rowC >= 0 && rowC < row && columnC >= 0 && columnC <= column
//                不难发现 rowC < row 恒成立；columnC >=0 恒成立.故：简化之。
//            */
//            if (target == array[rowC][columnC])         return true;
//            else if (target < array[rowC][columnC])     rowC--;
//            else                                        columnC++;
//        }
//        return false;



//        int row,column = 0;
//        row = array.length;
//        if (row != 0)   {
//            column = array[0].length;
//        }
//
//        if (0 == row || 0 == column)    return false;
//        // @author zyn 17:09 2016/12/22
//        //可能有问题，column的值
//        int leftRow = 0,leftColumn = 0,rightRow = row - 1,rightColumn = column - 1;
//        int currentRow,currentColumn;
//
//        int compare = 0;
//
//        System.out.println(leftRow+";"+leftColumn+"*"+array[leftRow][leftColumn]+" : "+rightRow+";"+rightColumn+"*"+array[rightRow][rightColumn]);
//        while (true){
//            currentRow = (leftRow + rightRow + 1) / 2;
//            currentColumn = (leftColumn + rightColumn + 1) / 2;
//
//            if (target == array[currentRow][currentColumn]) return true;
//            else if (target < array[currentRow][currentColumn]){
//                rightRow = currentRow;
//                rightColumn = currentColumn;
//            }
//            else {
//                leftRow = currentRow;
//                leftColumn = currentColumn;
//            }
//
//            System.out.println(leftRow+";"+leftColumn+"*"+array[leftRow][leftColumn]+" : "+rightRow+";"+rightColumn+"*"+array[rightRow][rightColumn]);
//
//
//            if (leftColumn == rightColumn){
//                compare = 1;
//                break;
//            }
//            else if (leftRow == rightRow){
//                compare = 2;
//                break;
//            }
//
//            if (leftColumn + 1 == rightColumn && leftRow + 1 == rightRow){
//                compare = 3;
//                break;
//            }
//        }
//        if (compare == 1){
//            for (int i = leftRow; i <= rightRow ; i++) {
//                if (target == array[i][leftColumn]){
//                    return true;
//                }
//            }
//        }
//        else if (compare == 2){
//            for (int i = leftColumn; i <= rightColumn ; i++) {
//                if (target == array[leftRow][i]){
//                    return true;
//                }
//            }
//        }
//        else if (compare == 3){
//            if (target == array[leftRow][leftColumn + 1] ||
//                    target == array[leftRow + 1][leftColumn] ||
//                    target == array[leftRow][leftColumn] ||
//                    target == array[leftRow + 1][leftColumn + 1]){
//                return true;
//            }
//        }
//        return false;
    }
    public static void main(String[] args){
        int[][] data = new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };

        System.out.println(Find(15,data));
    }
}

//                {1,2,4,6,8,10,11,13,15,17,20,22,24,27,30,32,35,36,38,39,42,44,46,47,48,49,51,54,55,56},
//                {3,4,6,8,11,13,15,18,19,20,23,25,27,29,33,36,38,41,42,45,48,50,53,54,57,60,63,65,66,67},
//                {5,7,8,11,14,15,17,19,21,23,24,28,31,33,36,39,41,44,47,49,52,53,56,57,60,63,66,68,71,72},
//                {7,10,13,14,17,19,22,25,26,27,30,32,34,37,39,42,44,46,50,53,55,56,59,61,64,66,69,72,74,76},
//                {8,12,16,17,20,21,23,26,29,31,33,35,37,40,42,45,48,49,52,55,58,59,61,63,67,69,70,74,76,79},
//                {10,15,18,20,22,24,27,30,32,33,36,38,39,41,45,47,50,53,56,58,61,64,65,68,69,71,73,76,79,82},
//                {13,17,20,23,24,26,28,31,34,36,38,41,42,43,48,50,53,56,58,61,64,67,68,71,73,74,75,78,81,84},
//                {15,19,22,24,26,28,31,34,35,38,41,44,45,46,49,51,56,59,61,64,67,69,71,73,76,78,79,82,85,87},
//                {17,20,23,26,29,30,32,37,40,42,43,47,50,53,55,56,58,62,64,66,69,72,75,78,80,81,83,86,88,90},
//                {18,21,25,28,30,32,35,38,42,43,44,49,51,55,58,59,61,65,68,71,73,74,77,79,82,85,88,89,91,93},
//                {20,23,28,29,33,36,37,40,43,45,47,52,55,58,60,62,63,66,70,74,76,77,79,81,85,88,89,91,93,94},
//                {23,25,31,33,35,39,42,43,44,46,50,53,56,61,62,65,68,69,72,75,78,81,82,83,88,91,92,93,96,99},
//                {26,27,33,34,38,40,45,48,51,53,55,56,58,64,66,69,72,75,77,80,82,84,87,88,90,93,94,95,99,101},
//                {29,30,36,38,40,42,47,50,53,56,57,59,62,65,68,71,73,77,79,83,84,86,88,91,93,96,99,100,102,103},
//                {32,33,39,42,44,46,49,53,56,59,62,65,68,71,72,75,77,78,80,85,87,90,92,94,96,99,101,103,105,107},
//                {35,37,42,43,46,48,51,55,59,61,65,67,71,74,76, 78 ,81,82,84,86,90,92,95,96,99,102,103,106,107,109},
//                {36,39,43,46,49,50,53,58,62,65,67,70,73,76,77,79,84,87,88,90,93,96,99,102,103,106,108,111,112,115},
//                {38,42,45,47,52,55,57,60,64,66,69,72,75,78,80,82,87,89,91,92,94,99,100,103,105,107,111,112,115,118},
//                {39,44,48,49,55,57,60,63,66,69,72,75,78,80,82,85,89,92,94,95,98,101,102,105,108,111,112,115,116,120},
//                {40,47,49,52,56,59,63,64,68,71,75,78,80,83,85,88,91,94,97,  99 ,101,104,105,108,110,112,115,118,120,123},
//                {42,50,53,55,59,62,66,67,71,73,78,81,82,86,87,90,94,97,100,101,104,106,107,109,111,114,117,120,123,126},
//                {43,51,55,58,62,64,69,71,74,77,81,84,86,87,89,93,96,99,102,103,105,108,111,112,113,116,120,122,125,129},
//                {45,54,56,59,65,67,72,75,76,79,84,87,90,92,94,97,99,102,104,107,108,111,114,116,119,120,122,124,127,132},
//                {47,55,59,62,66,68,74,78,80,82,85,88,93,96,99,101,102,105,106,108,110,113,115,118,120,121,124,127,130,133},
//                {49,56,61,65,68,70,76,81,83,85,87,91,95,99,102,103,104,106,108,110,113,116,118,121,124,127,130,133,134,137},
//                {51,57,62,68,71,74,78,83,86,89,92,95,97,101,104,106,108,110,113,114,117,119,121,123,126,130,132,135,137,140},
//                {53,59,65,69,73,75,81,86,88,92,95,97,100,103,107,109,111,112,115,117,120,122,125,126,129,131,133,138,141,143},
//                {55,61,67,72,75,77,82,89,92,94,97,100,102,105,108,111,114,115,116,119,123,125,126,128,131,134,137,140,144,146},
//                {57,63,68,74,78,81,85,90,95,98,100,101,103,107,110,114,117,119,120,123,126,129,130,133,136,138,141,144,146,149},
//                {58,65,70,76,81,84,86,93,98,101,104,105,107,110,112,115,120,122,124,126,129,132,135,136,138,140,142,146,149,150}
