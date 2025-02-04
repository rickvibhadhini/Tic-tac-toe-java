package tictactoe.game;

public class Board {
    private int size;
    private char[][] board;

    public int getSize() {
        return size;
    }

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (row < 0 || col < 0 || row >= size || col >= size || board[row][col] != '-') {
            return false;
        }
        board[row][col] = symbol;
        return true;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == '-';
    }

    public boolean checkWinner(char symbol) {
        // Check rows and columns
        for (int i = 0; i < size; i++) {
            if (checkRow(i, symbol) || checkColumn(i, symbol)) {
                return true;
            }
        }

        // Check diagonals
        return checkDiagonal(symbol) || checkAntiDiagonal(symbol);
    }

    private boolean checkRow(int row, char symbol) {
        for (int j = 0; j < size; j++) {
            if (board[row][j] != symbol) return false;
        }
        return true;
    }

    private boolean checkColumn(int col, char symbol) {
        for (int i = 0; i < size; i++) {
            if (board[i][col] != symbol) return false;
        }
        return true;
    }

    private boolean checkDiagonal(char symbol) {
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(char symbol) {
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] != symbol) return false;
        }
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }
}
