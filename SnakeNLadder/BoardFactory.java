import java.util.*;

class BoardFactory {

    public static Board createBoard(
            int n,
            int numSnakes,
            int numLadders,
            SnakeGenStrategy snakeStrategy,
            LadderGenStrategy ladderStrategy
    ) {
        int boardSize = n * n;
        Map<Integer, IGameObject> jumps = new HashMap<>();

        Set<Integer> used = new HashSet<>();

        List<Snake> snakes = snakeStrategy.generate(boardSize, numSnakes);
        for (Snake s : snakes) {
            jumps.put(s.getStart(), s);
            used.add(s.getStart());
            used.add(s.getEnd());
        }

        List<Ladder> ladders = ladderStrategy.generate(boardSize, numLadders, used);
        for (Ladder l : ladders) {
            jumps.put(l.getStart(), l);
        }

        return new Board(jumps);
    }
}