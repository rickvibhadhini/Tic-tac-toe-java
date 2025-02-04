package tictactoe.game;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row and column (space-separated): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }
}
