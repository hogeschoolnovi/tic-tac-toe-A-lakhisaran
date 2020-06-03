package novi.basics;

import java.util.ArrayList;

import static novi.basics.Main.USERINPUT;

public class TicTacToeBoard implements Gameboard {
    protected ArrayList<Character> places;
    private int playedTurns;
    boolean gameWon;
    private int draws;

    public TicTacToeBoard() {
        this.places = new ArrayList<Character>();
        setBoard();
        this.playedTurns = 0;
        this.gameWon = false;
        this.draws = 0;
    }

    public void startBoard() {
        setBoard();
        System.out.println("Welcome to TicTacToe");
    }

    public void showBoard() {
        for (int i = 0; i < 9; i+=3) {
            System.out.println(places.get(i) + " " + places.get(i+1) + " " + places.get(i+2));
        }
    }

    public void setBoard() {
        for (int i = 0; i < 9; i++ ) {
            // i + 1 to get the value for the board instead of an index
            //char + '0' to get the int value as a char, instead of corresponding ascii value
            places.add(i, (char)((i + 1) + '0'));
        }
    }

    public boolean setToken(Player player, int position) {
        if (isLegalMove(position)) {
            System.out.println(places.get(position - 1));
            places.set(position - 1, player.getToken());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isLegalMove(int position) {
        return !places.get(position - 1).equals('x') && !places.get(position - 1).equals('o');
    }

    public boolean checkWin(Player currentPlayer) {
        //earliest possible win at 3 turns
        //check 1 2 3
        if(places.get(0) == places.get(1) && places.get(0) == places.get(2)) {
            currentPlayer.setScore();
            gameWon = true;
        }
        //check 4 5 6
        if(places.get(3) == places.get(4) && places.get(3) == places.get(5)) {
            currentPlayer.setScore();
            gameWon = true;
        }
        //check 7 8 9
        if(places.get(6) == places.get(7) && places.get(6) == places.get(8)) {
            currentPlayer.setScore();
            gameWon = true;
        }
        //check 1 4 7
        if(places.get(0) == places.get(3) && places.get(0) == places.get(6)) {
            currentPlayer.setScore();
            gameWon = true;
        }
        //check 2 5 8
        if(places.get(1) == places.get(4) && places.get(1) == places.get(7)) {
            currentPlayer.setScore();
            gameWon = true;
        }
        //check 3 6 9
        if(places.get(2) == places.get(5) && places.get(2) == places.get(8)) {
            currentPlayer.setScore();
            gameWon = true;
        }
        //check 1 5 9
        if(places.get(0) == places.get(4) && places.get(0) == places.get(8)) {
            currentPlayer.setScore();
            gameWon = true;
        }
        //check 3 5 7
        if(places.get(2) == places.get(4) && places.get(2) == places.get(6)) {
            currentPlayer.setScore();
            gameWon = true;
        }
        playedTurns++;
        if (playedTurns == 9 && !gameWon) {
            setDraws();
            gameWon = true;
        }

        return gameWon;
    }

    public void resetBoard() {
        places.clear();
        playedTurns = 0;
        setBoard();
        gameWon = false;
        System.out.println("Board has been reset!");
    }

    public Player switchPlayer(Player current, Player player1, Player player2) {
        if (current == player1) {
           current = player2;
           return current;
        }
        else {
            current = player1;
            return current;
        }

    }

    public int getDraws() {
        return this.draws;
    }

    public void setDraws() {
        draws++;
    }

    public void showDraws() {
        System.out.println("There are currently " + getDraws() + " draws");
    }

    public void showResults(Player player1, Player player2) {
        player1.showScore();
        player2.showScore();
        showDraws();
    }

    public void playerTurn(Player currentPlayer, Player player1) {
        showBoard();

        boolean tokenSet = false;
        while(!tokenSet) {
            System.out.println("Player " + currentPlayer.getPlayerName() + " please choose a tile");
            int chosenSpace = USERINPUT.nextInt();
            tokenSet = setToken(currentPlayer, chosenSpace);
        }
    }


}
