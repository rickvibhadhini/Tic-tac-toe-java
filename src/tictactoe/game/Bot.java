package tictactoe.game;

import java.util.Random;

public class Bot {
    public static int[] makeMove(int boardSize, Board board) {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(boardSize);
            col = random.nextInt(boardSize);
        } while (!board.isCellEmpty(row, col)); // Ensure the bot selects an empty cell
        return new int[]{row, col};
    }
}
