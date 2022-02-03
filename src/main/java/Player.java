import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    int playerNo;
    ArrayList<Card> hand;
    int score;

    public Player(int playerNo) {
        this.playerNo = playerNo;
        hand = new ArrayList<>();
        score = 0;
    }

    public int getPlayerNo() {
        return playerNo;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
