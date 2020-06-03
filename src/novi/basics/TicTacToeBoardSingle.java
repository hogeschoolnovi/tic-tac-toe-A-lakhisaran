package novi.basics;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static novi.basics.Main.USERINPUT;

public class TicTacToeBoardSingle extends TicTacToeBoard {
        public void startBoard() {
        setBoard();

        System.out.println("Welcome to TicTacToe");
    }

    public void playerTurn(Player currentPlayer, Player player1) {
        showBoard();
        boolean tokenSet = false;
        while(!tokenSet) {
            int chosenSpace;
            System.out.println("Player " + currentPlayer.getPlayerName() + " please choose a tile");
            if (currentPlayer == player1) {
                chosenSpace = USERINPUT.nextInt();
            }
            else {
//                chosenSpace = ThreadLocalRandom.current().nextInt(1, 9 + 1);
                chosenSpace = superDuperAI();
                // System.out.println(chosenSpace);
            }
            tokenSet = setToken(currentPlayer, chosenSpace);
        }
    }

    public int superDuperAI() {
        int aiChosenInt = 0;
        if (places.get(4) == '5') {
            aiChosenInt = 5;
        }
        else if (places.get(0) == '1') {
            aiChosenInt = 1;
        }
        else if (places.get(2) == '3') {
            aiChosenInt = 3;
        }
        else {
            aiChosenInt = ThreadLocalRandom.current().nextInt(1, 9 + 1);
        }
        return aiChosenInt;
    }
}