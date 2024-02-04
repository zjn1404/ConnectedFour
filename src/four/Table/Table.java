package four.Table;

public class Table {
    private char[][] board;
    private int rows;
    private int columns;
    public Table(int rows, int columns) {
        board = new char[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    public void setBoard(int row, int column, char c) {
        this.board[row][column] = c;
    }

    public final char[][] getBoard() {
        return this.board;
    }

    public boolean checkVertical(int row, int column, char player) {
        int count = 0;
        int index = row-1;
        while (index >= 0 && this.board[index][column] == player) {
            count++;
            index--;
        }
        return count >= 4;
    }

    public boolean checkHorizontal(int row, int column, char player) {
        int count = 0;
        int index = column;
        while(index >= 0 && this.board[row-1][index] == player) {
            count++;
            index--;
        }

        index = column+1;
        while(index < columns && this.board[row-1][index] == player) {
            count++;
            index++;
        }

        return count >= 4;
    }

    public boolean checkMainDiagonal(int row, int column, char player) {
        int count = 0;
        int r = row-1;
        int col = column;
        while(r >= 0 && col >= 0 && this.board[r][col] == player) {
            r--;
            col--;
            count++;
        }

        r = row;
        col = column + 1;
        while(r < rows && col < columns && this.board[r][col] == player) {
            r++;
            col++;
            count++;
        }

        return count >= 4;
    }

    public boolean checkDiagonal(int row, int column, char player) {
        int count = 0;
        int r = row-1;
        int col = column;
        while(r >= 0 && col <columns && this.board[r][col] == player) {
            r--;
            col++;
            count++;
        }

        r = row;
        col = column-1;
        while(r < rows && col >= 0 && this.board[r][col] == player) {
            r++;
            col--;
            count++;
        }

        return count >= 4;
    }
}
