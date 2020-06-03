package novi.basics;

import java.io.*;

import static novi.basics.Main.USERINPUT;

public class Game implements Serializable {
    private Player player1;
    private Player player2;
    private TicTacToeBoard gameboard;

    public Game(Player player1, Player player2, TicTacToeBoard gameBoard) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameboard = gameBoard;
    }

    public void play() {
        Player currentPlayer = player1;
        boolean exitGame;
        do {
            gameboard.startBoard();

            boolean gameIsWon = false;
            while (!gameIsWon) {
                gameboard.playerTurn(currentPlayer, player1);
                gameIsWon = gameboard.checkWin(currentPlayer);
                currentPlayer = gameboard.switchPlayer(currentPlayer, player1, player2);
            }
            gameboard.showResults(player1, player2);
            gameboard.resetBoard();
//            currentPlayer = gameboard.switchPlayer(currentPlayer, player1, player2);
            exitGame = exit();
        }
        while (!exitGame);
    }

    public boolean exit() {
        System.out.println("Do you want to continue? y/n");
        String answer = USERINPUT.next();
        System.out.println("You answered: " + answer);
        if (answer.equals("y")){
            System.out.println("Let's continue");
            return false;
        }
        else {
            return true;
        }
    }
}
