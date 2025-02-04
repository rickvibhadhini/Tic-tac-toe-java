package tictactoe.game;

import java.util.List;

public class TicTacToe1 {
    private static TicTacToe instance;
    private List<Player> players;
    private char[][] board;

    // Private constructor to prevent instantiation from outside the class
    private TicTacToe1(int boardSize, List<Player> players) {
        this.players = players;
        this.board = new char[boardSize][boardSize];

        // Initialize the board
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.board[i][j] = '-';  // Empty space
            }
        }
    }

    // Public method to provide access to the single instance
    public static TicTacToe getInstance(int boardSize, List<Player> players) {
        if (instance == null) {
            // Only create the instance if it doesn't already exist
            instance = new TicTacToe(boardSize, players);
        }
        return instance;
    }

    // Method to start the game
    public void start() {
        // Game logic here
        System.out.println("Game started with board size: " + board.length);
        // Print the board (for example purposes)
        printBoard();
    }

    // Print the board
    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Getter for the board (if needed)
    public char[][] getBoard() {
        return board;
    }

    // Other methods related to the game (such as checking the winner, making moves, etc.) can be added here
}
