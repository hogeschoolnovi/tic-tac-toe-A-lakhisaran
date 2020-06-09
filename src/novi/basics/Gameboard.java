package novi.basics;

import java.io.Serializable;

//Waarom serializable?
public interface Gameboard extends Serializable {
    void startBoard();

    void playerTurn(Player currentPlayer, Player player1);
    Player switchPlayer(Player current, Player player1, Player player2);
    void showResults(Player player1, Player player2);
    boolean checkWin(Player currentPlayer);
}
