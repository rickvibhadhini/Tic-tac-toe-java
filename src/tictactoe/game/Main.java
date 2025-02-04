//package tictactoe.game;
//
//import tictactoe.game.TicTacToe;
//import tictactoe.game.Bot;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Input Board Size
//        System.out.print("Enter the board size (e.g., 3 for a 3x3 board): ");
//        int boardSize = scanner.nextInt();
//
//        if (boardSize < 3) {
//            System.out.println("Board size must be at least 3. Defaulting to 3x3.");
//            boardSize = 3;
//        }
//
//        // Input Number of Players
//        System.out.print("Enter the total number of players (minimum 2): ");
//        int numPlayers = scanner.nextInt();
//
//        if (numPlayers < 2) {
//            System.out.println("Number of players must be at least 2. Defaulting to 2 players.");
//            numPlayers = 2;
//        }
//
//        // Input Player and Bot Details
//        List<String> players = new ArrayList<>();
//        List<Boolean> isBot = new ArrayList<>();
//        for (int i = 1; i <= numPlayers; i++) {
//            System.out.print("Is Player " + i + " a bot? (yes/no): ");
//            String botInput = scanner.next().toLowerCase();
//
//            if (botInput.equals("yes")) {
//                players.add("Bot " + i);
//                isBot.add(true);
//            } else {
//                System.out.print("Enter name for Player " + i + ": ");
//                String playerName = scanner.next();
//                players.add(playerName);
//                isBot.add(false);
//            }
//        }
//
//        // Print the game setup
//        System.out.println("\nGame Setup:");
//        System.out.println("Board Size: " + boardSize + "x" + boardSize);
//        System.out.println("Players:");
//        for (int i = 0; i < players.size(); i++) {
//            String playerType = isBot.get(i) ? "(Bot)" : "(Human)";
//            System.out.println("Player " + (i + 1) + ": " + players.get(i) + " " + playerType);
//        }
//
//        // Initialize and start the game
//        TicTacToe game = new TicTacToe(boardSize, players, isBot);
//        game.start();
//
//        scanner.close();
//    }
//}


package tictactoe.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Board Size
        System.out.print("Enter the board size (e.g., 3 for a 3x3 board): ");
        int boardSize = scanner.nextInt();
        if (boardSize < 3) {
            System.out.println("Board size must be at least 3. Defaulting to 3x3.");
            boardSize = 3;
        }

        // Input Number of Players
        System.out.print("Enter the total number of players (minimum 2): ");
        int numPlayers = scanner.nextInt();
        if (numPlayers < 2) {
            System.out.println("Number of players must be at least 2. Defaulting to 2 players.");
            numPlayers = 2;
        }

        // Input Player and Bot Details
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Is Player " + (i + 1) + " a bot? (yes/no): ");
            boolean isBot = scanner.next().equalsIgnoreCase("yes");

            String name = isBot ? "Bot " + (i + 1) : "Player " + (i + 1);
            players.add(PlayerFactory.createPlayer(name, isBot, i));
        }

        // Print the game setup
        System.out.println("\nGame Setup:");
        System.out.println("Board Size: " + boardSize + "x" + boardSize);
        System.out.println("Players:");
        for (Player player : players) {
            System.out.println(player.getName() + " (" + player.getSymbol() + ")");
        }

        // Initialize and start the game
        TicTacToe game = new TicTacToe(boardSize, players);
        game.start();

        scanner.close();
    }
}

