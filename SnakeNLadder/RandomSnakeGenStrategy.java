import java.util.*;

class RandomSnakeGenStrategy implements SnakeGenStrategy {

    public List<Snake> generate(int boardSize, int numberOfSnakes) {
        List<Snake> snakes = new ArrayList<>();
        Random random = new Random();
        Set<Integer> used = new HashSet<>();

        while (snakes.size() < numberOfSnakes) {
            int start = random.nextInt(boardSize - 1) + 2;
            int end = random.nextInt(start - 1) + 1;

            if (used.contains(start) || used.contains(end)) continue;

            snakes.add(new Snake(start, end));

            used.add(start);
            used.add(end);
        }

        return snakes;
    }
}