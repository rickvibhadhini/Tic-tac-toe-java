package tictactoe.game;

public class PlayerFactory {

    public static Player createPlayer(String name, boolean isBot, int playerIndex) {
        if (isBot) {
            return new BotPlayer(name, getPlayerSymbol(playerIndex));
        } else {
            return new HumanPlayer(name, getPlayerSymbol(playerIndex));
        }
    }

    private static char getPlayerSymbol(int playerIndex) {
        return (char) ('X' + playerIndex); // Assigns symbols like 'X', 'Y', 'Z', etc.
    }
}
