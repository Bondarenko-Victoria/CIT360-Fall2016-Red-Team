package Collections;


public class Game {
    int gameScore;
    String where;

    public Game() {
        this.gameScore = 0;
        this.where = "";

    }

    public Game(int score, String place)
    {
        this.gameScore = score;
        this.where = place;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }


}
