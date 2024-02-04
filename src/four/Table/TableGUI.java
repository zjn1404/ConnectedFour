package four.Table;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TableGUI extends JPanel {
    private Table table;
    private Map<String, Cell> cells;
    private boolean isEven = true;
    private boolean isWin = false;
    private int rows;
    private int columns;
    public TableGUI(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        table = new Table(rows, columns);
        cells = new HashMap<>();
        setUpTable();
        setLayout(new GridLayout(rows, columns, 5, 5));
    }

    private void setUpTable() {
        for (int i = rows; i >= 1; i--) {
            for (int j = 0; j < columns; j++) {
                Cell cell = new Cell();
                String cellName = Character.toString('A' + j) + Integer.toString(i);
                cell.setText(" ");
                cell.setName("Button"+cellName);
                if ((i+j)%2 ==0) cell.setBackground(Color.GRAY);
                else cell.setBackground(Color.LIGHT_GRAY);
                setCellEvent(cell);
                cells.put(cellName, cell);
                add(cell);
                table.setBoard(rows-i, j, ' ');
            }
        }
    }

    private void setCellEvent(Cell cell) {
        cell.addActionListener(e -> {
            if(isWin) return;
            char player = 'X';

            int cellNameSize = cell.getName().length();
            char column = cell.getName().charAt(cellNameSize-2);
            for (int i = 0; i < rows; i++) {
                if(this.table.getBoard()[i][column-'A'] == ' ') {
                    Cell validCell = cells.get(Character.toString(column) + Integer.toString(i+1));
                    if(isEven) {
                        validCell.setForeground(Color.BLUE);
                        isEven = false;
                    } else {
                        validCell.setForeground(Color.orange);
                        player = 'O';
                        isEven = true;
                    }
                    this.table.setBoard(i, column-'A',player);
                    validCell.setText(Character.toString(player));

                    checkWinCondition(validCell, player);
                    break;
                }
            }

        });
    }

    private void checkWinCondition(Cell cell, char player) {
        int cellNameSize = cell.getName().length();
        int row = cell.getName().charAt(cellNameSize-1) - '0';
        int column = cell.getName().charAt(cellNameSize-2) - 'A';
        this.isWin = true;
        if (this.table.checkVertical(row, column, player)) {
            this.setVerticalWin(row, column, player);
        } else if (this.table.checkHorizontal(row, column, player)) {
            this.setHorizontalWin(row, column, player);
        } else if (this.table.checkMainDiagonal(row, column, player)) {
            this.setMainDiagonalWin(row, column, player);
        } else if (this.table.checkDiagonal(row, column, player)) {
            this.setDiagonalWin(row, column, player);
        } else {
            this.isWin = false;
        }
    }

    private void setVerticalWin(int row, int column, char player) {
        int index = row-1;
        while (index >= 0 && this.table.getBoard()[index][column] == player) {
            String cellName = Character.toString((char)(column+'A')) + Integer.toString(index+1);
            cells.get(cellName).setBackground(Color.GREEN);
            index--;
        }
    }

    private void setHorizontalWin(int row, int column, char player) {
        int index = column;
        while(index >= 0 && this.table.getBoard()[row-1][index] == player) {
            String cellName = Character.toString((char)(index+'A')) + Integer.toString(row);
            cells.get(cellName).setBackground(Color.GREEN);
            index--;
        }

        index = column+1;
        while(index < columns && this.table.getBoard()[row-1][index] == player) {
            String cellName = Character.toString((char)(index+'A')) + Integer.toString(row);
            cells.get(cellName).setBackground(Color.GREEN);
            index++;
        }
    }

    private void setMainDiagonalWin(int row, int column, char player) {
        int r = row-1;
        int col = column;
        while(r >= 0 && col >= 0 && this.table.getBoard()[r][col] == player) {
            String cellName = Character.toString((char)(col+'A')) + Integer.toString(r+1);
            cells.get(cellName).setBackground(Color.GREEN);
            r--;
            col--;
        }

        r = row;
        col = column + 1;
        while(r < rows && col < columns && this.table.getBoard()[r][col] == player) {
            String cellName = Character.toString((char)(col+'A')) + Integer.toString(r+1);
            cells.get(cellName).setBackground(Color.GREEN);
            r++;
            col++;
        }
    }

    private void setDiagonalWin(int row, int column, char player) {
        int r = row-1;
        int col = column;
        while(r >= 0 && col <columns && this.table.getBoard()[r][col] == player) {
            String cellName = Character.toString((char)(col+'A')) + Integer.toString(r+1);
            cells.get(cellName).setBackground(Color.GREEN);
            r--;
            col++;
        }

        r = row;
        col = column-1;
        while(r < rows && col >= 0 && this.table.getBoard()[r][col] == player) {
            String cellName = Character.toString((char)(col+'A')) + Integer.toString(r+1);
            cells.get(cellName).setBackground(Color.GREEN);
            r++;
            col--;
        }
    }

    public void reset() {
        cells.forEach((k, v) -> {
            v.setText(" ");
            int row = k.charAt(1) - '1';
            int col = k.charAt(0) - 'A';
            if ((row+col)%2 !=0) v.setBackground(Color.GRAY);
            else v.setBackground(Color.LIGHT_GRAY);
        });

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                table.setBoard(i, j, ' ');
            }
        }
        isWin = false;
        isEven = true;
    }
}
