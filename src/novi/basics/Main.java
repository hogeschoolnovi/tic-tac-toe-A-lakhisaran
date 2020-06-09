package novi.basics;

//Vergeet niet ongebruikte imports te verwijderen.
// Zelfde geldt voor uitgecommentarieerde code. Gewoon weghalen.

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	// Setup scanner to get user input
	// Het is good practise om dit altijd final te maken.
	// Daarnaast public???
	public static Scanner USERINPUT = new Scanner(System.in);

	public static void main(String[] args) {
		String test = "ABC";
		test = test.toLowerCase();
		System.out.println(test);
		Player player1 = null; // Ik zou de = null weglaten.
		Player player2 = null;
//		Gameboard gameBoard = null;
		// Get user input and create players
		System.out.println("Hi there, do you want a (s)ingle or a (m)ultiplayer game?");
		String answer = USERINPUT.next();

		if (answer.equals("s")) { // Kan evt. equalsIgnoreCase
			player2 = new Player("AI", 0, 'o');
			TicTacToeBoardSingle gameBoard = new TicTacToeBoardSingle();
			System.out.println("Player 1, please input your name");
			String playerName1 = USERINPUT.next();
			player1 = new Player(playerName1, 0, 'x');
			Game game = new Game(player1, player2, gameBoard);
			game.play();
		} else {
			System.out.println("Player 1, please input your name");
			String playerName1 = USERINPUT.next();
			System.out.println("Player 2, please input your name");
			String playerName2 = USERINPUT.next();
			player1 = new Player(playerName1, 0, 'x');
			player2 = new Player(playerName2, 0, 'o');
			TicTacToeBoard gameBoard = new TicTacToeBoard();
			Game game = new Game(player1, player2, gameBoard);
			game.play();
			// FileHandler fh = new FileHandler();
			// fh.save(game);
			// fh.load();

		}
		// Pick a game, create gameboard


		// Create game and play

	}
}
