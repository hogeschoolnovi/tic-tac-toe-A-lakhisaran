package novi.basics;

import java.io.Serializable;

// Waarom serializable?
public class Player implements Serializable {
    private String playerName;
    private int score;
    private char playerToken;

    // ongebruikte code
    public Player() {

    }

    public Player(String playerName, int score, char playerToken) {
        this.playerName = playerName;
        this.score = score;
        this.playerToken = playerToken;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void showScore() {
        System.out.println("Player " + playerName + " has scored " + this.score + " points");
    }

    public char getToken() {
        return this.playerToken;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore() {
        score++;
    }

}

