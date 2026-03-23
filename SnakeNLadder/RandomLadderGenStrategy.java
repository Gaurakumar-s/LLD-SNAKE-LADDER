import java.util.*;

class RandomLadderGenStrategy implements LadderGenStrategy {

    public List<Ladder> generate(int boardSize, int numberOfLadders, Set<Integer> used) {
        List<Ladder> ladders = new ArrayList<>();
        Random random = new Random();

        while (ladders.size() < numberOfLadders) {
            int start = random.nextInt(boardSize - 1) + 1;
            int end = random.nextInt(boardSize - start) + start + 1;

            if (used.contains(start) || used.contains(end)) continue;

            ladders.add(new Ladder(start, end));

            used.add(start);
            used.add(end);
        }

        return ladders;
    }
}