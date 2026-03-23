import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> playerIds = Arrays.asList("P1", "P2");

        SnakeGenStrategy snakeStrategy = new RandomSnakeGenStrategy();
        LadderGenStrategy ladderStrategy = new RandomLadderGenStrategy();

        Game game = GameFactory.createGame(
                10,
                playerIds,
                snakeStrategy,
                ladderStrategy
        );

        game.startGame();
    }
}