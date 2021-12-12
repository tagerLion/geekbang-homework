package cn.emmayu.homework.week.fourth;

public class SurroundingArea {

    public static boolean[][] b;
    public static int row;
    public static int column;
    public static char[][] g;
    public static int[] l = new int[]{-1, 1, 0, 0};
    public static int[] r = new int[]{0, 0, -1, 1};

    public void solve(char[][] board) {
        row = board.length;
        column = board[0].length;
        b = new boolean[row][column];
        g = board;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O' && !b[i][0]) {
                b[i][0] = true;
                dfs(i, 0);
            }
            if (board[i][column - 1] == 'O' && !b[i][column - 1]) {
                b[i][column - 1] = true;
                dfs(i, column - 1);
            }
        }
        for (int i = 0; i < column; i++) {
            if (board[0][i] == 'O' && !b[0][i]) {
                b[0][i] = true;
                dfs(0, i);
            }
            if (board[row - 1][i] == 'O' && !b[row - 1][i]) {
                b[row - 1][i] = true;
                dfs(row - 1, i);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O' && !b[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void dfs(int i, int j) {
        for (int p = 0; p < 4; p++) {
            int d = i + l[p];
            int f = j + r[p];
            if (d >= 0 && d < row && f >= 0 && f < column && g[d][f] == 'O' && !b[d][f]) {
                b[d][f] = true;
                dfs(d, f);
            }
        }
    }

}
