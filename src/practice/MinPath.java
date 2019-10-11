package practice;

public class MinPath {

    //由暴力递归---》动态规划
    //一个二维数组，只能由左上角到右下角，只能向下或者向右，返回最小路径和

    public static int minPath1(int[][] matrix) {
        return process1(matrix, matrix.length - 1, matrix[0].length - 1);
    }

    //从（i，j）出发到达右下角，最小路径和（返回）-----重复状态过多
    public static int process1(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0) {
            return res;
        }
        if (i == 0 && j != 0) {
            return res + process1(matrix, i, j - 1);
        }
        if (i != 0 && j == 0) {
            return res + process1(matrix, i - 1, j);
        }
        return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
    }
    //动态规划：递归展开是有重复状态的，到达一个状态，与到达此状态的路径无关；之前做出的选择不会影响当前状态
    //可变参数确定，返回值就固定；【0，0】位置的返回值就是我要的最终结果
    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        //最右下角的值；
        dp[0][0] = m[0][0];
        //最后一列的计算
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        //最后一行的计算
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        //一个普遍位置，需要右面，和下面
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }
        //参考这个-------重复状态过多，将每个位置的最短路径和都记录下来；
    public static int walk(int[][] martrx, int i, int j) {
        //已经到达右下角
        if (i == martrx.length - 1 && j == martrx[0].length - 1) {
            return martrx[i][j];
        }
        //位置处于最后一行  路径和=自己位置+自己右边位置到右下角的最短路径和
        if (i == martrx.length - 1) {
            return martrx[i][j] + walk(martrx, i, j + 1);
        }
        //位置处于最后一列，路径和=自己位置+自己下边位置到右下角的最短路径和
        if (j == martrx[0].length - 1) {
            return martrx[i][j] + walk(martrx, i + 1, j);
        }
        //一般情况，可以往下走或者往右走；
        int right = walk(martrx, i, j + 1); //右边位置到右下角的最小路径和
        int down = walk(martrx, i + 1, j);  //下边位置到右下角的最小路径和
        return martrx[i][j] + Math.min(right, down);
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}
