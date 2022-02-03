import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitTestSuite {
    @Test
    public void AIStaysIfScore21() {
        // creating new game with 4 players
        Game game = new Game();
        game.TOTAL_PLAYERS = 4;
        game.resetGame();

        // assigning AI AC and KH to score 21
        Player AI = game.players.get(game.AI_PLAYER);
        game.emptyPlayerHand(AI);
        game.assignCardToPlayer(AI, new Card("A", "C"));
        game.assignCardToPlayer(AI, new Card("K", "H"));
        game.updatePlayerScores();
        assertEquals(21, AI.getScore());
        System.out.println(game);

        // player 1 and 2 stays
        game.stay();
        game.stay();

        game.nextRound();

        // ensuring AI stayed
        <1> // missing assert
        System.out.println(game);
        System.out.println(game.getGameResults());
    }


    @Test
    public void aceScores() {
        // creating new game with 4 players
        Game game = new Game();
        game.TOTAL_PLAYERS = 4;
        game.resetGame();

        // assigning cards to players
        Player player1 = game.players.get(0);
        Player player2 = game.players.get(1);
        Player AI = game.players.get(game.AI_PLAYER);
        game.emptyPlayerHand(player1);
        game.assignCardToPlayer(player1, new Card("A", "C"));
        game.assignCardToPlayer(player1, new Card("3", "S"));
        game.assignCardToPlayer(player1, new Card("8", "H"));
        game.updatePlayerScores();
        // check score of player 1 
        <2> //missing assert

        game.emptyPlayerHand(player2);
        game.assignCardToPlayer(player2, new Card("A", "S"));
        game.assignCardToPlayer(player2, new Card("A", "D"));
        game.updatePlayerScores();
        // check score of player 2 
        <3> //missing assert

        game.emptyPlayerHand(AI);
        game.assignCardToPlayer(AI, new Card("A", "H"));
        game.assignCardToPlayer(AI, new Card("Q", "D"));
        game.updatePlayerScores();
        // check score of AI 
        <4> //missing assert
        System.out.println(game);
    }
}

//add here a test method to test the dealers hits when it has a hand value of less than 17
<5>
