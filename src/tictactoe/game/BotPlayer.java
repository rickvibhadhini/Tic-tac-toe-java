package tictactoe.game;

import java.util.Random;

public class BotPlayer extends Player {

    public BotPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.isCellEmpty(row, col)); // Ensure the bot selects an empty cell
        return new int[]{row, col};
    }
}
