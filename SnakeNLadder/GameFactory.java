import java.util.*;

public class GameFactory {

    public static Game createGame(
            int n,
            List<String> playerIds,
            SnakeGenStrategy snakeStrategy,
            LadderGenStrategy ladderStrategy) {
        int boardSize = n * n;

        Board board = BoardFactory.createBoard(n, n, n, snakeStrategy, ladderStrategy);

        List<Player> players = new ArrayList<>();
        for (String id : playerIds) {
            players.add(new Player(id));
        }

        return new Game(players, board, boardSize);
    }
}