package 练习.旋转矩阵;

public class RotateMatrix {
    public static void rotate(int[][] m){
        //左上角
        int a = 0;
        int b = 0;
        //右下角
        int c = m.length-1;
        int d = m[0].length-1;

        while(a<c){
            rotateEdge(m, a++,b++,c--,d--);
        }
    }

    public static void rotateEdge(int[][] m, int a, int b, int c, int d){
        //循环次数
        int times = d - b;
        for (int i = 0; i < times; i++) {
            int temp = m[a][b+i];
            m[a][b+i] = m[c-i][b];
            m[c-i][b] = m[c][d-i];
            m[c][d-i] = m[a+i][d];
            m[a+i][d] = temp;
        }

    }

    public static void matrixPrint(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println("旋转之前---------");
        matrixPrint(matrix);
        rotate(matrix);
        System.out.println("旋转之后---------");
        matrixPrint(matrix);

    }
}
