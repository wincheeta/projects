import java.util.HashSet;
import java.util.Stack;

public class sudoko_solver {
    private int[][] board;
    private Stack<Integer> recent = new Stack<Integer>();

    public void printSudoku() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println("-------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(this.board[i][j] + "");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public boolean checkSudoku() {
        int count;
        HashSet<Integer> set;
        for (int[] i : this.board) {
            count = 0;
            set = new HashSet<>();
            for (int j : i) {
                if (j == 0) {
                    continue;
                }
                set.add(j);
                count++;
            }
            if (count != set.size()) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            count = 0;
            set = new HashSet<Integer>();
            for (int j = 0; j < 9; j++) {
                if (this.board[j][i] == 0) {
                    continue;
                }
                set.add(this.board[j][i]);
                count++;
            }
            if (count != set.size()) {
                return false;
            }
        }


        return true;
    }

    public void add(int pos, int num) {
        int r = pos / 9, c = pos % 9;
        if (this.board[r][c] == 0) {
            this.board[r][c] = num;
            this.recent.push(pos);
        }
    }

    public void unmake() {
        int pos = this.recent.pop();
        int r = pos / 9, c = pos % 9;
        this.board[r][c] = 0;
    }

    public void solve(int pos) {
        while (this.board[pos/9][pos%9] != 0){pos++;}
        if (!this.isfull() && pos < 81) {
            for (int i = 1; i <= 9; i++) {
                this.add(pos, i);
                //System.out.println(pos+ ", "+ i);
                //this.printSudoku();
                if (this.checkSudoku()) {
                    this.solve(pos + 1);
                } else {
                    this.unmake();
                }

            }
        }

    }

    public boolean isfull() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        sudoko_solver solver = new sudoko_solver();
        solver.board = new int[][]{{5, 3, 0, 0, 7, 0, 0, 0, 0}, {6, 0, 0, 1, 9, 5, 0, 0, 0}, {0, 9, 8, 0, 0, 0, 0, 6, 0}, {8, 0, 0, 0, 6, 0, 0, 0, 3}, {4, 0, 0, 8, 0, 3, 0, 0, 1}, {7, 0, 0, 0, 2, 0, 0, 0, 6}, {0, 6, 0, 0, 0, 0, 2, 8, 0}, {0, 0, 0, 4, 1, 9, 0, 0, 5}, {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        solver.printSudoku();
        solver.solve(0);
        solver.printSudoku();


    }
}