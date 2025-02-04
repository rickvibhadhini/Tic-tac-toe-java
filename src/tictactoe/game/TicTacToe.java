//package tictactoe.game;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class TicTacToe {
//    private int boardSize;
//    private Board board;
//    private List<String> players;
//    private List<Boolean> isBot;
//    private int currentPlayerIndex;
//
//    public TicTacToe(int boardSize, List<String> players, List<Boolean> isBot) {
//        this.boardSize = boardSize;
//        this.players = players;
//        this.isBot = isBot;
//        this.board = new Board(boardSize);
//        this.currentPlayerIndex = 0;
//    }
//
//    public void start() {
//        System.out.println("\nStarting the game...");
//        board.display();
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            // Current player's turn
//            String currentPlayer = players.get(currentPlayerIndex);
//            System.out.println("\n" + currentPlayer + "'s turn:");
//
//            int row, col;
//            if (isBot.get(currentPlayerIndex)) {
//                // Bot makes a move
//                int[] botMove = Bot.makeMove(boardSize, board);
//                row = botMove[0];
//                col = botMove[1];
//                System.out.println("Bot moves to: " + row + " " + col);
//            } else {
//                // Human player makes a move
//                System.out.print("Enter row and column (space-separated): ");
//                row = scanner.nextInt();
//                col = scanner.nextInt();
//            }
//
//            if (!board.makeMove(row, col, getPlayerSymbol(currentPlayerIndex))) {
//                System.out.println("Invalid move. Try again.");
//                continue;
//            }
//
//            board.display();
//
//            // Check for a winner or draw
//            if (board.checkWinner(getPlayerSymbol(currentPlayerIndex))) {
//                System.out.println(currentPlayer + " wins!");
//                break;
//            } else if (board.isFull()) {
//                System.out.println("It's a draw!");
//                break;
//            }
//
//            // Move to the next player
//            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
//        }
//
//        scanner.close();
//    }
//
//    private char getPlayerSymbol(int playerIndex) {
//        return (char) ('X' + playerIndex);
//    }
//}


package tictactoe.game;

import java.util.List;

public class TicTacToe {
    private int boardSize;
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;

    public TicTacToe(int boardSize, List<Player> players) {
        this.boardSize = boardSize;
        this.players = players;
        this.board = new Board(boardSize);
        this.currentPlayerIndex = 0;
    }



    public void start() {
        System.out.println("\nStarting the game...");
        board.display();

        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\n" + currentPlayer.getName() + "'s turn:");

            int[] move = currentPlayer.makeMove(board);
            if (!board.makeMove(move[0], move[1], currentPlayer.getSymbol())) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board.display();

            // Check for a winner or draw
            if (board.checkWinner(currentPlayer.getSymbol())) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            } else if (board.isFull()) {
                System.out.println("It's a draw!");
                break;
            }

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }
}



