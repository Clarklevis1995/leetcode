package 练习.之字形打印矩阵;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-01 20:57
 **/
public class ZigZagPrint {
    public static void printMatrixZigzag(int[][] m){
        int aRow = 0;
        int aCol = 0;
        int bRow = 0;
        int bCol = 0;
        int END_ROW = m.length-1;
        int END_COL = m[0].length-1;
        boolean fromUp = false;
        while(aRow!=END_ROW+1){
            //这里要注意变化的顺序：A点先变化Row，再变化Col；B点先变化Col，再变化Row
            printLevel(m, aRow,aCol,bRow,bCol,fromUp);
            aRow = aCol == END_COL? aRow+1: aRow;
            aCol = aCol == END_COL? aCol: aCol+1;
            bCol = bRow == END_ROW? bCol+1: bCol;
            bRow = bRow == END_ROW? bRow: bRow+1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

        public static void printLevel(int[][] m, int aRow, int aCol, int bRow, int bCol, boolean f){
         if (f){
             while(aRow!=bRow+1){
                 System.out.print(m[aRow++][aCol--]+" ");
             }
         }else {
             while(bCol!=aCol+1){
                 System.out.print(m[bRow--][bCol++]+" ");
             }
         }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        printMatrixZigzag(matrix);
    }
}
